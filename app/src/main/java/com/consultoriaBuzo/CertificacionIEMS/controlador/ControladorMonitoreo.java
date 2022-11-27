package com.consultoriaBuzo.CertificacionIEMS.controlador;

import com.consultoriaBuzo.CertificacionIEMS.dao.EstudianteDAO;
import com.consultoriaBuzo.CertificacionIEMS.dao.EstudianteDAOImplementacion;
import com.consultoriaBuzo.CertificacionIEMS.modelo.Estudiante;
import com.consultoriaBuzo.CertificacionIEMS.modelo.aplicacion.CalculadoraDatasets;
import com.consultoriaBuzo.CertificacionIEMS.modelo.aplicacion.ManagerArchivos;
import com.consultoriaBuzo.CertificacionIEMS.modelo.aplicacion.MensajeModal;
import com.consultoriaBuzo.CertificacionIEMS.vista.VistaMonitoreo;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author Luis Alberto
 */
public class ControladorMonitoreo extends Controlador {

    private final ControladorMenuPrincipal padre;
    private final VistaMonitoreo vista;
    private boolean huboCambios;
    private List<Estudiante> lista;
    private final ManagerArchivos archivador;
    
    /**
     * Inicializa el controlador creando una nueva vista
     * @param ventana la ventana en la que se mostrará la vista
     * @param padre la ventana padre que invocó a este controlador y vista
     */
    public ControladorMonitoreo(JFrame ventana, ControladorMenuPrincipal padre){
        archivador = new ManagerArchivos();
        
        vista = new VistaMonitoreo();
        this.padre = padre;
        super.ventana = ventana;
        initVista();
    }
    
    @Override
    protected final void initVista() {
        JLabel label = vista.getLogotipo();
        JTabbedPane tabPanel = vista.getTabPanel();
        JButton boton = vista.getBtnAgregar();
        
        label.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                mostrarMenuPrincipal();
            }
        });
        
        tabPanel.addChangeListener((ChangeEvent e) -> {
            crearGraficas();
        });
        
        boton.addActionListener((ActionEvent e) -> {
            agregarEstudiante();
        });
        
        boton = vista.getBtnEliminar();
        boton.addActionListener((ActionEvent e) -> {
            eliminarEstudiante();
        });
        
        initTabla();
    }

    @Override
    protected final void clearVista() {
        JTextField txtField = vista.getTxtFMatricula();
        
        txtField.setText("");
    }
    
    /**
     * Muestra la ventana del menú principal
     */
    private void mostrarMenuPrincipal(){
        JTabbedPane tabPanel = vista.getTabPanel();
        
        mostrar(padre.getVista());
        clearVista();
        tabPanel.setSelectedIndex(0);
        
    }
    
    /**
     * Obtiene la vista asociada al controlador
     * @return la vista del controlador
     */
    public VistaMonitoreo getVista() {
        return vista;
    }
    
    /**
     * Inicializa la tabla con la lista de los posibles egresados
     */
    private void initTabla(){
        JTable tabla = vista.getTablaEstudiantes();
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        EstudianteDAO dao = new EstudianteDAOImplementacion();
        Object datos[];
        int columnas = 6;
        
        if (archivador.existeArchivo("candidatos.txt")){
            try {
                lista = archivador.obtenerCandidatos();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ControladorMonitoreo.class.getName()).log(
                        Level.SEVERE, null, ex);
                lista = dao.getPosiblesEgresados();
            }
        }else{
            lista = dao.getPosiblesEgresados();
        }
        
        datos = new Object[columnas];
        for (Estudiante e : lista){
            datos[0] = e.getMatricula();
            datos[1] = e.getApellidoP();
            datos[2] = e.getApellidoM();
            datos[3] = e.getNombre();
            datos[4] = e.getCubiertas();
            datos[5] = e.getReinscritas();
            modelo.addRow(datos);
        }
        
        huboCambios = true;
    }
    
    /**
     * Crea las todas las gráficas con la información de lista si es que ha 
     * habido algún cambio en la tabla
     */
    private void crearGraficas(){
        if (huboCambios){
            crearGraficaCandidatos();
            crearGraficaMateriasPastel();
            crearGraficaMateriasBarras();
            
            huboCambios = false;
        }
    }

    /**
     * Crea la gráfica de pastel con los estudiantes que sean candidatos a 
     * egresar, diferenciandolos por turno
     */
    private void crearGraficaCandidatos() {
        PieDataset dataset = CalculadoraDatasets.
                generarDatasetCandidatosPastel(lista);
        JFreeChart grafica = ChartFactory.createPieChart("Candidatos a egreso",
                dataset);
        PieSectionLabelGenerator generador = 
                new StandardPieSectionLabelGenerator("{1}",
                new DecimalFormat("0"), new DecimalFormat("0%"));
        PiePlot plot = (PiePlot)grafica.getPlot();
        JPanel panelVista = vista.getPanelGraficaEgresados();
        ChartPanel panelGrafica = new ChartPanel(grafica);
        
        plot.setLabelGenerator(generador);
        plot.setSimpleLabels(true);
        plot.setCircular(true);
        plot.setIgnoreZeroValues(true);
        
        if (panelVista.getComponentCount() > 0){
            panelVista.removeAll();
        }
        panelVista.add(panelGrafica);
        panelGrafica.setSize((int) panelVista.getSize().getWidth(), 
                (int) panelVista.getSize().getHeight() - 20);
        
    }
    
    /**
     * Crea la gráfica de pastel sobre el progreso de los estudiantes candidatos
     * a egresar, por cantidad de asignaturas cubiertas.
     */
    private void crearGraficaMateriasPastel() {
        PieDataset dataset = CalculadoraDatasets.
                generarDatasetMateriasPastel(lista);
        JFreeChart grafica = ChartFactory.createPieChart("Progreso por "
                + "materias cubiertas",dataset);
        PieSectionLabelGenerator generador = 
                new StandardPieSectionLabelGenerator("{0} cubiertas: {1}",
                new DecimalFormat("0"), new DecimalFormat("0%"));
        PiePlot plot = (PiePlot)grafica.getPlot();
        JPanel panelVista = vista.getPanelGraficaMateriasPastel();
        ChartPanel panelGrafica = new ChartPanel(grafica);
        
        plot.setLabelGenerator(generador);
        plot.setCircular(true);
        plot.setIgnoreZeroValues(true);
        plot.setExplodePercent("28", 0.2);
        plot.setExplodePercent("29", 0.2);
        if (panelVista.getComponentCount() > 0){
            panelVista.removeAll();
        }
        panelVista.add(panelGrafica);
        panelGrafica.setSize((int) panelVista.getSize().getWidth(), 
                (int) panelVista.getSize().getHeight() - 20);
    }

    /**
     * Crea la gráfica de barras sobre el progreso de los estudiantes candidatos
     * a egresar, por cantidad de asignaturas cubiertas y turnos.
     */
    private void crearGraficaMateriasBarras() {
        CategoryDataset dataset = CalculadoraDatasets.
                generarDatasetMateriasBarras(lista);
	JFreeChart grafica = ChartFactory.createBarChart("Progreso por materias"
                + " cubiertas por turnos", "Materias cubiertas", "Estudiantes",
                dataset);
	JPanel panelVista = vista.getPanelGraficaMateriasBarras();
	ChartPanel panelGrafica = new ChartPanel(grafica);
        CategoryPlot plot = (CategoryPlot)grafica.getPlot();
        BarRenderer render = (BarRenderer) plot.getRenderer();
        
        render.setItemMargin(0.05);
        
        if (panelVista.getComponentCount() > 0){
            panelVista.removeAll();
        }
	panelVista.add(panelGrafica);
        panelGrafica.setSize((int) panelVista.getSize().getWidth(), 
                (int) panelVista.getSize().getHeight() - 20);
    }
    
    /**
     * Busca la información del estudiante con la matrícula que está en el 
     * campo de texto y lo agrega a la tabla
     * Nota: La lista de estudiantes debería estar ordenada con anterioridad
     */
    private void agregarEstudiante(){
        JTextField txtField = vista.getTxtFMatricula();
        String matricula = txtField.getText();
        EstudianteDAO dao = new EstudianteDAOImplementacion();
        Estudiante estudiante;
        MensajeModal mensaje = new MensajeModal(ventana);
        int i = 0;
        
        if (matricula.equals("")){   
            mensaje.mostrarMensaje("ERROR", "Ingresa una matrícula");
            return;
        }
        
        estudiante = dao.getEstudiante(matricula);
        if (estudiante == null){
            mensaje.mostrarMensaje("ERROR", "No se encontró al estudiante con "
                    + "matrícula " + matricula);
            return;
        }
        
        for (Estudiante e: lista){
            if (e.getMatricula().equals(matricula)){
                mensaje.mostrarMensaje("Advertencia", "El estudiante ya se "
                        + "encuentra en la tabla de candidatos");
                return;
            }
            if (e.getMatricula().compareTo(matricula) > 0){
                break;
            }else{
                i++;   
            }
        }
        
        agregarEstudianteTabla(i, estudiante);
        lista.add(i,estudiante);
        guardarCandidatos();
    }
    
    /**
     * Agrega un estudiante a la tabla en el lugar dado
     * @param index el índice donde se quiere coloar el estudiante
     * @param est el estudiante a colocar
     */
    private void agregarEstudianteTabla(int index, Estudiante est){
        JTable tabla = vista.getTablaEstudiantes();
        Object datos[];
        int columnas = 6;
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        
        datos = new Object[columnas];
        datos[0] = est.getMatricula();
        datos[1] = est.getApellidoP();
        datos[2] = est.getApellidoM();
        datos[3] = est.getNombre();
        datos[4] = est.getCubiertas();
        datos[5] = est.getReinscritas();
        
        modelo.insertRow(index,datos);
        huboCambios = true;
        clearVista();
    }
    
    /**
     * Guarda la lista de estudiantes en un archivo localizado en
     * C
     */
    private void guardarCandidatos(){
        MensajeModal mensaje = new MensajeModal(ventana);
        try {
            archivador.guardarCandidatos(lista);
        } catch (IOException ex) {
            Logger.getLogger(ControladorMonitoreo.class.getName()).log(
                    Level.SEVERE, null, ex);
            mensaje.mostrarMensaje("ERROR", "Hubo un error al guardar localmente"
                    + " los cambios");
        }
    }
    
    /**
     * Eliimina al estudiante seleccionado de la tabla
     */
    private void eliminarEstudiante(){
        JTable tabla = vista.getTablaEstudiantes();
        MensajeModal mensaje = new MensajeModal(ventana);
        DefaultTableModel model;
        int fila = tabla.getSelectedRow();
        
        if (fila == -1){
            mensaje.mostrarMensaje("Advertencia", "Selecciona un estudiante"
                    + " para eliminarlo");
            return;
        }
        
        model = (DefaultTableModel)tabla.getModel();
        model.removeRow(fila);
        lista.remove(fila);
        huboCambios = true;
        
        try {
            archivador.guardarCandidatos(lista);
        } catch (IOException ex) {
            Logger.getLogger(ControladorMonitoreo.class.getName()).log(
                    Level.SEVERE, null, ex);
            mensaje.mostrarMensaje("ERROR", "Hubo un error al guardar "
                    + "localmente los cambios");
        }
    }
    
    /**
     * Actualiza la tabla, para casos en los que el controlador y la vista ya 
     * hayan cargados pero hubo cambios en la base de datos
     */
    public void actualizarVista(){
        JTable tabla = vista.getTablaEstudiantes();
        DefaultTableModel model = (DefaultTableModel)tabla.getModel();
        int i;
        
        for (i = model.getRowCount(); i > 0; i--){
            model.removeRow(i - 1);
        }
        
        initTabla();
        huboCambios = true;
    }
}

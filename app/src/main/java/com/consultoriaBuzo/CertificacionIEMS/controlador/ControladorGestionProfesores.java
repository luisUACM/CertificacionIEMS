package com.consultoriaBuzo.CertificacionIEMS.controlador;

import com.consultoriaBuzo.CertificacionIEMS.dao.AsesorDAO;
import com.consultoriaBuzo.CertificacionIEMS.dao.AsesorDAOImplementacion;
import com.consultoriaBuzo.CertificacionIEMS.dao.DTIDAO;
import com.consultoriaBuzo.CertificacionIEMS.modelo.Academia;
import com.consultoriaBuzo.CertificacionIEMS.modelo.Profesor;
import com.consultoriaBuzo.CertificacionIEMS.dao.DTIDAOImplementacion;
import com.consultoriaBuzo.CertificacionIEMS.modelo.aplicacion.MensajeModal;
import com.consultoriaBuzo.CertificacionIEMS.vista.VistaGestionProfesores;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Luis Alberto
 */
public class ControladorGestionProfesores extends Controlador{
    private final ControladorMenuPrincipal padre;
    private final VistaGestionProfesores vista;
    private final List<Profesor> listaProfesoresSeleccionados;
    private final List<Integer> listaFilasModificadas;
    
    /**
     * Constructor que crea una nueva vista del tipo VentanaGestionProfesores
     * y la asigna a la variable
     * @param ventana la ventana que mostrará la vista
     * @param padre la ventana padre que invocó a este controlador y vista
     */
    public ControladorGestionProfesores(JFrame ventana, ControladorMenuPrincipal padre) {
        vista = new VistaGestionProfesores();
        super.ventana = ventana;
        this.padre = padre;
        listaProfesoresSeleccionados = new ArrayList<>();
        listaFilasModificadas = new ArrayList<>();
        initVista();
    }
    
    /**
     * Inicializa la vista estableciendo los métodos que los controles 
     * ejecuten cuando haya un evento
     */
    @Override
    protected final void initVista(){
        JButton boton = vista.getBotonGuardar();
        JTable tabla = vista.getTablaProfesores();
        JRadioButton radioBoton = vista.getRadioBotonDTI();
        JLabel label = vista.getLogotipo();
        
        boton.addActionListener((ActionEvent e) -> {
            guardarCambios();
        });
        
        boton = vista.getBotonRegistrar();
        boton.addActionListener((ActionEvent e) -> {
            registrarProfesor();
        });
        
        radioBoton.addActionListener((ActionEvent e) -> {
            seleccionarModalidadEscolar();
        });
        
        radioBoton = vista.getRadioBotonAsesor();
        radioBoton.addActionListener((ActionEvent e) -> {
            seleccionarModalidadSemi();
        });
        
        tabla.getSelectionModel().addListSelectionListener(
                (ListSelectionEvent e) -> {seleccionarProfesor();});
                
        vista.getComboBoxAcademia().setModel(
                new DefaultComboBoxModel(Academia.values()));
        
        label.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                mostrarMenuPrincipal();
            }
        });
        
        initTabla();
    }
    
    /**
     * Guarda los cambios realizados en los profesores actualizando sus registros
     */
    private void guardarCambios(){
        JTable tabla = vista.getTablaProfesores();
        Profesor profeSinModificar;
        Profesor profeModificado;
        String nombre;
        Academia academia;
        char turno;
        boolean activo;
        int fila;
        
        if (tabla.getCellEditor() != null){
            tabla.getCellEditor().stopCellEditing();
        }
        
        for (int i = 0; i < listaFilasModificadas.size(); i ++){
            fila = listaFilasModificadas.get(i);
            profeSinModificar = listaProfesoresSeleccionados.get(i);
            nombre = (String) tabla.getValueAt(fila, 0);
            academia = (Academia) tabla.getValueAt(fila, 1);
            turno = (char) tabla.getValueAt(fila, 2);
            activo = (boolean) tabla.getValueAt(fila, 3);
            
            if (profeSinModificar.getNombre().compareTo(nombre) != 0
                    || profeSinModificar.getAcademia() != academia
                    || profeSinModificar.getTurno() != turno
                    || profeSinModificar.getActivo() != activo){
                
                //Fue modificado
                if (turno == ' '){
                    //Asesor
                    AsesorDAO dao = new AsesorDAOImplementacion();
                    Profesor asesor = dao.getAsesor(profeSinModificar.getNombre());
                    
                    profeModificado = new Profesor(asesor.getId(), nombre, 
                            academia, activo);
                    dao.updateAsesor(profeModificado);
                }else{
                    //DTI
                    DTIDAO dao = new DTIDAOImplementacion();
                    Profesor dti = dao.getDTI(profeSinModificar.getNombre());
                    
                    profeModificado = new Profesor(dti.getId(), nombre, 
                            academia, turno, activo);
                    dao.updateDTI(profeModificado);
                }
            }
        }
    }
    
    /**
     * Agrega un profesor a la base de datos con los datos de los controles
     * en la tabla correspondiente
     */
    private void registrarProfesor(){
        Profesor prof = new Profesor();
        Academia academia = Academia.values()
                [vista.getComboBoxAcademia().getSelectedIndex()];
        String nombre = vista.getTextoNombre().getText();
        char c = vista.getComboBoxTurno().getSelectedItem().toString().charAt(0);
        MensajeModal mensaje = new MensajeModal(ventana);
        
        if (nombre.compareTo("") != 0){
            prof.setNombre(nombre);
        }else{
            mensaje.mostrarMensaje("ERROR", "Profesor sin nombre");
            return;
        }
        
        if (academia != Academia.NO_VALIDO){
            prof.setAcademia(academia);
        }else{
            mensaje.mostrarMensaje("ERROR", "Profesor sin academia");
            return;
        }
        
        prof.setTurno(c);
        
        if (vista.getRadioBotonDTI().isSelected()){
            if(c == ' '){
                mensaje.mostrarMensaje("ERROR", "DTI sin turno");
                return;
            }else{
                DTIDAO dao = new DTIDAOImplementacion();
                dao.addDTI(prof);
                mensaje.mostrarMensaje("Éxito", "DTI registrado con éxito");
            }
            
        }else if (vista.getRadioBotonAsesor().isSelected()){
            AsesorDAO dao = new AsesorDAOImplementacion();
            dao.addAsesor(prof);
            mensaje.mostrarMensaje("Éxito", "Asesor registrado con éxito");
        }else{
            mensaje.mostrarMensaje("ERROR", "Sin tipo de profesor");
            return;
        }
        clearVista();
        actualizarTabla(prof);
    }
    
    /**
     * Actualiza los radiobotones para que solo esté seleccionado el de DTI
     * y activa la caja de turno en consecuencia
     */
    private void seleccionarModalidadEscolar(){
        JRadioButton botonAsesor = vista.getRadioBotonAsesor();
        JComboBox cajaTurno = vista.getComboBoxTurno();
        
        botonAsesor.setSelected(false);
        cajaTurno.setEnabled(true);
    }
    
    /**
     * Actualiza los radiobotones para que solo esté seleccionado el de asesor
     * y desactiva la caja de turno en consecuencia
     */
    private void seleccionarModalidadSemi(){
        JRadioButton botonDTI = vista.getRadioBotonDTI();
        JComboBox cajaTurno = vista.getComboBoxTurno();
        
        botonDTI.setSelected(false);
        cajaTurno.setEnabled(false);
        cajaTurno.setSelectedIndex(0);
    }
    
    /**
     * Inicializa la JTable de la vista con los valores de la base de datos
     */
    private void initTabla(){
        JTable tabla = vista.getTablaProfesores();
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        List<Profesor> listaCompleta;
        List<Profesor> lista2;
        DTIDAO daoDti = new DTIDAOImplementacion();
        AsesorDAO daoAsesor = new AsesorDAOImplementacion();
        Object datos[];
        JComboBox cajaAcademia = new JComboBox();
        JComboBox cajaTurno = new JComboBox();
        int columnas = 4;
        TableColumn columna;
                
        listaCompleta = daoDti.getAll();
        lista2 = daoAsesor.getAll();
        for (Profesor p: lista2){
            listaCompleta.add(p);
        }
        
        datos = new Object[columnas];
        for (Profesor p : listaCompleta){
            datos[0] = p.getNombre();
            datos[1]= p.getAcademia();
            datos[2]= p.getTurno();
            datos[3]= p.getActivo();
            modelo.addRow(datos);
        }
        
        cajaAcademia.setModel(new DefaultComboBoxModel(Academia.values()));
        columna = tabla.getColumnModel().getColumn(1);
        columna.setCellEditor(new DefaultCellEditor(cajaAcademia));
        
        cajaTurno.addItem(' ');
        cajaTurno.addItem('M');
        cajaTurno.addItem('V');
        columna = tabla.getColumnModel().getColumn(2);
        columna.setCellEditor(new DefaultCellEditor(cajaTurno));
        
    }
    
    /**
     * Accion que ocurre cuando se selecciona una celda dentro de la tabla. 
     * Agrega los valores sin modificar a listaProfesoresSeleccionados
     */
    private void seleccionarProfesor(){
        JTable tabla = vista.getTablaProfesores();
        int fila = tabla.getSelectedRow();
        String nombre = (String) tabla.getValueAt(fila, 0);
        Academia academia = (Academia) tabla.getValueAt(fila, 1);
        char turno = (char) tabla.getValueAt(fila, 2);
        boolean activo = (boolean) tabla.getValueAt(fila, 3);
        
        Profesor profesor = new Profesor(0, nombre, academia, turno,
                activo);
        if(!listaProfesoresSeleccionados.isEmpty()){
            if(listaProfesoresSeleccionados.get(listaProfesoresSeleccionados.size() - 1)
                    .getNombre().compareTo(nombre) != 0){
                /*
                 * Dado que este método se llama 2 veces sin motivo aparente. Se 
                 * valida si es la segunda vez que se llamó al comparar el nombre 
                 * con el último profesor de la lista
                 */
                listaProfesoresSeleccionados.add(profesor);
                listaFilasModificadas.add(fila);
            }
        }else{
            listaProfesoresSeleccionados.add(profesor);
            listaFilasModificadas.add(fila);
        }
    }
    
    @Override
    protected void clearVista(){
        JTextField textF = vista.getTextoNombre();
        JComboBox comboBox = vista.getComboBoxAcademia();
        JRadioButton rBoton = vista.getRadioBotonAsesor();
        
        textF.setText("");
        comboBox.setSelectedIndex(0);
        comboBox = vista.getComboBoxTurno();
        comboBox.setSelectedIndex(0);
        rBoton.setSelected(false);
        rBoton = vista.getRadioBotonDTI();
        rBoton.setSelected(false);
        comboBox = vista.getComboBoxTurno();
        comboBox.setEnabled(true);
    }
    
    /**
     * Agrega el nuevo profesor registrado en la base de datos, a la tabla en
     * la vista (en su lugar correspondiente al orden alfabético)
     */
    private void actualizarTabla(Profesor prof){
        JTable tabla = vista.getTablaProfesores();
        Object datos[];
        int columnas = 4;
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int i;
        String nombre;
        int filas = modelo.getRowCount();
        int iniAsesores = filas;
        
        datos = new Object[columnas];
        datos[0] = prof.getNombre();
        datos[1]= prof.getAcademia();
        datos[2]= prof.getTurno();
        datos[3]= prof.getActivo();
        
        for (i = 0; i < filas; i++){
            if ((char)modelo.getValueAt(i,2) == ' '){
                iniAsesores = i;
                break;
            }
        }
        
        if (prof.getTurno() == ' '){
            for (i = iniAsesores; i < filas; i++){
                nombre = (String)modelo.getValueAt(i,0);
                if(nombre.compareTo(prof.getNombre()) > 0){
                    break;
                }
            }
        }else{
            for (i = 0; i < iniAsesores; i++){
                nombre = (String)modelo.getValueAt(i,0);
                if(nombre.compareTo(prof.getNombre()) > 0){
                    break;
                }
            }
        }
        modelo.insertRow(i,datos);
    }

    /**
     * Obtiene la vista asociada al controlador
     * @return la vista del controlador
     */
    public VistaGestionProfesores getVista() {
        return vista;
    }
    
    /**
     * Muestra la ventana del menú principal
     */
    private void mostrarMenuPrincipal(){
        mostrar(padre.getVista());
        clearVista();
    }
}

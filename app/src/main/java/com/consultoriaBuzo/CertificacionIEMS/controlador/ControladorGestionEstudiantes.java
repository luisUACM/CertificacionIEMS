package com.consultoriaBuzo.CertificacionIEMS.controlador;

import com.consultoriaBuzo.CertificacionIEMS.dao.EstudianteDAO;
import com.consultoriaBuzo.CertificacionIEMS.dao.EstudianteDAOImplementacion;
import com.consultoriaBuzo.CertificacionIEMS.modelo.Estudiante;
import com.consultoriaBuzo.CertificacionIEMS.modelo.Semestre;
import com.consultoriaBuzo.CertificacionIEMS.modelo.aplicacion.LectorConcentrado;
import com.consultoriaBuzo.CertificacionIEMS.modelo.aplicacion.MensajeModal;
import com.consultoriaBuzo.CertificacionIEMS.vista.VistaGestionEstudiantes;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author Luis Alberto
 */
public class ControladorGestionEstudiantes extends Controlador{
    private final ControladorMenuPrincipal padre;
    private final VistaGestionEstudiantes vista;
    private File concentrado;
    private Estudiante estudiante;

    /**
     * Inicializa el controlador creando una nueva vista
     * @param ventana la ventana que mostrará la vista
     * @param padre la ventana padre que invocó a este controlador y vista
     */
    public ControladorGestionEstudiantes(JFrame ventana, 
            ControladorMenuPrincipal padre) {
        vista = new VistaGestionEstudiantes();
        this.padre = padre;
        super.ventana = ventana;
        initVista();
        
        estudiante = new Estudiante();
    }
    
    /**
     * Inicializa la vista estableciendo los métodos que los controles 
     * ejecuten cuando haya un evento
     */
    @Override
    protected final void initVista(){
        JButton boton = vista.getBtnGuardar();
        JLabel label = vista.getLogotipo();
        JTextField texto = vista.getTextoMatricula();
        JComboBox caja = vista.getComboBoxSemestre();
        
        boton.addActionListener((ActionEvent e) -> {
            guardarCambios();
        });
        
        boton = vista.getBtnActualizar();
        boton.addActionListener((ActionEvent e) -> {
            actualizarBaseDatos();
        });
        
        boton = vista.getBtnBuscar();
        boton.addActionListener((ActionEvent e) -> {
            completarDatosEstudiante();
        });
        
        boton = vista.getBtnSeleccionar();
        boton.addActionListener((ActionEvent e) -> {
            seleccionarArchivo();
        });
        
        label.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                mostrarMenuPrincipal();
            }
        });
        
        texto.addActionListener((ActionEvent e) -> {
            completarDatosEstudiante();
        });
        
        caja.setModel(new DefaultComboBoxModel(Semestre.semestresValidos()));
        
        caja = vista.getComboBoxModalidad();
        caja.addActionListener((ActionEvent e) -> {
            seleccionarModalidad();
        });
        
        label = vista.getLblSemestre();
        label.setText(Semestre.calcularActual().toString());
    }

    /**
     * Guarda los datos de los campos de la vista en un nuevo estudiante.
     * Si no existe en la base de datos lo registra, si ya existe lo actualiza.
     */
    private void guardarCambios(){
        EstudianteDAO dao = new EstudianteDAOImplementacion();
        
        JTextField texto = vista.getTextoMatricula();
        JComboBox caja = vista.getComboBoxModalidad();
        JSpinner spiner = vista.getSpnCubiertas();
        String matricula;
        String nombre;
        String apellidoP;
        String apellidoM;
        int cubiertas;
        int reinscritas;
        Semestre semestre;
        char modalidad;
        char turno;
        MensajeModal mensaje = new MensajeModal(ventana);
        boolean exito;
        
        nombre = texto.getText();
        if (nombre.equals("")){
            mensaje.mostrarMensaje("ERROR", "El estudiante no tiene nombre");
            return;
        }else{
            estudiante.setNombre(nombre);
        }
        
        texto = vista.getTextoApellidoP();
        apellidoP = texto.getText();
        if (apellidoP.equals("")){
            mensaje.mostrarMensaje("ERROR", "El estudiante no tiene primer "
                    + "apellido");
            return;
        }else{
            estudiante.setApellidoP(apellidoP);
        }
        
        texto = vista.getTextoApellidoM();
        apellidoM = texto.getText();
        if (apellidoM.equals("")){
            mensaje.mostrarMensaje("ERROR", "El estudiante no tiene segundo "
                    + "apellido");
            return;
        }else{
            estudiante.setApellidoM(apellidoM);
        }
        
        texto = vista.getTextoMatricula();
        matricula = texto.getText();
        if (matricula.equals("")){
            mensaje.mostrarMensaje("ERROR", "El estudiante no tiene matrícula");
            return;
        }else{
            estudiante.setMatricula(matricula);
        }
        
        modalidad = caja.getSelectedItem().toString().charAt(0);
        if(modalidad != ' '){
            estudiante.setModalidad(modalidad);
        }else{
            mensaje.mostrarMensaje("ERROR", "El estudiante no tiene modalidad");
            return;
        }
        
        caja = vista.getComboBoxTurno();
        turno = caja.getSelectedItem().toString().charAt(0);
        estudiante.setTurno(turno);
            
        caja = vista.getComboBoxSemestre();
        semestre = (Semestre)caja.getSelectedItem();
        estudiante.setSemestre(semestre);
            
        cubiertas = (int)spiner.getValue();
        estudiante.setCubiertas(cubiertas);
            
        spiner = vista.getSpnReinscritas();
        reinscritas = (int)spiner.getValue();
        estudiante.setReinscritas(reinscritas);
        
        estudiante.setCubiertasFinal(cubiertas);
        estudiante.setActivo(true);
        
        if (dao.getEstudiante(estudiante.getMatricula()) != null){
            exito = dao.addEstudiante(estudiante);
            if (exito){
                mensaje.mostrarMensaje("Éxito", "Se ha registrado al estudiante"
                    + " correctamente");
            }else{
                mensaje.mostrarMensaje("ERROR", "Hubo un error al registrar al "
                        + "estudiante");
            }
        }else{
            exito = dao.updateEstudiante(estudiante);
            if (exito){
                mensaje.mostrarMensaje("Éxito", "Se ha actualizado al "
                        + "estudiante correctamente");
            }else{
                mensaje.mostrarMensaje("ERROR", "Hubo un error al actualizar "
                        + "al estudiante");
            }
        }
    }
    
    /**
     * Muestra la ventana de seleccion de archivos y establece el archivo
     * seleccionado en la variable concentrado.
     */
    private void seleccionarArchivo(){
        JFileChooser subVentana = vista.getVentanaFileChooser();
        JLabel lbl = vista.getLblNombreArchivo();
                
        subVentana.showOpenDialog(vista);
        concentrado = subVentana.getSelectedFile();
        if(concentrado != null){
            lbl.setText("Concentrado: " + concentrado.getName());
            vista.getBtnActualizar().setEnabled(true);
        }
    }

    /**
     * Busca el estudiante en la base de datos, usa la matrícula establecida en
     * el campo de texto. Si lo encuentra establece sus datos en los otros
     * campos de la vista.
     */
    private void completarDatosEstudiante(){
        EstudianteDAO dao = new EstudianteDAOImplementacion();
        
        JTextField texto = vista.getTextoMatricula();
        JComboBox caja = vista.getComboBoxModalidad();
        JSpinner spiner = vista.getSpnCubiertas();
        Estudiante est;
        String matricula = texto.getText();
        int i;
        String semestre;
        
        est = dao.getEstudiante(matricula);
        if (est != null){
            texto = vista.getTextoApellidoP();
            texto.setText(est.getApellidoP());
            
            texto = vista.getTextoApellidoM();
            texto.setText(est.getApellidoM());
            
            texto = vista.getTextoNombre();
            texto.setText(est.getNombre());
            
            i = switch (est.getModalidad()) {
                case 'E' -> 1;
                case 'S' -> 2;
                case 'I' -> 3;
                default -> 0;
            };
            caja.setSelectedIndex(i);
            
            i = switch (est.getTurno()) {
                case 'M' -> 1;
                case 'V' -> 2;
                default -> 0;
            };
            caja = vista.getComboBoxTurno();
            caja.setSelectedIndex(i);
            
            caja = vista.getComboBoxSemestre();
            for (i = 0; i < caja.getItemCount() - 1; i++){
                semestre = caja.getItemAt(i).toString();
                if(semestre.equals(est.getSemestre().toString())){
                   break; 
                }
            }
            caja.setSelectedIndex(i);
            
            spiner.setValue(est.getCubiertas());
            
            spiner = vista.getSpnReinscritas();
            spiner.setValue(est.getReinscritas());
        }else{
            clearVista();
        }
    }
    
    /**
     * Actualiza la base de datos con los nuevos datos de estudiantes
     * provenientes del archivo concentrado. Ademas registra los nuevos 
     * estudiantes que no se encontraban en la base de datos pero si en el 
     * archivo.
     */
    private void actualizarBaseDatos(){
        List<Estudiante> lista = leerConcentrado();
        EstudianteDAO dao = new EstudianteDAOImplementacion();
        boolean success;
        int i = 0;
        MensajeModal mensaje = new MensajeModal(ventana);
        
        for (Estudiante e: lista){
            if (dao.getEstudiante(e.getMatricula()) == null){
                success = dao.addEstudiante(e);
            }else{
                success = dao.updateEstudiante(e);
            }
            
            if(success){
                i++;
                success = false;
            }
        }
        mensaje.mostrarMensaje("Completado", "Se han leído corectamente " + i + " estudiantes");
    }

    /**
     * Lee el archivo de concentrado y devuelve la lista de estudiantes activos
     * que se encuentran en él.
     */
    private List<Estudiante> leerConcentrado(){
        LectorConcentrado lector = new LectorConcentrado(concentrado);
        List<Estudiante> lista = lector.obtenerLista();
        
        return lista;
    }

    /**
     * Obtiene la vista asociada con el controlador
     * @return la vista del controlador
     */
    public VistaGestionEstudiantes getVista() {
        return vista;
    }
    
    /**
     * Muestra la ventana del menú principal
     */
    private void mostrarMenuPrincipal(){
        mostrar(padre.getVista());
        clearVista();
    }

    @Override
    protected void clearVista() {
        JTextField texto = vista.getTextoMatricula();
        JComboBox caja = vista.getComboBoxModalidad();
        JSpinner spiner = vista.getSpnCubiertas();
        
        texto.setText("");
        
        texto = vista.getTextoApellidoP();
        texto.setText("");
            
        texto = vista.getTextoApellidoM();
        texto.setText("");
            
        texto = vista.getTextoNombre();
        texto.setText("");
        
        caja.setSelectedIndex(-1);
        
        caja = vista.getComboBoxTurno();
        caja.setSelectedIndex(-1);
            
        caja = vista.getComboBoxSemestre();
        caja.setSelectedIndex(0);
            
        spiner.setValue(0);
            
        spiner = vista.getSpnReinscritas();
        spiner.setValue(0);
    }
    
    /**
     * Activa o desactiva la comboBox de turno dependiendo de si la modalidad
     * es escolar o no respectivamente.
     */
    private void seleccionarModalidad(){
        JComboBox caja = vista.getComboBoxModalidad();
        char modalidad = caja.getSelectedItem().toString().charAt(0);
        
        caja = vista.getComboBoxTurno();
        if (modalidad == 'E'){
            caja.setEnabled(true);
        }else{
            caja.setSelectedIndex(0);
            caja.setEnabled(false);
        }
    }
}
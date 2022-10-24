package com.consultoriaBuzo.CertificacionIEMS.controlador;

import com.consultoriaBuzo.CertificacionIEMS.modelo.Estudiante;
import com.consultoriaBuzo.CertificacionIEMS.modelo.aplicacion.LectorConcentrado;
import com.consultoriaBuzo.CertificacionIEMS.vista.VentanaGestionEstudiantes;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

/**
 *
 * @author Luis Alberto
 */
public class ControladorGestionEstudiantes {
    private final VentanaGestionEstudiantes vista;
    File concentrado;
    Estudiante estudiante;

    /**
     * Inicializa el controlador creando una nueva vista
     */
    public ControladorGestionEstudiantes() {
        vista = new VentanaGestionEstudiantes();
    }
    
    /**
     * Inicializa la vista estableciendo los métodos que los controles 
     * ejecuten cuando haya un evento
     */
    private void initVista(){
        JButton boton = vista.getBtnGuardar();
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
        
        vista.setVisible(true);
    }

    /**
     * Guarda los datos de los campos de la vista en un nuevo estudiante.
     * Si no existe en la base de datos lo registra, si ya existe lo actualiza.
     */
    private void guardarCambios(){
    }
    
    /**
     * Muestra la ventana de seleccion de archivos y establece el archivo
     * seleccionado en la variable concentrado.
     */
    private void seleccionarArchivo(){
        JFileChooser subVentana = vista.getVentanaFileChooser();
        int opc = subVentana.showOpenDialog(vista);
        JLabel lbl = vista.getLblNombreArchivo();
        concentrado = subVentana.getSelectedFile();
        
        lbl.setText("Concentrado: " + concentrado.getName());
        vista.getBtnActualizar().setEnabled(true);
    }
    
    /**
     * Registra el estudiante en la base de datos.
     * @param estudiante el estudiante que se quiere registrar
     */
    private void registrarEstudiante(Estudiante estudiante) {
    }

    /**
     * Busca el estudiante en la base de datos, usa la matrícula establecida en
     * el campo de texto. Si lo encuentra establece sus datos en los otros
     * campos de la vista.
     */
    private void completarDatosEstudiante() {
    }
    
    /**
     * Actualiza el registro del estudiante pasado por parámetro en la 
     * base de datos
     * @param estudiante el estudiante que se quiere actualizar
     */
    private void actualizarEstudiante(Estudiante estudiante){
    }
    
    /**
     * Actualiza la base de datos con los nuevos datos de estudiantes
     * provenientes del archivo concentrado. Ademas registra los nuevos 
     * estudiantes que no se encontraban en la base de datos pero si en el 
     * archivo.
     */
    private void actualizarBaseDatos(){
        List<Estudiante> lista = leerConcentrado();
        
        for (Estudiante e: lista){
            System.out.println(e);
        }
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
     * Muestra la ventana asociada al controlador
     */
    public void mostrar(){
        initVista();
    }
}
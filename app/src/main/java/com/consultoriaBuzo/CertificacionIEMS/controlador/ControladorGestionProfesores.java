package com.consultoriaBuzo.certificacionIEMS.controlador;

import com.consultoriaBuzo.CertificacionIEMS.modelo.Academia;
import com.consultoriaBuzo.CertificacionIEMS.modelo.Profesor;
import com.consultoriaBuzo.CertificacionIEMS.dao.DTIDAOImplementacion;
import com.consultoriaBuzo.certificacionIEMS.vista.VentanaGestionProfesores;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

/**
 *
 * @author Luis Alberto
 */
public class ControladorGestionProfesores {
    private final VentanaGestionProfesores vista;

    /** 
     * Asigna la vista pasada por parámetro, si no se guardan 
     * datos en la vista no hace diferencia con el constructor vacío
     * @param vista JFrame del tipo VentanaGestionProfesores
     */
    public ControladorGestionProfesores(VentanaGestionProfesores vista) {
        this.vista = vista;
    }
    
    /**
     * Constructor que crea una nueva vista del tipo VentanaGestionProfesores
     * y la asigna a la variable
     */
    public ControladorGestionProfesores() {
        vista = new VentanaGestionProfesores();
    }
    
    /**
     * Inicializa la vista estableciendo los métodos que los controles 
     * ejecuten cuando haya un evento
     */
    private void initVista(){
        JButton boton = vista.getBotonGuardar();
        boton.addActionListener((ActionEvent e) -> {
            GuardarProfesor();
        });
        
        boton = vista.getBotonRegistrar();
        boton.addActionListener((ActionEvent e) -> {
            RegistrarProfesor();
        });
        
        JRadioButton radioBoton = vista.getRadioBotonDTI();
        radioBoton.addActionListener((ActionEvent e) -> {
            SeleccionarModalidadEscolar();
        });
        
        radioBoton = vista.getRadioBotonAsesor();
        radioBoton.addActionListener((ActionEvent e) -> {
            SeleccionarModalidadSemi();
        });
        
        vista.getComboBoxAcademia().setModel(
                new DefaultComboBoxModel(Academia.values()));
        
        vista.setVisible(true);
    }
    
    /**
     * Guarda los cambios realizados en los profesores actualizando sus registros
     */
    private void GuardarProfesor(){
        
    }
    
    /**
     * Agrega un profesor a la base de datos con los datos de los controles
     * en la tabla correspondiente
     */
    private void RegistrarProfesor(){
        Profesor prof = new Profesor();
        Academia academia = Academia.values()
                [vista.getComboBoxAcademia().getSelectedIndex()];
        String nombre = vista.getTextoNombre().getText();
        char c = vista.getComboBoxTurno().getSelectedItem().toString().charAt(0);
        
        if (nombre.compareTo("") != 0){
            prof.setNombre(nombre);
        }else{
            System.out.println("Error: sin nombre");
            return;
        }
        
        if (academia != Academia.NO_VALIDO){
            prof.setAcademia(academia);
        }else{
            System.out.println("Error: sin academmia");
            return;
        }
        
        if (c != ' '){
            prof.setTurno(c);
        }else{
            System.out.println("Error: sin turno");
            return;
        }
        
        if (vista.getRadioBotonDTI().isSelected()){
            DTIDAOImplementacion dao = new DTIDAOImplementacion();
            dao.addDTI(prof);
        }else if (vista.getRadioBotonAsesor().isSelected()){
            
            //dao.addAsesor
        }else{
            System.out.println("Error: sin tipo de profesor");
        }
        
    }
    
    /**
     * Actualiza los radiobotones para que solo esté seleccionado el de DTI
     * y activa la caja de turno en consecuencia
     */
    private void SeleccionarModalidadEscolar(){
        JRadioButton botonAsesor = vista.getRadioBotonAsesor();
        JComboBox cajaTurno = vista.getComboBoxTurno();
        
        botonAsesor.setSelected(false);
        cajaTurno.setEnabled(true);
    }
    
    /**
     * Actualiza los radiobotones para que solo esté seleccionado el de asesor
     * y desactiva la caja de turno en consecuencia
     */
    private void SeleccionarModalidadSemi(){
        JRadioButton botonDTI = vista.getRadioBotonDTI();
        JComboBox cajaTurno = vista.getComboBoxTurno();
        
        botonDTI.setSelected(false);
        cajaTurno.setEnabled(false);
        cajaTurno.setSelectedIndex(0);
    }
    
    /**
     * Muestra la ventana asociada al controlador
     */
    public void mostrar(){
        initVista();
    }
}

package com.consultoriaBuzo.CertificacionIEMS.controlador;

import com.consultoriaBuzo.CertificacionIEMS.modelo.Semestre;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import com.consultoriaBuzo.CertificacionIEMS.vista.VistaMenuPrincipal;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Luis Alberto
 */
public class ControladorMenuPrincipal extends Controlador{
    
    VistaMenuPrincipal vista;
    ControladorGestionProfesores controladorGestionProfesores;
    ControladorGestionEstudiantes controladorGestionEstudiantes;
    ControladorMonitoreo controladorMonitoreo;

    /**
     * Crea un nuevo menú principal usando la ventana pasada por parámetro para
     * mostrar la vista.
     * @param ventana la ventana en la cual se mostrará la vista
     */
    public ControladorMenuPrincipal(JFrame ventana) {
        super.ventana = ventana;
        vista = new VistaMenuPrincipal();
        
        cargarHijos();
        initVista();
        mostrar(vista);
        
    }
    
    @Override
    protected final void initVista(){
        JButton boton = vista.getBtnGestionProfesores();
        JLabel label = vista.getImgGestionProfesores();
        
        boton.addActionListener((ActionEvent e) -> {
            mostrarGestionProfesores();
        });
        label.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                mostrarGestionProfesores();
            }
        });
        
        boton = vista.getBtnGestionEstudiantes();
        boton.addActionListener((ActionEvent e) -> {
            mostrarGestionEstudiantes();
        });
        label = vista.getImgGestionEstudiantes();
        label.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                mostrarGestionEstudiantes();
            }
        });
        
        boton = vista.getBtnMonitoreo();
        boton.addActionListener((ActionEvent e) ->{
            mostrarMonitoreo();
        });
        label = vista.getImgMonitoreo();
        label.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                mostrarMonitoreo();
            }
        });
        
        label = vista.getLblSemestre();
        label.setText(Semestre.calcularActual().toString());
        
    }
    
    /**
     * Cambia la ventana a la de gestión de profesores, en la misma ventana
     */
    private void mostrarGestionProfesores() {
        mostrar(controladorGestionProfesores.getVista());
    }

    /**
     * Cambia la ventana a la de gestión de estudiantes, en la misma ventana
     */
    private void mostrarGestionEstudiantes() {
        mostrar(controladorGestionEstudiantes.getVista());
    }
    
    private void mostrarMonitoreo(){
        controladorMonitoreo.actualizarVista();
        mostrar(controladorMonitoreo.getVista());
    }
    
    /**
     * Obtiene la vista asociada al controlador
     * @return la vista del controlador
     */
    public VistaMenuPrincipal getVista() {
        return vista;
    }

    @Override
    protected void clearVista() {
    }
    
    /**
     * Crea los objetos controladores que se pueden invocar desde el menú 
     * principal para que no se tarden desplegar las vistas cuando se presiona 
     * algún botón que invoque otro controlador
     */
    private void cargarHijos(){
        controladorGestionProfesores = new ControladorGestionProfesores(
                ventana, this);
        controladorGestionEstudiantes = new ControladorGestionEstudiantes(
                ventana, this);
        
        controladorMonitoreo = new ControladorMonitoreo(ventana, this);
    }
}

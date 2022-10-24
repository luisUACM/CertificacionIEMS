package com.consultoriaBuzo.CertificacionIEMS.controlador;

import com.consultoriaBuzo.CertificacionIEMS.vista.VentanaMenuPrincipal;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import com.consultoriaBuzo.certificacionIEMS.controlador.ControladorGestionProfesores;

/**
 *
 * @author Luis Alberto
 */
public class ControladorMenuPrincipal {
    
    VentanaMenuPrincipal vista;

    public ControladorMenuPrincipal() {
        vista = new VentanaMenuPrincipal();
    }
    
    private void initVista(){
        JButton boton = vista.getBtnGestionProfesores();
        boton.addActionListener((ActionEvent e) -> {
            mostrarGestionProfesores();
        });
        
        boton = vista.getBtnGestionEstudiantes();
        boton.addActionListener((ActionEvent e) -> {
            mostrarGestionEstudiantes();
        });
        
        vista.setVisible(true);
    }

    public void mostrar(){
        initVista();
    }
    private void mostrarGestionProfesores() {
        ControladorGestionProfesores controlador = new ControladorGestionProfesores();
        controlador.mostrar();
    }

    private void mostrarGestionEstudiantes() {
        ControladorGestionEstudiantes controlador = new ControladorGestionEstudiantes();
        controlador.mostrar();
    }
}

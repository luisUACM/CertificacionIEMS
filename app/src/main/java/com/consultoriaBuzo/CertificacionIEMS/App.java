package com.consultoriaBuzo.CertificacionIEMS;

import com.consultoriaBuzo.certificacionIEMS.controlador.ControladorGestionProfesores;

/**
 *
 * @author Luis Alberto
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControladorGestionProfesores controlador = new ControladorGestionProfesores();
        controlador.mostrar();
    }
    
}

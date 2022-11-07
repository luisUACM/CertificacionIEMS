package com.consultoriaBuzo.CertificacionIEMS;

import com.consultoriaBuzo.CertificacionIEMS.controlador.Controlador;
import com.consultoriaBuzo.CertificacionIEMS.controlador.ControladorMenuPrincipal;
import javax.swing.JFrame;

/**
 *
 * @author Luis Alberto
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame ventanaPrincipal = new JFrame();
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Controlador controlador = new ControladorMenuPrincipal(ventanaPrincipal);
    }
    
}

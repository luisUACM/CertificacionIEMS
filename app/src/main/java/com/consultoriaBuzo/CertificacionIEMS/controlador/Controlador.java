package com.consultoriaBuzo.CertificacionIEMS.controlador;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Luis Alberto
 */
public abstract class Controlador {
    JFrame ventana;
    
    /**
     * Inicializa los controles de la vista con ActionListeners y cualquier otra
     * cosa que haga falta inicializar.
     */
    protected abstract void initVista();
    
    /**
     * Establece la ventana del controlador con una vista en particular
     * @param vista la vista a mostrar en la ventana
     */
    public final void mostrar(JPanel vista){
        ventana.setContentPane(vista);
        ventana.validate();
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.repaint();
        ventana.setVisible(true);
    }
    
    /**
     * Reinicia los controles de la vista a como estaban al principio.
     */
    protected abstract void clearVista();
}

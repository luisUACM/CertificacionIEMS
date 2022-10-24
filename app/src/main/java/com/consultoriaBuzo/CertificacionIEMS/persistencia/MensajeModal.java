package com.consultoriaBuzo.CertificacionIEMS.persistencia;

import java.awt.Dialog;
import java.awt.Window;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Luis Alberto
 */
public final class MensajeModal {
    private final JDialog ventana;

    /**
     * Establece el dueño del JDialog
     * @param frame la ventana dueña del mensaje modal
     */
    public MensajeModal(Window frame) {
        ventana = new JDialog(frame);
        ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        ventana.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        ventana.setSize(200, 150);
    }
    
    /**
     * Muesta el JDialog como una ventana modal con el mensaje especificado 
     * @param titulo el título de la ventana modal
     * @param mensaje el mensaje a mostrar
     */
    public final void mostrarMensaje(String titulo, String mensaje){
        JButton boton = new JButton("Aceptar");
        JLabel label = new JLabel(mensaje);
        
        ventana.setTitle(titulo);
        boton.addActionListener((ActionEvent e) -> {
            ventana.dispose();
        });
        
        ventana.add(label);
        //ventana.add(boton);
        ventana.setVisible(true);
    }
}

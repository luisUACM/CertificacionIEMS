package com.consultoriaBuzo.CertificacionIEMS.vista;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Luis Alberto
 */
public class VistaMenuPrincipal extends javax.swing.JPanel {

    /**
     * Creates new form VistaMenuPrincipal
     */
    public VistaMenuPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logotipo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnGestionProfesores = new javax.swing.JButton();
        btnGestionEstudiantes = new javax.swing.JButton();
        imgGestionEstudiantes = new javax.swing.JLabel();
        imgGestionProfesores = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnMonitoreo = new javax.swing.JButton();
        imgMonitoreo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblSemestre = new javax.swing.JLabel();

        logotipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IEMSLogo.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        jLabel5.setText("Men� principal");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnGestionProfesores.setText("Gesti�n de profesores");

        btnGestionEstudiantes.setText("Gesti�n Estudiantes");

        imgGestionEstudiantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Estudiante.png"))); // NOI18N

        imgGestionProfesores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Profesor.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(imgGestionEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(imgGestionProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnGestionEstudiantes)
                        .addGap(58, 58, 58)
                        .addComponent(btnGestionProfesores)))
                .addContainerGap(296, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgGestionEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgGestionProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGestionProfesores)
                    .addComponent(btnGestionEstudiantes))
                .addGap(179, 179, 179))
        );

        jTabbedPane1.addTab("Altas y bajas", jPanel1);

        btnMonitoreo.setText("Monitoreo de egresos");

        imgMonitoreo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Monitoreo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(imgMonitoreo))
                    .addComponent(btnMonitoreo))
                .addContainerGap(486, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(imgMonitoreo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMonitoreo)
                .addContainerGap(179, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Proceso de certificaci�n", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 333, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Generaci�n de formatos", jPanel3);

        lblSemestre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logotipo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(lblSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logotipo)
                    .addComponent(jLabel5)
                    .addComponent(lblSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGestionEstudiantes;
    private javax.swing.JButton btnGestionProfesores;
    private javax.swing.JButton btnMonitoreo;
    private javax.swing.JLabel imgGestionEstudiantes;
    private javax.swing.JLabel imgGestionProfesores;
    private javax.swing.JLabel imgMonitoreo;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblSemestre;
    private javax.swing.JLabel logotipo;
    // End of variables declaration//GEN-END:variables
    
    /**
     * Regresa el bot�n de gesti�n de estudiantes
     * @return el JButton de la gesti�n de estudiantes
     */
    public JButton getBtnGestionEstudiantes() {
        return btnGestionEstudiantes;
    }

    /**
     * Regresa el bot�n de gesti�n de profesores
     * @return el JButton de la gesti�n de profesores
     */
    public JButton getBtnGestionProfesores() {
        return btnGestionProfesores;
    }

    /**
     * Regresa la label con la imagen del logotipo del IEMS
     * @return la JLabel del logotipo
     */
    public JLabel getLogotipo() {
        return logotipo;
    }

    /**
     * Regresa la label con la imagen de un estudiante
     * @return la JLabel del logotipo
     */
    public JLabel getImgGestionEstudiantes() {
        return imgGestionEstudiantes;
    }

    /**
     * Regresa la label con la imagen de un profesor
     * @return la JLabel del logotipo
     */
    public JLabel getImgGestionProfesores() {
        return imgGestionProfesores;
    }

    /**
     * Regresa la label de la esquina superior dereccha del semestre
     * @return la label para el semestre actual
     */
    public JLabel getLblSemestre() {
        return lblSemestre;
    }

    /**
     * Regresa el bot�n de monitoreo de posiblles egresados
     * @return el JButton de monitoreo
     */
    public JButton getBtnMonitoreo() {
        return btnMonitoreo;
    }

    /**
     * Regresa la label con la imagen del monitoreo
     * @return la JLabel del monitoreo
     */
    public JLabel getImgMonitoreo() {
        return imgMonitoreo;
    }
    
}

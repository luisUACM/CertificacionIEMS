package com.consultoriaBuzo.CertificacionIEMS.vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Luis Alberto
 */
public class VistaMonitoreo extends javax.swing.JPanel {

    /**
     * Creates new form VistaMonitoreo
     */
    public VistaMonitoreo() {
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
        tabPanel = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEstudiantes = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtFMatricula = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        panelGraficaEgresados = new javax.swing.JPanel();
        panelGraficaMateriasPastel = new javax.swing.JPanel();
        panelGraficaMateriasBarras = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(700, 500));

        logotipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IEMSLogo.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        jLabel5.setText("Monitoreo de avance acad?mico");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tablaEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matr?cula", "Primer apellido", "Segundo apellido", "Nombre", "Cubiertas", "Reinscritas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaEstudiantes.setShowGrid(true);
        jScrollPane1.setViewportView(tablaEstudiantes);

        btnAgregar.setText("Agregar");

        btnEliminar.setText("Eliminar seleccionado");

        jLabel1.setText("Matr?cula:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminar)
                    .addComponent(txtFMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        tabPanel.addTab("Tabla de candidatos", jPanel1);

        javax.swing.GroupLayout panelGraficaEgresadosLayout = new javax.swing.GroupLayout(panelGraficaEgresados);
        panelGraficaEgresados.setLayout(panelGraficaEgresadosLayout);
        panelGraficaEgresadosLayout.setHorizontalGroup(
            panelGraficaEgresadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 704, Short.MAX_VALUE)
        );
        panelGraficaEgresadosLayout.setVerticalGroup(
            panelGraficaEgresadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        tabPanel.addTab("Gr?fica de candidatos", panelGraficaEgresados);

        javax.swing.GroupLayout panelGraficaMateriasPastelLayout = new javax.swing.GroupLayout(panelGraficaMateriasPastel);
        panelGraficaMateriasPastel.setLayout(panelGraficaMateriasPastelLayout);
        panelGraficaMateriasPastelLayout.setHorizontalGroup(
            panelGraficaMateriasPastelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 704, Short.MAX_VALUE)
        );
        panelGraficaMateriasPastelLayout.setVerticalGroup(
            panelGraficaMateriasPastelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        tabPanel.addTab("Gr?fica por materias (Pastel)", panelGraficaMateriasPastel);

        javax.swing.GroupLayout panelGraficaMateriasBarrasLayout = new javax.swing.GroupLayout(panelGraficaMateriasBarras);
        panelGraficaMateriasBarras.setLayout(panelGraficaMateriasBarrasLayout);
        panelGraficaMateriasBarrasLayout.setHorizontalGroup(
            panelGraficaMateriasBarrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 704, Short.MAX_VALUE)
        );
        panelGraficaMateriasBarrasLayout.setVerticalGroup(
            panelGraficaMateriasBarrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        tabPanel.addTab("Gr?fica por materias (Barras)", panelGraficaMateriasBarras);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logotipo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logotipo)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabPanel.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logotipo;
    private javax.swing.JPanel panelGraficaEgresados;
    private javax.swing.JPanel panelGraficaMateriasBarras;
    private javax.swing.JPanel panelGraficaMateriasPastel;
    private javax.swing.JTabbedPane tabPanel;
    private javax.swing.JTable tablaEstudiantes;
    private javax.swing.JTextField txtFMatricula;
    // End of variables declaration//GEN-END:variables

    /**
     * Regresa la label con la imagen del logotipo del IEMS
     * @return la JLabel del logotipo
     */
    public JLabel getLogotipo() {
        return logotipo;
    }

    /**
     * Regresa el panel para la gr?fica de estudiantes
     * @return el JPanel dedicado a la gr?fica
     */
    public JPanel getPanelGraficaEgresados() {
        return panelGraficaEgresados;
    }

    /**
     * Regresa el panel para la gr?fica de materias cubiertas de barras
     * @return el JPanel dedicado a la gr?fica
     */
    public JPanel getPanelGraficaMateriasBarras() {
        return panelGraficaMateriasBarras;
    }

    /**
     * Regresa el panel para la gr?fica de materias cubiertas de pastel
     * @return el JPanel dedicado a la gr?fica
     */
    public JPanel getPanelGraficaMateriasPastel() {    
        return panelGraficaMateriasPastel;
    }

    /**
     * Regresa la tabla de los estudiantes
     * @return la JTable de los estudiantes
     */
    public JTable getTablaEstudiantes() {
        return tablaEstudiantes;
    }

    /**
     * Regresa el bot?n para agregar estudiantes a la tabla
     * @return el JButton para agregar
     */
    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    /**
     * Regresa el bot?n para eliminar estudiantes a la tabla
     * @return el JButton para eliminar
     */
    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    /**
     * Regresa el campo de texto de matr?culas de estudiante
     * @return el JTextField para la matricula
     */
    public JTextField getTxtFMatricula() {
        return txtFMatricula;
    }

    /**
     * Regresa el panel de pesta?as
     * @return el JTabbedPane con las pesta?as
     */
    public JTabbedPane getTabPanel() {
        return tabPanel;
    }
    
    
}

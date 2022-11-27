package com.consultoriaBuzo.CertificacionIEMS.vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author Luis Alberto
 */
public class VistaGestionEstudiantes extends javax.swing.JPanel {

    /**
     * Creates new form VistaGestionEstudiantes
     */
    public VistaGestionEstudiantes() {
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

        ventanaFileChooser = new javax.swing.JFileChooser();
        logotipo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        textoMatricula = new javax.swing.JTextField();
        textoNombre = new javax.swing.JTextField();
        textoApellidoP = new javax.swing.JTextField();
        textoApellidoM = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        spnCubiertas = new javax.swing.JSpinner();
        spnReinscritas = new javax.swing.JSpinner();
        comboBoxModalidad = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        comboBoxTurno = new javax.swing.JComboBox<>();
        comboBoxSemestre = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        lblNombreArchivo = new javax.swing.JLabel();
        mensajeRegistro = new javax.swing.JLabel();
        mensajeConcentrado = new javax.swing.JLabel();
        lblSemestre = new javax.swing.JLabel();

        ventanaFileChooser.setDialogTitle("Seleccionar concentrado de control");

        logotipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IEMSLogo.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        jLabel5.setText("Gesti�n de estudiantes");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setText("Matr�cula:");

        jLabel2.setText("Estudiante:");

        jLabel7.setText("Asignaturas cubiertas:");

        jLabel8.setText("Asignaturas reinscritas:");

        jLabel10.setText("Modalidad: ");

        jLabel11.setText("Turno:");

        jLabel12.setText("�ltimo semestre reinscrito:");

        btnBuscar.setText("Buscar");

        btnGuardar.setText("Guardar");

        spnCubiertas.setModel(new javax.swing.SpinnerNumberModel(0, 0, 37, 1));
        spnCubiertas.setEditor(new javax.swing.JSpinner.NumberEditor(spnCubiertas, ""));

        spnReinscritas.setModel(new javax.swing.SpinnerNumberModel(0, 0, 11, 1));
        spnReinscritas.setEditor(new javax.swing.JSpinner.NumberEditor(spnReinscritas, ""));

        comboBoxModalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Escolar", "Semi escolar", "Independiente" }));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel3.setText("Nombre(s)");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel6.setText("Apellido paterno");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel13.setText("Apellido materno");

        comboBoxTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Matutino", "Vespertino" }));
        comboBoxTurno.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel14.setText("Concentrado de control");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnSeleccionar.setText("Seleccionar archivo");

        btnActualizar.setText("Actualizar");
        btnActualizar.setEnabled(false);

        lblNombreArchivo.setText("Concentrado: ");

        mensajeRegistro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        mensajeConcentrado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lblSemestre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logotipo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(mensajeRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textoApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(227, 227, 227))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(comboBoxTurno, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboBoxModalidad, javax.swing.GroupLayout.Alignment.LEADING, 0, 150, Short.MAX_VALUE)
                                    .addComponent(comboBoxSemestre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(spnCubiertas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spnReinscritas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(111, 111, 111)
                                        .addComponent(jLabel3)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblNombreArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSeleccionar)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar))
                    .addComponent(mensajeConcentrado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(236, 236, 236))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logotipo)
                    .addComponent(jLabel5)
                    .addComponent(lblSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mensajeRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(textoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar)
                        .addComponent(btnGuardar)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel13)
                            .addComponent(jLabel3)))
                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(comboBoxModalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(comboBoxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(spnCubiertas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spnReinscritas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(comboBoxSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreArchivo)
                    .addComponent(btnSeleccionar)
                    .addComponent(btnActualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mensajeConcentrado, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox<String> comboBoxModalidad;
    private javax.swing.JComboBox<String> comboBoxSemestre;
    private javax.swing.JComboBox<String> comboBoxTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblNombreArchivo;
    private javax.swing.JLabel lblSemestre;
    private javax.swing.JLabel logotipo;
    private javax.swing.JLabel mensajeConcentrado;
    private javax.swing.JLabel mensajeRegistro;
    private javax.swing.JSpinner spnCubiertas;
    private javax.swing.JSpinner spnReinscritas;
    private javax.swing.JTextField textoApellidoM;
    private javax.swing.JTextField textoApellidoP;
    private javax.swing.JTextField textoMatricula;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JFileChooser ventanaFileChooser;
    // End of variables declaration//GEN-END:variables

    /**
     * Obtiene el bot�n de actualizar
     * @return el JButton de actualizar
     */
    public JButton getBtnActualizar() {
        return btnActualizar;
    }
    
    /**
     * Obtiene el bot�n de buscar
     * @return el JButton de buscar
     */
    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    /**
     * Obtiene el bot�n de guardar
     * @return el JButton de guardar
     */
    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    /**
     * Obtiene el bot�n de seleccionar archivo
     * @return el JButton de seleccionar
     */
    public JButton getBtnSeleccionar() {
        return btnSeleccionar;
    }
    
    /**
     * Obtiene la comboBox de modalidad
     * @return el JComboBox de modalidad
     */
    public JComboBox<String> getComboBoxModalidad() {
        return comboBoxModalidad;
    }
    
    /**
     * Obtiene la comboBox de semestre
     * @return el JComboBox de semestre
     */
    public JComboBox<String> getComboBoxSemestre() {
        return comboBoxSemestre;
    }

    /**
     * Obtiene la comboBox de turno
     * @return el JComboBox de turno
     */
    public JComboBox<String> getComboBoxTurno() {
        return comboBoxTurno;
    }

    /**
     * Obtiene la label del nombre del archivo
     * @return el JLabel del nombre del archivo
     */
    public JLabel getLblNombreArchivo() {
        return lblNombreArchivo;
    }

    /**
     * Obtiene la spinner de asignaturas cubiertas
     * @return el JSpinner de asnaturas cubiertas
     */
    public JSpinner getSpnCubiertas() {
        return spnCubiertas;
    }
    
    /**
     * Obtiene la spinner de asignaturas reinscritas
     * @return el JSpinner de asnaturas reinscritas
     */
    public JSpinner getSpnReinscritas() {
        return spnReinscritas;
    }

    /**
     * Obtiene la caja de texto del apellido materno
     * @return el JTextField de apellido materno
     */
    public JTextField getTextoApellidoM() {
        return textoApellidoM;
    }
    
    /**
     * Obtiene la caja de texto del apellido paterno
     * @return el JTextField de apellido paterno
     */
    public JTextField getTextoApellidoP() {
        return textoApellidoP;
    }

    /**
     * Obtiene la caja de texto de matr�cula
     * @return el JTextField de matr�cula
     */
    public JTextField getTextoMatricula() {
        return textoMatricula;
    }

    /**
     * Obtiene la caja de texto del nombre
     * @return el JTextField de nombre
     */
    public JTextField getTextoNombre() {
        return textoNombre;
    }

    /**
     * Obtiene la ventana para la seleccion de archivos
     * @return el JFileChooser para la seleccion de archivos
     */
    public JFileChooser getVentanaFileChooser() {
        return ventanaFileChooser;
    }

    /**
     * Obtiene invisible que se debe usar para mostrar mensajes cuando
     * se presione el boton de actualizar
     * @return la JLabel invisible
     */
    public JLabel getMensajeConcentrado() {
        return mensajeConcentrado;
    }

    /**
     * Obtiene invisible que se debe usar para mostrar mensajes cuando
     * se presione el boton de registrar
     * @return la JLabel invisible
     */
    public JLabel getMensajeRegistro() {
        return mensajeRegistro;
    }
    
    /**
     * Obtiiene la label con la imagen del logotipo del IEMS
     * @return la JLabel del logotipo
     */
    public JLabel getLogotipo() {
        return logotipo;
    }
    
    /**
     * Regresa la label de la esquina superior dereccha del semestre
     * @return la label para el semestre actual
     */
    public JLabel getLblSemestre() {
        return lblSemestre;
    }
}

package frame;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

public class frmInicial extends javax.swing.JFrame {

    NegocioSQLAlumno controlerSQL;
    odtAlumno odtAlum;
    controladorAlumno ctrAlumno;
    public frmInicial() {
        ctrAlumno = new controladorAlumno(this);
        initComponents();
        controlerSQL = new NegocioSQLAlumno();
        btmConectar.addActionListener(ctrAlumno);
        btmSalir.addActionListener(ctrAlumno);
        btmAltas.addActionListener(ctrAlumno);
        btmBaja.addActionListener(ctrAlumno);
        btmBuscar.addActionListener(ctrAlumno);
        btmSiguiente.addActionListener(ctrAlumno);
        btmAnterior.addActionListener(ctrAlumno);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        btmConectar = new javax.swing.JButton();
        btmSalir = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        btmSiguiente = new javax.swing.JButton();
        btmAnterior = new javax.swing.JButton();
        btmAltas = new javax.swing.JButton();
        txtAltaDNI = new javax.swing.JTextField();
        txtAltaNombre = new javax.swing.JTextField();
        txtAltaApellido1 = new javax.swing.JTextField();
        txtAltaApellido2 = new javax.swing.JTextField();
        txtRegistro = new javax.swing.JTextField();
        txtApellido1 = new javax.swing.JTextField();
        txtApellido2 = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        btmBuscar = new javax.swing.JButton();
        btmBaja = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btmConectar.setText("Conectar");
        btmConectar.setActionCommand("btmConectar");

        btmSalir.setText("Salir");
        btmSalir.setActionCommand("btmSalir");

        txtNombre.setText("Nombre");

        btmSiguiente.setText("Siguiente");
        btmSiguiente.setActionCommand("btmSiguiente");

        btmAnterior.setText("Anterior");
        btmAnterior.setActionCommand("btmAnterior");

        btmAltas.setText("Confirmar Alta");
        btmAltas.setActionCommand("btmAltas");

        txtAltaDNI.setText("DNI");

        txtAltaNombre.setText("Nombre");

        txtAltaApellido1.setText("Apellido1");

        txtAltaApellido2.setText("Apellido2");

        txtRegistro.setText("Registro");

        txtApellido1.setText("Apellido1");

        txtApellido2.setText("Apellido2");

        txtDNI.setText("DNI");

        btmBuscar.setText("Buscar por registro");
        btmBuscar.setActionCommand("btmBuscar");

        btmBaja.setText("Eliminar Registro");
        btmBaja.setActionCommand("btmBaja");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtAltaNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtAltaDNI, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btmAltas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtAltaApellido2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                        .addComponent(txtAltaApellido1, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(218, 218, 218)
                                        .addComponent(btmConectar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btmAnterior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btmSiguiente, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                                        .addGap(38, 38, 38)
                                        .addComponent(txtRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btmSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(156, 156, 156))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btmBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btmBaja, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btmSiguiente)
                        .addGap(6, 6, 6)
                        .addComponent(btmAnterior))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7)
                .addComponent(btmBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btmBaja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btmAltas)
                .addGap(18, 18, 18)
                .addComponent(txtAltaDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtAltaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtAltaApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtAltaApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btmConectar)
                    .addComponent(btmSalir))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setTabla() throws SQLException {
        odtAlum=controlerSQL.getOdtAlumno();
        
        txtRegistro.setText(odtAlum.getRegistro());
        txtDNI.setText(odtAlum.getDni());
        txtNombre.setText(odtAlum.getNombre());
        txtApellido1.setText(odtAlum.getApellido1());
        txtApellido2.setText(odtAlum.getApellido2());
    }

    public JTextField getTxtAltaApellido1() {
        return txtAltaApellido1;
    }

    public void setTxtAltaApellido1(JTextField txtAltaApellido1) {
        this.txtAltaApellido1 = txtAltaApellido1;
    }

    public JTextField getTxtAltaApellido2() {
        return txtAltaApellido2;
    }

    public void setTxtAltaApellido2(JTextField txtAltaApellido2) {
        this.txtAltaApellido2 = txtAltaApellido2;
    }

    public JTextField getTxtAltaDNI() {
        return txtAltaDNI;
    }

    public void setTxtAltaDNI(JTextField txtAltaDNI) {
        this.txtAltaDNI = txtAltaDNI;
    }

    public JTextField getTxtAltaNombre() {
        return txtAltaNombre;
    }

    public void setTxtAltaNombre(JTextField txtAltaNombre) {
        this.txtAltaNombre = txtAltaNombre;
    }
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmInicial().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btmAltas;
    private javax.swing.JButton btmAnterior;
    private javax.swing.JButton btmBaja;
    private javax.swing.JButton btmBuscar;
    private javax.swing.JButton btmConectar;
    private javax.swing.JButton btmSalir;
    private javax.swing.JButton btmSiguiente;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField txtAltaApellido1;
    private javax.swing.JTextField txtAltaApellido2;
    private javax.swing.JTextField txtAltaDNI;
    private javax.swing.JTextField txtAltaNombre;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRegistro;
    // End of variables declaration//GEN-END:variables
}

package Visual;

import Logica.UberSocial;
import javax.swing.JOptionPane;

public class CrearCuenta extends javax.swing.JFrame {

    UberSocial Social;

    public CrearCuenta(UberSocial social) {
        this.Social = social;
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TipoDeCuenta = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        NombreDeUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        

        

        TipoDeCuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"TWITTER", "FACEBOOK"}));
        

        jLabel1.setText("Social Media");
        

        

        jLabel2.setText("Nombre de usuario: ");
        

        jButton1.setText("Crear cuenta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 180, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 140));

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (!NombreDeUsuario.getText().isBlank()) {
            this.Social.agregarCuenta(NombreDeUsuario.getText(), TipoDeCuenta.getSelectedItem().toString(), true);
            JOptionPane.showMessageDialog(this, "Cuenta creada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            new Log_In(Social).setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un nombre de usuario", "Username", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        new Log_In(Social).setVisible(true);
        this.dispose();
    }

    // Variables declaration
    private javax.swing.JTextField NombreDeUsuario;
    private javax.swing.JComboBox<String> TipoDeCuenta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration
}

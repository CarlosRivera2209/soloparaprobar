package Visual;

import Logica.UberSocial;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Log_In extends javax.swing.JFrame {

    public static String userLogin;
    ArrayList<String> Usuarios;
    UberSocial Social;

    public Log_In(UberSocial Social) {
        this.Social = Social;
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        Usuarios = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Username = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
       

        Username.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); 
        

        jLabel1.setText("Nombre de usuario: ");
       

        jButton1.setText("Iniciar sesion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
      

        jButton2.setText("Registrarse");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
       

        jLabel2.setFont(new java.awt.Font("Segoe UI Historic", 0, 36)); 
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("RED SOCIAL");
        
        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        new CrearCuenta(Social).setVisible(true);
        this.dispose();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        userLogin = Username.getText();
        if (userLogin.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene el espacio de usuario");
        } else {
            if (Social.buscar(userLogin, 0) != null) {
                new Post(Social).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado. Por favor, regístrese o intente de nuevo.");
            }
        }
    }

    // Variables declaration
    private javax.swing.JTextField Username;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration
}

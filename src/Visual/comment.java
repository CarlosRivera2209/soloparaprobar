package Visual;

import Logica.SocialClass;
import Logica.UberSocial;
import static Visual.Log_In.userLogin;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class comment extends javax.swing.JFrame {

    UberSocial Social;
    ArrayList<String> usuarios = new ArrayList<>();
    ArrayList<String> post = new ArrayList<>();
    public Object user;
    public int id;

    public comment(UberSocial Social) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.Social = Social;
        setUsers();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        Posts = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        Usuarios = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Posts.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Elija el usuario"}));
        Posts.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                PostsItemStateChanged(evt);
            }
        });

        jButton1.setText("Agregar Comentario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Usuarios.setModel(new javax.swing.DefaultComboBoxModel<>(usuarios.toArray(new String[0])));
        Usuarios.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                UsuariosItemStateChanged(evt);
            }
        });

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        // Layout configuration
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(137, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Posts, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(124, 124, 124))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(88, Short.MAX_VALUE)
                                .addComponent(Usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(Posts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addGap(70, 70, 70))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String commentCrear = JOptionPane.showInputDialog("Comentario: ");
            user = Usuarios.getSelectedItem();
            id = Posts.getSelectedIndex();
            Social.agregarComment(userLogin, id, user.toString(), commentCrear);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    private void PostsItemStateChanged(java.awt.event.ItemEvent evt) {
        id = Posts.getSelectedIndex();
    }

    private void UsuariosItemStateChanged(java.awt.event.ItemEvent evt) {
        user = Usuarios.getSelectedItem();
        post.clear();
    }

    private void UsuariosActionPerformed(java.awt.event.ActionEvent evt) {
        setPosts();
        Posts.setModel(new javax.swing.DefaultComboBoxModel<>(post.toArray(new String[0])));
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        new Post(Social).setVisible(true);
        this.dispose();
    }

    private void setUsers() {
        usuarios.clear();
        for (SocialClass Cuentas : Social.clases) {
            usuarios.add(Cuentas.getUsername());
        }
        Usuarios.setModel(new javax.swing.DefaultComboBoxModel<>(usuarios.toArray(new String[0])));
    }

    private void setPosts() {
        post.clear();
        for (int loop = 0; loop < Social.clases.get(Usuarios.getSelectedIndex()).Posts.size(); loop++) {
            post.add(Social.clases.get(Usuarios.getSelectedIndex()).Posts.get(loop));
        }
    }

    // Variables declaration
    private javax.swing.JComboBox<String> Posts;
    private javax.swing.JComboBox<String> Usuarios;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration
}

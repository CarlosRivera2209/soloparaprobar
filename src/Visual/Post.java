package Visual;

import Logica.UberSocial;
import static Visual.Log_In.userLogin;
import javax.swing.*;
import java.awt.*;

public class Post extends javax.swing.JFrame {

    UberSocial Social;

    public Post(UberSocial Social) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.Social = Social;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        JLabel titleLabel = new JLabel("POST");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        agregarPost = new javax.swing.JButton("Agregar Post");
        agregarAmigo = new javax.swing.JButton("Agregar Amigo");
        agregarComment = new javax.swing.JButton("Agregar Comentario");
        profileFrom = new javax.swing.JButton("Perfil de Usuario");
        jButton1 = new javax.swing.JButton("Regresar");

        agregarPost.addActionListener(this::agregarPostActionPerformed);
        agregarAmigo.addActionListener(this::agregarAmigoActionPerformed);
        agregarComment.addActionListener(this::agregarCommentActionPerformed);
        profileFrom.addActionListener(this::profileFromActionPerformed);
        jButton1.addActionListener(this::jButton1ActionPerformed);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        getContentPane().add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        getContentPane().add(agregarPost, gbc);

        gbc.gridy = 2;
        getContentPane().add(agregarAmigo, gbc);

        gbc.gridy = 3;
        getContentPane().add(agregarComment, gbc);

        gbc.gridy = 4;
        getContentPane().add(profileFrom, gbc);

        gbc.gridy = 5;
        getContentPane().add(jButton1, gbc);

        pack();
    }

    private void agregarPostActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String postCrear = JOptionPane.showInputDialog("Post: ");
            Social.AgregarPost(userLogin, postCrear);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    private void agregarAmigoActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String userCrear = JOptionPane.showInputDialog("Amigo a crear: ");
            if (userCrear.equals(userLogin)) {
                JOptionPane.showMessageDialog(null, "No puedes agregarte a ti mismo");
            } else {
                if (Social.AgregarAmigo(userLogin, userCrear)) {
                    JOptionPane.showMessageDialog(null, "Se agregó amigo con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se agregó amigo con éxito.");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    private void agregarCommentActionPerformed(java.awt.event.ActionEvent evt) {
        new comment(Social).setVisible(true);
        this.dispose();
    }

    private void profileFromActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String user = JOptionPane.showInputDialog("Ingrese el nombre de usuario:");
            Social.profileFrom(user);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        new Log_In(Social).setVisible(true);
        this.dispose();
    }

    // Variables declaration
    private javax.swing.JButton agregarAmigo;
    private javax.swing.JButton agregarComment;
    private javax.swing.JButton agregarPost;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton profileFrom;
    // End of variables declaration
}

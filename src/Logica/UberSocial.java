package Logica;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UberSocial {

    public ArrayList<SocialClass> clases;
    private String LogedIn;

    public UberSocial() {
        clases = new ArrayList<>();
    }

    public SocialClass buscar(String username, int indice) {
        if (indice < clases.size()) {
            System.out.println(clases.get(indice).getUsername());
            if (username.equals(clases.get(indice).Username)) {
                LogedIn = username;
                return clases.get(indice);
            } else {
                return buscar(username, indice + 1);
            }
        }
        return null;
    }

    public void agregarCuenta(String username, String tipo, boolean Crear) {
        for (SocialClass Cuentas : clases) {
            if (Cuentas.Friends.contains(username)) {
                Crear = false;
            }
            if (Cuentas.Username.equals(username)) {
                Crear = false;
            }
        }
        if (Crear) {
            switch (tipo) {
                case "FACEBOOK" ->
                    clases.add(new Facebook(username));
                default ->
                    clases.add(new Twitter(username));
            }
            JOptionPane.showMessageDialog(null, "Cuenta creada con exito!");
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe dicho nombre de usuario!");
        }
    }

    public void AgregarPost(String username, String Post) {
        for (SocialClass Cuenta : clases) {
            if (Cuenta.Username.equals(username)) {
                Cuenta.addPost(Post);
            }
        }
    }

    public boolean AgregarAmigo(String User1, String User2) {
        for (SocialClass Cuenta : clases) {
            if (Cuenta.Username.equals(User1)) {
                for (SocialClass CuentaExiste : clases) {
                    if (CuentaExiste instanceof Facebook && Cuenta instanceof Facebook) {
                        if (!Cuenta.Friends.contains(User2)) {
                            Cuenta.addFriends(User2);
                            return true;
                        }
                    } else if (CuentaExiste instanceof Twitter && Cuenta instanceof Twitter) {
                        if (!Cuenta.Friends.contains(User2)) {
                            Cuenta.addFriends(User2);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void agregarComment(String user, int postID, String autor, String comment) {
        SocialClass cuenta = buscar(user, 0);
        if (cuenta != null) {
            if (cuenta instanceof Facebook) {
                ((Facebook) cuenta).addComment(new Comment(autor, comment, postID));
                JOptionPane.showMessageDialog(null, "Comentario agregado correctamente.");
            } else if (cuenta instanceof Twitter) {
                JOptionPane.showMessageDialog(null, "Los comentarios solo pueden agregarse en Facebook.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El usuario no existe.");
        }
    }

    public void profileFrom(String user) {
        SocialClass cuenta = buscar(user, 0);
        if (cuenta != null) {
            cuenta.myProfile();
        } else {
            JOptionPane.showMessageDialog(null, "El usuario no existe.");
        }
    }

}

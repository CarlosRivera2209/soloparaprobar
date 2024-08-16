package Logica;

import javax.swing.JOptionPane;

public class Twitter extends SocialClass{

    public Twitter(String Username) {
        super(Username);
    }

    @Override
    public void TimeLine() {
        for (String Post : this.Posts){
            JOptionPane.showMessageDialog(null, Post, "Twitter Post", JOptionPane.INFORMATION_MESSAGE, null);
        }
    }
    
}

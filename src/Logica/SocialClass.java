package Logica;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public abstract class SocialClass {
    public ArrayList<String> Posts, Friends;
    protected String Username;
    
    public SocialClass(String Username){
        Friends = new ArrayList();
        this.Username = Username;
        Posts = new ArrayList();
    }
    
    public String getUsername(){
        return Username;
    }
    
    public boolean addFriends(String user){
        if (!user.equals(Username)){
            if (!Friends.contains(user)){
                Friends.add(user);
                return true;
            }
        }
        return false;
    }
    
    public void addPost(String MSG){
        Posts.add(MSG);
    }
    
    public void myProfile(){
        JOptionPane.showMessageDialog(null, "Username: "+Username);
        String Posteados = "";
        int messages = 0;
        TimeLine();
        for (int loop = 0; loop < Posts.size(); loop++){
            Posteados += loop + ". " + Friends.get(loop) + "\n'";
            messages++;
            if (messages == 10){
                JOptionPane.showMessageDialog(null, messages, "Amigos", JOptionPane.INFORMATION_MESSAGE);
                Posteados = "";
                messages = 0;
            }
        }
        if (messages != 0){
            JOptionPane.showMessageDialog(null, Posteados);
        }
    }
    
    public abstract void TimeLine();
    
}

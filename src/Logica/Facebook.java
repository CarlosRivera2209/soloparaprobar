package Logica;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Facebook extends SocialClass implements Commentable {
    protected ArrayList<Comment> Comentarios;
    
    public Facebook(String Username) {
        super(Username);
        Comentarios = new ArrayList();
    }
    
    public void TimeLine() {
        String PostInfo;
        for (int loop = 0; loop < Posts.size(); loop++){
            PostInfo = Posts.get(loop);
            for (int loopin = 0; loopin < Comentarios.size(); loopin++){
                if (Comentarios.get(loopin).getPostId() == loop){
                    PostInfo += "\n" + Comentarios.get(loopin).Print();
                }
            }
            JOptionPane.showMessageDialog(null, PostInfo, "Post", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public boolean addComment(Comment Comment) {
        Comentarios.add(Comment);
        return true;
    }
    
}

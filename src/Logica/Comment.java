package Logica;

import java.util.Calendar;
import java.util.Date;

public final class Comment {
    protected String Creator, Post;
    protected Date PostMadeIn;
    protected int PostId;
    
    public Comment(String Creator, String Post, int PostId) {
        PostMadeIn = Calendar.getInstance().getTime();
        this.Creator = Creator;
        this.PostId = PostId;
        this.Post = Post;
    }

    public String getCreator() {
        return Creator;
    }

    public Date getPostMadeIn() {
        return PostMadeIn;
    }

    public int getPostId() {
        return PostId;
    }    
    
    public String Print() {
        return Creator + " - " + PostMadeIn + "\n"+Post;
    }
    
}

package Visual;

import Logica.UberSocial;

public class Main {
    
    public static void main(String[] args) {
        UberSocial Social = new UberSocial();
        new Log_In(Social).setVisible(true);
    }

}

import java.rmi.*;

public class DistantPlayer {
    public static void main(String[] args) {
        try {
            IDistantGame game = (IDistantGame)Naming.lookup("rmi://localhost:1099/game");
            game.commencerJeu();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
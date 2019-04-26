import java.rmi.*;

public class DistantGameServer {
    public static void main(String[] args) {
        try {
            DistantGame game = new DistantGame();
            Naming.rebind("rmi://localhost:1006/game", game);
            System.out.println("Game server started.");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

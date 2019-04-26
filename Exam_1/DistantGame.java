import java.rmi.*;
import java.rmi.server.*;

public class DistantGame extends UnicastRemoteObject implements IDistantGame {
    public DistantGame() throws RemoteException {

    }

    public void commencerJeu() throws RemoteException {
        GameThread[] threads = new GameThread[5];
        Entier ent = new Entier(0);
        for (Thread t: threads){
            t = new GameThread(ent);
            t.start();
        }
    }
}
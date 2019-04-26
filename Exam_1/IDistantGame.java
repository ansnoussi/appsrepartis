import java.rmi.*;

public interface IDistantGame extends Remote {
    public void commencerJeu() throws RemoteException;
}
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServiceCalcul extends Remote {
    public int add(int a, int b) throws RemoteException;
}
import java.rmi.Remote; 
import java.rmi.RemoteException; 

public interface IServiceString extends Remote {
 public int NbOccurrence (String c, String mot) throws RemoteException; 
} 
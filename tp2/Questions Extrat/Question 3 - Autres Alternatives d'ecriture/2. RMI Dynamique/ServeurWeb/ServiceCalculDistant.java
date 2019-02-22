import java.rmi.*;
import java.rmi.server.*;

public class ServiceCalculDistant extends UnicastRemoteObject implements IServiceCalcul
{
    public ServiceCalculDistant() throws RemoteException {
    super();
    }
    public int add (int c, int m) throws
        RemoteException{
            return c+m;
    } 
}
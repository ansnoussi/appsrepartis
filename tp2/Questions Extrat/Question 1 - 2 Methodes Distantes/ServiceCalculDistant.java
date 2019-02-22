import   java.rmi.*; 
import java.rmi.server.*;

public class ServiceCalculDistant extends UnicastRemoteObject implements IServiceCalcul { 

	public ServiceCalculDistant()  throws RemoteException {
     super();
	}

	public int add (int a, int b) {
		return a+b;
	}
} 
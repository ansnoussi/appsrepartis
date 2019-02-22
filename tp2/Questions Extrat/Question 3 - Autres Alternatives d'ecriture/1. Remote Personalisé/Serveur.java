import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class Serveur {

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            System.out.println("Serveur : Construction de l’implémentation"); 
            IServiceString ssd = new ServiceStringDistant ();
            IServiceString stub = (IServiceString) UnicastRemoteObject.exportObject(ssd,0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("rmi://localhost:0/Mot",stub); 
            System.out.println("ServiceString lié dans RMIregistry");  
            System.out.println("Attente des invocations des clients ");
        } 
        catch (Exception e) {
        System.out.println("Erreur de liaison de l'objet");
        System.out.println(e.toString());
        }
    }
}
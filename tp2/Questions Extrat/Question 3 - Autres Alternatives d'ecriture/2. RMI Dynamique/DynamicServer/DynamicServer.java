import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
public class DynamicServer {
    public static void main(String[] args){
        System.setSecurityManager(new RMISecurityManager());
        try {
            Properties p = System.getProperties();
            String url = p.getProperty("java.rmi.server.codebase");
            
            System.out.println(url);
            System.out.println("hello");
            System.out.println("Serveur : Construction de l’implémentation");
            
            Class ClassServeur=RMIClassLoader.loadClass(url,"ServiceStringDistant");
            Naming.rebind("rmi://localhost:1099/String", (Remote)ClassServeur.newInstance());
            System.out.println("Hello ServiceString lié dans RMIregistry");

            Class ClassServeur1=RMIClassLoader.loadClass(url,"ServiceCalculDistant");
            Naming.rebind("rmi://localhost:1099/Add", (Remote)ClassServeur1.newInstance());
            System.out.println("Hello ServiceCalcul lié dans RMIregistry");
            
            System.out.println("Attente des invocations des clients ");
        }catch (Exception e) {			
            System.out.println("Erreur de liaison de l'objet ServiceString");
            e.printStackTrace();
        }
    }
}
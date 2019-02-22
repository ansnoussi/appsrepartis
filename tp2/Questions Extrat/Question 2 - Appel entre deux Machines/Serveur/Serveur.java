import   java.rmi.*;  
import java.rmi.server.*;  

public class Serveur {
 public static void main(String[] args) {
 	try {
 	 System.out.println("Serveur : Construction de l’implémentation"); 
     ServiceStringDistant ssd = new ServiceStringDistant (); 

        // De preference mettre l'IP de la machine du serveur : 192.168.1.37  
     Naming.rebind("rmi://localhost:1099/Mot", ssd); 
     System.out.println("ServiceString lié dans RMIregistry");  
     System.out.println("Attente des invocations des clients ");
     }
      catch (Exception e) {
       System.out.println("Erreur de liaison de l'objet");
        System.out.println(e.toString());
         }
     } 
 }
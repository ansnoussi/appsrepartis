import   java.rmi.*;  
import java.rmi.server.*;  

public class Serveur {
 public static void main(String[] args) {
 	try {
 	 System.out.println("Serveur : Construction de l’implémentation"); 
     ServiceStringDistant ssd1 = new ServiceStringDistant ();  
     Naming.rebind("rmi://localhost:1099/Mot", ssd1);  
     ServiceCalculDistant ssd2 = new ServiceCalculDistant ();  
     Naming.rebind("rmi://localhost:1099/ADD", ssd2);  
     System.out.println("ServiceString lié dans RMIregistry");  
     System.out.println("Attente des invocations des clients ");
     }
      catch (Exception e) {
       System.out.println("Erreur de liaison de l'objet");
        System.out.println(e.toString());
         }
     } 
 }
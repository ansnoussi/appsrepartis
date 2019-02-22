import java.io.*; 
import java.util.*; 
import java.rmi.*; 
 
public class ClientDistant {
	public static void main (String [] argv) throws IOException {
        int occ=0; 
        String c=argv[0], mot=argv[1]; 
		try {
			IServiceString s= (IServiceString) Naming.lookup("rmi://192.168.1.37:1099/Mot"); 
		    occ=s.NbOccurrence(c, mot); 
		    System.out.println(" Dans la phrase "+mot+", il y a "+occ+" occurrences de " + c);
		 }
		  catch (Exception e) {
		  System.out.println("Erreur d'acces a un objet distant");
		  System.out.println(e.toString());
		}
	}
}
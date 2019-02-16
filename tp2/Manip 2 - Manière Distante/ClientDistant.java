import java.io.*; 
import java.util.*; 
import java.rmi.*; 
 
public class ClientDistant {
	public static void main (String [] argv) throws IOException {
		int nb=0; String c, mot; c=argv[0]; mot=argv[1]; 
		try {IServiceString s= (IServiceString) Naming.lookup("rmi://localhost:1099/Mot"); 
		nb=s.NbOccurrence(c, mot); 
		System.out.println(" Dans la phrase "+mot+", il y a "+nb+" occurrences de " + c);
		 }
		 catch (Exception e) {
		  System.out.println("Erreur d'acces a un objet distant");
		   System.out.println(e.toString());
		}
	}
} 
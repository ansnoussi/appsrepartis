import java.io.*; 
import java.util.*; 
import java.rmi.*; 
 
public class ClientDistant {
	public static void main (String [] argv) throws IOException {
        int occ=0; 
        String c=argv[0], mot=argv[1]; 
		int a,b,nb;
		 a=Integer.parseInt(argv[2]); 
		 b=Integer.parseInt(argv[3]);
		try {
			IServiceString s= (IServiceString) Naming.lookup("rmi://localhost:1099/Mot"); 
		    occ=s.NbOccurrence(c, mot); 
		    System.out.println(" Dans la phrase "+mot+", il y a "+occ+" occurrences de " + c);
		 }
		  catch (Exception e) {
		  System.out.println("Erreur d'acces a un objet distant");
		  System.out.println(e.toString());
		}
		try {
			IServiceCalcul l= (IServiceCalcul) Naming.lookup("rmi://localhost:1099/ADD"); 
		    nb=l.add(a,b);
		    System.out.println(a + " + " + b + " = " + nb);
		 }
		  catch (Exception e) {
		  System.out.println("Erreur d'acces a un objet distant");
		  System.out.println(e.toString());
		}
	}
} 
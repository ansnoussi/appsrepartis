import java.io.*;
import java.util.*;
import java.rmi.*;
public class ClientDistant{
	public ClientDistant (String [] argv) throws IOException{
		
		int somme=0,Nb=0;
		String c, mot;
		c=argv[0];
		
		mot=argv[1];
		int i = Integer.parseInt(argv[2]);
		int j = Integer.parseInt(argv[3]);
		try {
			
			IServiceCalcul a= (IServiceCalcul)Naming.lookup("rmi://192.168.8.100:1099/Add");
			somme = a.add(i, j);
			IServiceString s= (IServiceString)Naming.lookup("rmi://192.168.8.100:1099/String");
			Nb=s.NbOccurrences(c, mot);
			System.out.println(" Dans la phrase "+mot+", il y a "+Nb+" occurrences de " + c);
			System.out.println(" la somme des deux valeurs est: "+somme);
		}catch (Exception e) {
			System.out.println("Erreur d'acces a un objet distant");
			System.out.println(e.toString());
		}
	}
}
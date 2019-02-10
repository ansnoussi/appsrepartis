import java.io.*; 
public class SerializerPersonne {   
	public static void main(String args[]) {     
		Personne personne = new Personne("Dupond","Jean",175,"code");     
		try {       
			FileOutputStream fichier = new FileOutputStream("personne.ser");       
			ObjectOutputStream oos = new ObjectOutputStream(fichier);       
			oos.writeObject(personne);       
			oos.flush();       
			oos.close();}     
			catch (java.io.IOException e) {
				e.printStackTrace();}
			}

		} 
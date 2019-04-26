import java.io.*; 

public class SerializerEtudiant {   
	public static void main(String args[]) { 
		Adresse adr = new Adresse(200, "Ariana");
		CompteBancaire banque = new CompteBancaire(11012,200,"Ariana");    
		Etudiant etudiant = new Etudiant("SNOUSSI","Anis",175,1700248,"GL2",banque,adr) ;    
		try {      
			FileOutputStream fichier = new FileOutputStream("etudiant.ser");       
			ObjectOutputStream oos = new ObjectOutputStream(fichier);       
			oos.writeObject(etudiant);       
			oos.flush();       
			oos.close();
			}     
			catch (java.io.IOException e) {
				e.printStackTrace();}
			}

		} 

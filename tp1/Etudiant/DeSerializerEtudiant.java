import java.io.*; 

public class DeSerializerEtudiant {  
	public static void main(String args[]){    
		try {      
			FileInputStream fichier = new FileInputStream("etudiant.ser");      
			ObjectInputStream ois = new ObjectInputStream(fichier);      
			Etudiant etudiant = (Etudiant) 
			ois.readObject();      
			System.out.println("Personne : ");      
			System.out.println("nom : " + etudiant.getNom());      
			System.out.println("prenom : " + etudiant.getPrenom());      
			System.out.println("taille : " + etudiant.getTaille()); 
			System.out.println("num Carte Etudiant : " + etudiant.getNumEtudiant()) ;
			System.out.println("niveau : " + etudiant.getNiveau());
			System.out.println("rue (Etudiant): " + etudiant.getAdresse().getRue());
			System.out.println("code postal  (Etudiant): " + etudiant.getAdresse().getCodePostal());
			System.out.println("id Banque :" + etudiant.getCompteBancaire().getIdBanque());
			System.out.println("rue (compte bancaire): " + etudiant.getCompteBancaire().getAdresse().getRue() );
			System.out.println("code postal (compte bancaire): " + etudiant.getCompteBancaire().getAdresse().getCodePostal());
		}     
			catch (java.io.IOException e) {      
				e.printStackTrace();    
			}    
			catch (ClassNotFoundException e) {      
				e.printStackTrace();    
			}   
			}

}
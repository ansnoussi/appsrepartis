public class Personne implements java.io.Serializable { 

 private String nom = "";
 private String prenom = "";
 private int taille  = 0;
 private transient String codeSecret = "";

    public Personne(String nom, String prenom, int taille,String codeSecret) { 
      this.nom = nom;
      this.taille = taille;
      this.prenom = prenom;
      this.codeSecret = codeSecret;
  }

    public String getNom() {
      return nom;
  } 

    public void setNom(String nom) {
     this.nom = nom;
 }  

    public int getTaille() {
     return taille;
 } 

    public void setTaille(int taille){
     this.taille = taille;
 } 

    public String getPrenom() {
      return prenom;
  }

    public void setPrenom(String prenom){
      this.prenom = prenom;
  }

  public void setCodeSecret(String codeSecret){
  	this.codeSecret = codeSecret;
  }

  public String getCodeSecret(){
  	return codeSecret;
  }

} 
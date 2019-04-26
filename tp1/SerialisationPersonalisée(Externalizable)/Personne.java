import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

public class Personne implements java.io.Externalizable { 

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
    public Personne(){

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

   public void writeExternal(final ObjectOutput out) throws IOException {

    out.writeUTF(new StringBuilder(this.nom).reverse().toString().toUpperCase());
    out.writeUTF(new StringBuilder(this.prenom).reverse().toString().toUpperCase());
    out.writeInt(this.taille * 2019 );
    out.writeUTF(new StringBuilder(Integer.toString(Integer.parseInt(this.codeSecret) * 19)).reverse().toString());
}


   public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {

    this.nom = new StringBuilder(in.readUTF()).reverse().toString().toLowerCase();
    this.prenom = new StringBuilder(in.readUTF()).reverse().toString().toLowerCase();
    this.taille = (in.readInt()) /2019 ;
    this.codeSecret = new StringBuilder(Integer.toString(Integer.parseInt(in.readUTF()) / 19)).reverse().toString();
    }

} 

public class Etudiant extends Personne{
	private int numEtudiant;
	private String niveau ;
	private CompteBancaire banque;
	private Adresse adr ;

	public Etudiant(String nom, String prenom, int taille,int numEtudiant,String niveau,CompteBancaire banque, Adresse adr){
		super(nom,prenom,taille);
		this.numEtudiant = numEtudiant;
		this.niveau = niveau;
		this.banque = banque;
		this.adr = adr;
	}

	public void setNumEtudiant(int numEtudiant){
		this.numEtudiant = numEtudiant;
	}

	public void setNiveau(String niveau){
		this.niveau = niveau;
	}

	public int getNumEtudiant(){
		return numEtudiant;
	}

	public String getNiveau(){
		return niveau;
	}

	public void setCompteBancaire(CompteBancaire banque){
		this.banque = banque;
	}

	public CompteBancaire getCompteBancaire(){
		return banque;
	}

	public void setAdresse(Adresse adr){
		this.adr = adr;
	}

	public Adresse getAdresse(){
		return adr ;
	}
}
public class CompteBancaire implements java.io.Serializable{
	private int idBanque ;
	private Adresse adr ;
	
	public CompteBancaire(int idBanque , int codePostal , String rue){
		this.idBanque = idBanque;
		adr = new Adresse(codePostal, rue);
	}

	public void setIdBanque(int idBanque){
		this.idBanque = idBanque;
	}

	public int getIdBanque(){
		return idBanque;
	}

	public Adresse getAdresse(){
		return adr ;
	}
}
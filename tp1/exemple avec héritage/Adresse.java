class Adresse implements java.io.Serializable{
	private int codePostal = 0 ;
	private String rue = "" ;
	Adresse(int codePostal , String rue){
		this.codePostal = codePostal;
		this.rue = rue ;
	}
	void setRue(String rue){
		this.rue = rue;
	}
	String getRue(){
		return this.rue;
	}	
	void setCodePostal(int codePostal){
		this.codePostal = codePostal;
	}
	int getCodePostal(){
		return this.codePostal;
	}
}
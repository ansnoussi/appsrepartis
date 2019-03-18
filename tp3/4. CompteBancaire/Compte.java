public class Compte {
	private int valeur ;
	Compte (int val ) { 
		valeur = val ; 
		}
	
	public synchronized int solde () { 
		return valeur ;
		}
	
	public synchronized void depot (int somme ){ 
		if ( somme > 0) 
			valeur += somme ; 
	}
	
	public synchronized boolean retirer(int somme )throws InterruptedException {
			if ( somme > 0)
				if ( somme <= valeur ) {
					Thread.currentThread().sleep(50);
					valeur -= somme ;
					Thread.currentThread().sleep(50);
					return true ;
				}
			return false ;
	}
}


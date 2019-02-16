class ServiceString{ 
	public int NbOccurrences(String c, String mot) { 
		int longueur=mot.length(); 
		int Nb=0; 
		for (int i=0; i<longueur; i++) {
			if ((mot.substring(i, i+1)).equals(c))
			 Nb++;
		} 
			return Nb;
		}
	} 
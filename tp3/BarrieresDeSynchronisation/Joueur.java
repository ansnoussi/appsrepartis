public class Joueur extends Thread {
	private int id;
	private Barriere b;
	public Joueur(int id, Barriere b) {
		this.id = id;
		this.b = b;
	}
	public void run() {
		//echauffement
        System.out.println( id +" en attente");
		b.attendre();
		//commencer la course
		System.out.println(id + " a terminé!");
	}
}

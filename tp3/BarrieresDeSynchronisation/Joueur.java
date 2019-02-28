public class Joueur extends Thread {
	private int id;
	private Barriere b;
	public Joueur(int id, Barriere b) {
		this.id = id;
		this.b = b;
	}
	public void run() {
		//echauffement
		for (int i = 0; i < 1000; i++)
		System.out.println(id + ": " + i);
		b.attendre();
		//commencer la course
		System.out.println(id + " a terminé!");
	}
}

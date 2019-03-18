import java.util.concurrent.*;

public class Joueur extends Thread {
	private int id;
	CyclicBarrier b;
	public Joueur(int id, CyclicBarrier b) {
		this.id = id;
		this.b = b;
	}
	public void run() {
		//echauffement
		for (int i = 0; i < 1000; i++){
        System.out.println(id + ": " + i);
        }  
		try {
           b.await();
         } catch (InterruptedException ex) {
           return;
         } catch (BrokenBarrierException ex) {
           return;
         }
         //commencer la course
         System.out.println(id + " a termine!");
	}
}
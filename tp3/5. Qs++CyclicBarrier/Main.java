import java.util.concurrent.*;
public class Main {
	public static void main(String[] args) {
		CyclicBarrier b = new CyclicBarrier(50);
		for (int i = 0; i < 50; i++) {
			Joueur j = new Joueur(i, b);
			j.start();
		}
	}
}

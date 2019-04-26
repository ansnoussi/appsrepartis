public class GameThread extends Thread {
    private Entier i; 
    public GameThread(Entier i) {
        this.i = i;
    }

    public void run() {
        try {
        while (true) {
            synchronized(i) {
                if (i.getValue() == 20) {
                    System.out.println("Thread " + getId() + ": Congratulations.");
                    break;
                }
                
                i.setValue(i.getValue() + 1);
                if (i.getValue() == 20) {
                System.out.println("Thread " + getId() + ": Je suis le gagnant"); 
                break;
                }

                Thread.sleep(50);
            }
        }
    } catch(Exception e) {
        e.printStackTrace();
    }
    }
}
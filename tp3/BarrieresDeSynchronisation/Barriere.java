public class Barriere{
    private int nombreTotal;
    private int nombreActif;

    public Barriere(int nombreTotal){
        this.nombreTotal=nombreTotal;
    }

    public synchronized void attendre(){
        nombreActif++;
        try
        {
            if(nombreActif==nombreTotal){notifyAll(); nombreActif = 0 ;}
            else wait();
        }
            catch (InterruptedException e) {e.printStackTrace();}
    }
}

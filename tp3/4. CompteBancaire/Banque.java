public class Banque implements Runnable {
 Compte nom;
 Banque(Compte n) {
  nom = n;
 }

 public synchronized void liquide(int montant) throws InterruptedException {
  if (nom.retirer(montant)) {
   Thread.currentThread().sleep(50);
   donne(montant);
   Thread.currentThread().sleep(50);
  } else {
   System.out.println(Thread.currentThread().getName() + ": Tu peux pas prendre " + montant + " euros .");
  }
  imprimeRecu();
  Thread.currentThread().sleep(50);
 }

 public void donne(int montant) throws InterruptedException {

  System.out.println(Thread.currentThread().getName() + ": Voici vos " + montant + " euros .");
 }
 public void imprimeRecu() {
  if (nom.solde() > 0)
   System.out.println(Thread.currentThread().getName() + ": Il vous reste " + nom.solde() + " euros.");
  else
   System.out.println(Thread.currentThread().getName() + ": Vous etes fauches !");
 }

 public void run() {
  try {
   for (int i = 1; i < 10; i++) {
    synchronized(System.out) {
     liquide(100 * i);
     Thread.currentThread().sleep(100 + 10 * i);
    }
   }
  } catch (InterruptedException e) {
   return;
  }
 }

 public static void main(String[] args) {
  Compte Commun = new Compte(1000);
  Runnable Mari = new Banque(Commun);
  Runnable Femme = new Banque(Commun);
  Thread tMari = new Thread(Mari);
  tMari.setName(" Conseiller Mari");
  Thread tFemme = new Thread(Femme);
  tFemme.setName(" Conseiller Femme ");
  tMari.start();
  tFemme.start();
 }
}
import   java.rmi.*; 
import java.rmi.server.*;

 public class ServiceStringDistant extends UnicastRemoteObject implements IServiceString {
  public ServiceStringDistant() throws RemoteException {
   super();
    } 
    public int NbOccurrence (String c, String mot) throws RemoteException {
     int longueur=mot.length(); 
     int Nb=0; 
     for (int i=0; i<longueur; i++) { 
     	if ((mot.substring(i, i+1)).equals(c)) Nb++;
     } 
     return Nb;
      } 
  } 
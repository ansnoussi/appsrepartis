public class ClientLocal{ 
 
public static void main(String [] args){ 
 
    ServiceString os = new ServiceString(); 
    ServiceCalcul oc = new ServiceCalcul(); 
    int i=os.NbOccurrences("h","hello world hello everybody"); 
    int j =oc.add(2,5); 
    System.out.println(i); 
    System.out.println(j);
   }
 }
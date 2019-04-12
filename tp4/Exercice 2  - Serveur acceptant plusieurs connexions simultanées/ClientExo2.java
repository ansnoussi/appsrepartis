import java.io.*;
import java.net.*;
import java.util.Scanner;
public class ClientExo2 {
    public static void main(String[] args) {
        InetAddress hote = null;
        int port = 1973; // par défaut
        Socket socket = null;
        try {
            if( args.length>=1 ) hote = InetAddress.getByName(args[0]);
            else hote = InetAddress.getLocalHost();
            if( args.length==2 ) port = Integer.parseInt(args[1]) ;
        } catch (UnknownHostException e) {}

        try {
            socket = new Socket(hote,port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            int compteur =0;
            while(compteur<10){
                String msg = in.readLine();
                System.out.println(msg);
                compteur++;
                out.println("Je suis le client "+hote+" et j'ai fait "+compteur+" appels");
                try{
                    System.out.println("pause de 2 secondes");
                    Thread.sleep(2000);
                }
                catch(InterruptedException e) {}

            }
            out.println("");
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
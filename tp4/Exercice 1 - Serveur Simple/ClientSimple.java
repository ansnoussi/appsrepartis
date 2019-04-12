import java.io.*;
import java.net.*;
import java.util.Scanner;
class ClientSimple {
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

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String reply = in.readLine();
            System.out.println(reply);

            Scanner sc = new Scanner(System.in);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            System.out.println("ecrire un message au serveur:");
            out.println(sc.nextLine());
            out.flush();
            
            socket.close();
        } catch (IOException e) {
        }
    }
}
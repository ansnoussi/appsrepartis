import java.io.*; 
import java.net.*; 
public class Sender{
		InetAddress hote = null; 
		int port = 1973; // par défaut 
		Socket socket = null; 
		BufferedReader in;
		PrintWriter printWriter;
	void connect(String []args){
		
	try { 
		if( args.length>=1 ) 
			hote = InetAddress.getByName( args[0] ); 
		else hote = InetAddress.getLocalHost(); 
		if( args.length==2 ) 
			port = Integer.parseInt( args[1] ) ;
		socket = new Socket(hote, port);
		
	}catch(Exception e){}
}
	void send(){
		try{
		 in = new BufferedReader(                         
			new InputStreamReader(socket.getInputStream())
		);
		String st = in.readLine();                  
		System.out.println(st);
		 printWriter = new PrintWriter(socket.getOutputStream());
		printWriter.println("je suis le sender");
		printWriter.flush();
	}catch(Exception e){};
	}

	public static void main(String [] args){
		Sender sender=new Sender();
		sender.connect(args);
		sender.send();
	}
}
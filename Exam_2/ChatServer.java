
import java.io.*; 
import java.net.*; 
public class ChatServer{

	public static void main (String [] args){
		
		try            
		{             
			ServerSocket socketServer=new ServerSocket(1973);
			Socket sender =socketServer.accept();
			Socket reciever=socketServer.accept();  
			PrintWriter outSender = new PrintWriter(sender.getOutputStream());                 
			outSender.println("Reciever Connected!");                 
			outSender.flush();    
			BufferedReader inSender = new BufferedReader(                         
			new InputStreamReader(sender.getInputStream()));                 
			String reply=inSender.readLine();
			PrintWriter outReciever = new PrintWriter(reciever.getOutputStream());                 
			outReciever.println(reply);                 
			outReciever.flush();    
		} 
		catch (Exception e) {             
			System.err.println("Impossible de creer un ServerSocket");             
			return;         
		}         


	}
}
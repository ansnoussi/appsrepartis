

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.*;
public class ThreadClient extends Thread{
	    public String name;
		Socket socket;
		DataInputStream dis;
		DataOutputStream dos;
	public ThreadClient(Socket socket,DataInputStream dis,DataOutputStream dos) {
		this.socket=socket;
		this.dis=dis;
		this.dos=dos;
	}
	
	public void run() {
	try{
	    name=dis.readUTF();
	    if(ServerIRC.clientNames.contains(new String(name))){
	    dos.writeUTF("no");
	    return ;
	    }else dos.writeUTF("yes");
	    }catch(IOException e){
	    
	    }
	    ServerIRC.clientNames.add(name);
		while(true) {
			try {
				String s=dis.readUTF();
				StringTokenizer st=new StringTokenizer(s,":");
				String name=st.nextToken();
				String msg=st.nextToken();
				if(msg.equals("List")){
				String msg2="List : \n";
				  for(int i=0;i<ServerIRC.clientNames.size();i++){
				     msg2+=ServerIRC.clientNames.get(i)+"\n";
				 }
				 System.out.println(msg2);
				dos.writeUTF(msg2);
				}else if(msg.equals("Bye") || msg.equals("Leave") || msg.equals("Quit") || msg.equals("Exit")){
				ServerIRC.clientNames.remove(new String(name));
				socket.close();
				break;
				}else if(msg.equals("Msg")){
				System.out.println("Client "+name+" envoie une message prive :"+st.nextToken()); 
				}
				else{
			
				for(ThreadClient th : ServerIRC.clients) {
					if(!th.equals(this)) th.dos.writeUTF(s);
				}
				}
			} catch (IOException e) {
	                ServerIRC.clientNames.remove(new String(name));
	                break;
			}
			
		}
	}
}

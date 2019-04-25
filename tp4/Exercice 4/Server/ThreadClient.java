

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadClient extends Thread{
	
		Socket socket;
		DataInputStream dis;
		DataOutputStream dos;
	public ThreadClient(Socket socket,DataInputStream dis,DataOutputStream dos) {
		this.socket=socket;
		this.dis=dis;
		this.dos=dos;
	}
	
	public void run() {
		while(true) {
			try {
				String s=dis.readUTF();
				for(ThreadClient th : ServerIRC.clients) {
					if(!th.equals(this)) th.dos.writeUTF(s);
				}
				
			} catch (IOException e) {

			}
		}
	}
}

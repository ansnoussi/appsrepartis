

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ServerIRC {
	static Vector<ThreadClient> clients = new Vector<>();
	public static void main(String[] args) throws IOException {
			int port = 8500;
			ServerSocket serverSocket = new ServerSocket(port);
			int i=0;
			while(i!=1) {
				Socket client=serverSocket.accept();
				DataInputStream dis = new DataInputStream(client.getInputStream());
				DataOutputStream dos=new DataOutputStream(client.getOutputStream());
				ThreadClient thclient=new ThreadClient(client,dis,dos);
				clients.add(thclient);
				thclient.start();
			}
	}

}

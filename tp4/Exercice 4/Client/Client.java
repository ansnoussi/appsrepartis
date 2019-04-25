

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static Scanner in=new Scanner(System.in);
	String name;
	Socket socket ;
	DataInputStream dis;
	DataOutputStream dos;
	MyFrame myFrame;
	public Client(String name,String host,int port) {
		this.name=name;
		myFrame=new MyFrame();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
			socket = new Socket(host,port);
			dis=new DataInputStream(socket.getInputStream());
			dos=new DataOutputStream(socket.getOutputStream());
			
			Thread readMessage=new Thread(new Runnable() {
				@Override
				public void run() {
					while(true) {
					try {
						String msg=dis.readUTF();
						myFrame.ta.append(msg+"\n");
					} catch (IOException e) {
					}
					}
				}
			});
			
			Thread sendMessage=new Thread(new Runnable() {
				@Override
				public void run() {
				
						myFrame.tf.addKeyListener
						  (new KeyAdapter() {
						     public void keyPressed(KeyEvent e) {
						    	 
						       int key = e.getKeyCode();
						       if (key == KeyEvent.VK_ENTER) {
						          Toolkit.getDefaultToolkit().beep();  
						          String msg=myFrame.tf.getText();
						          try {
						        	  dos.writeUTF(name+":"+msg);
									 myFrame.tf.setText("");
								}catch (IOException e1) {
									// TODO Auto-generated catch block
									}
						         
						        }
						       }
						     }
						  );
					}
				}
			);
			readMessage.start();
			sendMessage.start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
	public static void main(String [] args) {
		System.out.println("Donner votre nom :");
		String n=in.nextLine();
		Client c1=new Client(n,"127.0.0.1",8500);
	}
}

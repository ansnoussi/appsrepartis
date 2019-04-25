
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyFrame extends Frame{
	public TextArea ta;
	public TextField tf;
	public Button bu;
	public MyFrame() {
	this.setSize(700,400);
	ta=new TextArea();
	tf=new TextField();
	bu=new Button("Quitter");
	this.setLayout(new BorderLayout());
	this.add(ta,BorderLayout.CENTER);
	this.add(tf,BorderLayout.SOUTH);
	this.add(bu,BorderLayout.NORTH);
	ta.setEditable(false);
	tf.setFont(new Font("Serif", Font.PLAIN, 16));
	ta.setFont(new Font("Serif", Font.PLAIN, 16));
	this.addWindowListener(new MyWindowAdapter());
	
	}
	
}

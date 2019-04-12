import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
class ClientFenetre extends Frame implements Runnable, ActionListener{
    TextArea Output;
    TextField Input;
    Socket socket = null;
    BufferedReader in ;
    PrintWriter out ;
    public ClientFenetre(String hote, int port){
        super("Client en fenetre");
        // mise en forme de la fenetre (frame)
        setSize(500,700);
        setLayout(new BorderLayout());
        this.add( Output=new TextArea(),BorderLayout.CENTER );
        Output.setEditable(false);
        this.add( Input=new TextField(), BorderLayout.SOUTH );
        Input.addActionListener(this);
        pack();
        show();
        Input.requestFocus();
        // ajout d'un window adapter pour reagir si on ferme la fenetre
        addWindowListener(new WindowAdapter () {
            public void windowClosing (WindowEvent e) {
                setVisible(false);
                dispose();
                System.exit(0);
            }
        });
        try{
            socket = new Socket(hote,port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread t=new Thread(this);
        t.start();
    }
    public void run () {
        try{
            int compteur =0;
            while(compteur<10){
                String msg = in.readLine();
                Output.append(msg+"\n");
                compteur++;
            }
        } catch (IOException e) {
            e.printStackTrace();
            }
        }
    public void actionPerformed (ActionEvent e) {
        if (e.getSource()==Input) {
            String phrase=Input.getText();
            out.println(phrase);
            Input.setText("");
        }
    }
    protected void finalize() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String hote = null;
        int port = 1973; // par d faut
        ClientFenetre chatwindow = new ClientFenetre(hote, port);
    }
}
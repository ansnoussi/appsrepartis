public class MyThread extends Thread{

public int number ;

public MyThread(int n){
	this.number = n;
}

public void run(){
	System.out.println(number);
	System.out.println(number);
}

public static void main(String [] args){

	MyThread[] th = new MyThread[10];
	for(int i =0; i<10 ; i++){
		th[i] = new MyThread(i+1);
		th[i].start();
	}

}

}

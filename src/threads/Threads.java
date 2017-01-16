package threads;

public class Threads {
	public static void main(String[] args) {
		MyThread2 t = new MyThread2();
		Thread thread = new Thread(t);
		thread.start();
	}
}

class MyThread extends Thread{
	@Override
	public void run() {
		System.out.println("My thread 1");
	}
}

class MyThread2 implements Runnable{
	public void run() {
		System.out.println("My thread 2");
	}
}
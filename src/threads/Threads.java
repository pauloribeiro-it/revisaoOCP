package threads;

public class Threads {
	public static void main(String[] args) {
		MyThread2 t1 = new MyThread2();
		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t1);
		thread1.setPriority(Thread.MAX_PRIORITY);
		thread1.start();
		thread2.setPriority(Thread.MIN_PRIORITY);
		thread2.start();
		Thread.yield();
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
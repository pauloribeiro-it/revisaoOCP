package threads;

public class ThreadJoinExample {
	public static void main(String[] args) throws Exception{
		JoinThread myThreadExample = new JoinThread();
		Thread joinThread = new Thread(myThreadExample);
		Thread.sleep(3000);
		joinThread.start();
		joinThread.join();
		System.out.println("Main Thread finished");
	}
}

class JoinThread implements Runnable {
	public void run() {
		try {
			Thread.sleep(5000);
			System.out.println("MyThread sleep finished");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
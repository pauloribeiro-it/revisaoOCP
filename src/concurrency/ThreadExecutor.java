package concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadExecutor {
	private final static Integer MAX_THREADS = 4;
	
	public static void main(String[] args) {
		Runnable myRunnableToExecutor = new MyRunnableTask();
		Runnable myRunnableToCachedThread = new MyRunnableTask();
		Runnable myRunnableToFixedThread = new MyRunnableTask();
		
		Executor executor = new NewThreadExecutor();
		executor.execute(myRunnableToExecutor);
		
		Executor executorServiceToCachedThread = Executors.newCachedThreadPool();
		executorServiceToCachedThread.execute(myRunnableToCachedThread);
		
		Executor executorServiceToFixedThread = Executors.newFixedThreadPool(MAX_THREADS);
		executorServiceToFixedThread.execute(myRunnableToFixedThread);
	}
}

class SameThreadExecutor implements Executor{
	public void execute(Runnable command) {
		command.run();
	}
}

class NewThreadExecutor implements Executor{
	public void execute(Runnable command) {
		Thread thread = new Thread(command);
		thread.start();
	}
}

class MyRunnableTask implements Runnable{
	public void run() {
		System.out.println("MyRunnableTask run");
	}
}
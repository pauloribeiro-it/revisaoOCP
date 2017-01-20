package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class CallableAndFuture {
	public static void main(String[] args) {
		Callable<Integer> c = new MyCallable();
		ExecutorService ex = Executors.newCachedThreadPool();
		Future<Integer> f = ex.submit(c);
		try{
			Integer v = f.get();
			System.out.println(v);
		}catch(InterruptedException | ExecutionException e){
			System.out.println("Failed");
		}
	}
}

class MyCallable implements Callable<Integer> {
	public Integer call() throws Exception {
		int count = ThreadLocalRandom.current().nextInt(1, 11);
		for (int i = 1; i <= count; i++) {
			System.out.println("Running..." + i);
		}
		return count;
	}
}
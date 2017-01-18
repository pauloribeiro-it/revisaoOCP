package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
	private AtomicInteger count = new AtomicInteger();
	
	public void increment(){
		count.getAndIncrement();
	}
	
	public int getValue(){
		return count.intValue();
	}
	
	public static void main(String[] args) {
		Counter counter = new Counter();
		counter.increment();
		counter.increment();
	}
}

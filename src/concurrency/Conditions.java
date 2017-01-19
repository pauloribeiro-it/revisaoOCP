package concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Conditions {
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Condition blockingPoolA = lock.newCondition();
		lock.lock();
		try {
			blockingPoolA.await(); //wait
			blockingPoolA.signal();//notify
		} catch (InterruptedException ex) {}
		finally {
			lock.unlock();
		}
	}
}

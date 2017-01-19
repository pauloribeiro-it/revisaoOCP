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
			blockingPoolA.await(); // "wait" here
			// lock will be reacquired
			// work
		} catch (InterruptedException ex) {
			// interrupted during await()
		} finally {
			// to ensure we unlock
			lock.unlock();
			// must manually release
		}
	}
}

package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locks {
	public static void main(String[] args) {
		
	}
	
	public void useLock(){
		Lock lock = new ReentrantLock();
		try{
			lock.lock();
		}finally{
			lock.unlock();
		}
	}
	
	public void tryLock(){
		Lock lock = new ReentrantLock();
		boolean isLocked = lock.tryLock();
		if(isLocked){
			try{
				System.out.println("lock ok");
			}finally{
				lock.unlock();
			}
		}
	}
}

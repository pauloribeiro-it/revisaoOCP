package concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLocks {
	private List<Integer> integers = new ArrayList<>();
	private ReadWriteLock lock = new ReentrantReadWriteLock();
	
	public void add(Integer i){
		lock.writeLock();
		try{
			integers.add(i);
		}finally{
			lock.writeLock().unlock();
		}
	}
	
	public int findMax(){
		lock.readLock().lock();
		try{
			return Collections.max(integers);
		}finally{
			lock.readLock().unlock();
		}
	}
}

package threads;

public class Operator extends Thread {
	public void run() {
		while (true) {
			// Get shape from user
			synchronized (this) {
				// Calculate new machine steps from shape
				notify();
			}
		}
	}
}

class Machine extends Thread {
	Operator operator; // assume this gets initialized

	public void run() {
		while (true) {
			synchronized (operator) {
				try {
					operator.wait();
				} catch (InterruptedException ie) {}
				// Send machine steps to hardware
			}
		}
	}
}
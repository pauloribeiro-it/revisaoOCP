package trycatchwithresources;

import java.io.Closeable;
import java.io.IOException;

	
public class Animals2 {
	class Lamb implements Closeable {
		public void close() {
			throw new RuntimeException("a");
		}
	}

	public static void main(String[] args) throws Exception {
		new Animals2().run();
	}

	public void run() {
		try (Lamb l = new Lamb();) {
			throw new IOException();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getSuppressed().length);
			//throw new RuntimeException("c");
		}
	}
}

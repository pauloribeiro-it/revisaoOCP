package watchservice;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchService;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;

public class WatchServiceNIO {
	public static void main(String[] args) throws IOException, InterruptedException {
		final String pathDirectory = "watchServiceDirectory";
		Path directory = Paths.get(pathDirectory);
		
		Files.deleteIfExists(directory);
		Files.createDirectories(directory);
		
		WatchService watchService = registerWatchService(directory);
		Thread thread = new Thread(new DealEntriesThread(pathDirectory));
		thread.start();
		thread.join();
		
		watchDirectory(directory, watchService);
	}

	private static WatchService registerWatchService(Path directory) throws IOException {
		WatchService watchService = FileSystems.getDefault().newWatchService();
		directory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE);
		return watchService;
	}

	private static void watchDirectory(Path directory, WatchService watchService) throws IOException {

		while (true) {
			WatchKey key = null;
			try {
				key = watchService.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
			for (WatchEvent<?> event : key.pollEvents()) {
				WatchEvent.Kind<?> kind = event.kind();
				System.out.println(kind.name());
				System.out.println(kind.type());
				System.out.println(event.context());
				String name = event.context().toString();
				System.out.println("Context name = " + name);
				if (kind.name().equals(StandardWatchEventKinds.ENTRY_DELETE.toString()))
					return;
			}
			key.reset();
		}
	}
}

class DealEntriesThread implements Runnable {
	private String directoryPath;

	public DealEntriesThread(String directoryPath) {
		this.directoryPath = directoryPath;
	}

	@Override
	public void run() {
		Path file1 = Paths.get(directoryPath, "file1.txt");
		Path file2 = Paths.get(directoryPath, "file2.txt");
		try {
			Files.createFile(file1);
			Files.createFile(file2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

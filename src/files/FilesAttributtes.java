package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class FilesAttributtes {
	public static void main(String[] args) throws IOException {
		useBasicFileAttributtes();
	}

	public static void useBasicFileAttributtes() throws IOException {
		Path path = Paths.get("file.txt");
		if (Files.exists(path))
			Files.createFile(path);
		BasicFileAttributes bfa = Files.readAttributes(path,
				BasicFileAttributes.class);
		System.out.println("Creation time: " + bfa.creationTime());
		System.out.println("Last time modified: " + bfa.lastModifiedTime());
	}

	public static void useBasicFileAttributtesView() throws IOException {
		Path path = Paths.get("file.txt");
		if (Files.exists(path))
			Files.createFile(path);
		
		BasicFileAttributes bfa = Files.readAttributes(path,
				BasicFileAttributes.class);
		
		BasicFileAttributeView basic = Files.getFileAttributeView(path,
				BasicFileAttributeView.class);
		FileTime lastUpdated = bfa.lastAccessTime(); 
		FileTime created = bfa.creationTime();
		FileTime now = FileTime.fromMillis(System.currentTimeMillis());
		basic.setTimes(lastUpdated, created, now);
	}
}

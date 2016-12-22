package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class FilesAttributtes {
	public static void main(String[] args) throws IOException {
		useBasicFileAttributtes();
	}

	public static void useBasicFileAttributtes() throws IOException {
		Path path = Paths.get("file.txt");
		Files.createFile(path);
		BasicFileAttributes bfa = Files.readAttributes(path,BasicFileAttributes.class);
		System.out.println("Creation time: "+bfa.creationTime());
		System.out.println("Last time modified: "+bfa.lastModifiedTime());
	}
}

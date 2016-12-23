package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStreams {
	public static void main(String[] args) throws IOException {
		createDirectoryAndFiles();
	}
	
	public static void createDirectoryAndFiles() throws IOException{
		Path directory1 = Paths.get("directory1");
		if(!Files.exists(directory1)){
			Files.createDirectory(directory1);
		}
		Files.createDirectory(Paths.get("directory1","subdirectory1"));
		Files.createDirectory(Paths.get("directory1","subdirectory2"));
	}
}

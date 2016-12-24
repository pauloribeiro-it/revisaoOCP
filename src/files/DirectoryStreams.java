package files;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStreams {
	private static final String DIRECTORY_NAME = "directory1";
	
	public static void main(String[] args) throws IOException {
		createDirectoryAndFiles();
		createDirectoryStream("v*");
		System.out.println("-----");
		createDirectoryStream("w*");
	}
	
	public static void createDirectoryAndFiles() throws IOException{
		Path directory1 = Paths.get(DIRECTORY_NAME);
		verifyDirectoryExistence(directory1);
		verifyDirectoryExistence(Paths.get(DIRECTORY_NAME,"vsubdirectory1"));
		verifyDirectoryExistence(Paths.get(DIRECTORY_NAME,"wsubdirectory2"));
	}
	
	public static void createDirectoryStream(String expression) throws IOException{
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(DIRECTORY_NAME),expression)){
			for(Path path:stream)
				System.out.println(path);
		}
	}
	
	private static final void verifyDirectoryExistence(Path directory) throws IOException{
		if(!Files.exists(directory)){
			Files.createDirectory(directory);
		}
	}
	
}

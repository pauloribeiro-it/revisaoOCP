package filevisitor;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitorTest extends SimpleFileVisitor<Path>{
	private static final String path = "fileVisitorDirectory";
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {
		if(file.getFileName().toString().endsWith(".dat")){
			System.out.println(file.getFileName() + " will be removed.");
			Files.delete(file);
		}
		return FileVisitResult.CONTINUE;
	}
	
	public static void main(String[] args) throws IOException {
		createDirectoryAndFiles();
		Files.walkFileTree(Paths.get(path),new FileVisitorTest());
	}
	
	private static void createDirectoryAndFiles() throws IOException{
		Path directory = Paths.get(path);
		Files.createDirectory(directory);
		
		Path file1 = Paths.get(path,"file.bat");
		Path file2 = Paths.get(path,"file.dat");
		Path file3 = Paths.get(path,"file.txt");
		createFile(file1);
		createFile(file2);
		createFile(file3);
	}
	
	private static void createFile(Path path) throws IOException{
		if(!Files.exists(path)) 
			Files.createFile(path);
	}
}

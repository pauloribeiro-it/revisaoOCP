package filevisitor;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitorTeste2 extends SimpleFileVisitor<Path> {
	private static final String PATH = "home";
	private static final String PATH2 = "child";

	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
		System.out.println("pre: " + dir);
		String name = dir.getFileName().toString();
		if(name.equals("grandchild")){
			return FileVisitResult.SKIP_SUBTREE; //Interrompe a busca no mesmo n�vel e nos n�veis abaixo
//			return FileVisitResult.SKIP_SIBLINGS; //Interrompe a busca nos n�veis abaixo
		}
		return FileVisitResult.CONTINUE;
	}

	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
		System.out.println("file: " + file);
		return FileVisitResult.CONTINUE;
	}

	public FileVisitResult visitFileFailed(Path file, IOException exc) {
		return FileVisitResult.CONTINUE;
	}

	public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
		System.out.println("post: " + dir);
		return FileVisitResult.CONTINUE;
	}
	
	private static void createDirectoriesAndFiles() throws IOException {
		// TODO Revisar isso aqui
		Files.createDirectories(Paths.get(PATH));
		createFile(Paths.get(PATH, "a.txt"));
		Files.createDirectories(Paths.get(PATH, "emptychild"));
		Files.createDirectories(Paths.get(PATH, PATH2));
		createFile(Paths.get(PATH, PATH2, "b.txt"));
		Files.createDirectories(Paths.get(PATH, PATH2, "grandchild"));
		Files.createFile(Paths.get(PATH, PATH2, "grandchild", "c.txt"));
	}

	private static void createFile(Path file) throws IOException {
		if (!Files.exists(file)) {
			Files.createFile(file);
		}
	}

	public static void main(String[] args) throws IOException {
//		createDirectoriesAndFiles();
		Files.walkFileTree(Paths.get(PATH), new FileVisitorTeste2());
	}
}

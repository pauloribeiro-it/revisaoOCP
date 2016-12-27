package pathmatcher;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class PathMatcherTest {
	
	private final static String PATH_SCENARIO1 = "scenario1";
	
	public static void main(String[] args) throws IOException{
//		testScenario1();
		testScenario2();
	}
	
	private static void testScenario1() throws IOException{
		createDirectoriesAndFilesScenario1();
		PathMatcher pathMatcher1 = FileSystems.getDefault().getPathMatcher("glob:*.txt");
		PathMatcher pathMatcher2 = FileSystems.getDefault().getPathMatcher("glob:**/*.txt"); //glob:*/*.txt
		System.out.println("Find using first way? "+pathMatcher1.matches(Paths.get(PATH_SCENARIO1,"One.txt")));
		System.out.println("Find using second way? "+pathMatcher2.matches(Paths.get("./scenario1/One.txt")));
	}
	
	private static void testScenario2() throws IOException{
//		createDirectoriesAndFilesScenario2();
		PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:{Bert,Kathy}*");//glob:{Bert,Kathy}* - glob:{Bert*,Kathy*}
		System.out.println("Match Bert? "+pathMatcher.matches(Paths.get("Bert-book")));
		System.out.println("Match Kathy? "+pathMatcher.matches(Paths.get("Kathy-horse")));
	}
	
	private static void createDirectoriesAndFilesScenario1() throws IOException{
		Files.createDirectories(Paths.get(PATH_SCENARIO1));
		createFile(Paths.get(PATH_SCENARIO1,"One.txt"));
	}
	
	private static void createDirectoriesAndFilesScenario2() throws IOException{
		Files.createDirectories(Paths.get("Bert-book"));
		Files.createDirectories(Paths.get("Kathy-horse"));
	}
	
	public static void createFile(Path path) throws IOException{
		if(Files.notExists(path)){
			Files.createFile(path);
		}
	}
}

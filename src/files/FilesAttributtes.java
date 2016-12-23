package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;

public class FilesAttributtes {
	public static void main(String[] args) throws IOException {
		//useBasicFileAttributtes();
//		useDosFileAttribute(true, true);
		useDosFileAttribute(false, false);
	}

	public static void useBasicFileAttributtes() throws IOException {
		Path path = Paths.get("file.txt");
		if (!Files.exists(path))
			Files.createFile(path);
		BasicFileAttributes bfa = Files.readAttributes(path,
				BasicFileAttributes.class);
		System.out.println("Creation time: " + bfa.creationTime());
		System.out.println("Last time modified: " + bfa.lastModifiedTime());
	}

	public static void useBasicFileAttributtesView() throws IOException {
		Path path = Paths.get("file.txt");
		if (!Files.exists(path))
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
	
	public static void useDosFileAttribute(boolean readOnly,boolean hidden) throws IOException{
		Path path = Paths.get("dosFile.txt");
		
		if(!Files.exists(path))
			Files.createFile(path);
		
		Files.setAttribute(path, "dos:hidden", hidden);
		Files.setAttribute(path, "dos:readonly", readOnly);
		DosFileAttributes dfa = Files.readAttributes(path, DosFileAttributes.class);
		System.out.println("IsHidden: "+dfa.isHidden());
		System.out.println("ReadOnly: "+dfa.isReadOnly());
	}
	
	public static void useDosFileAttributeView(boolean readOnly,boolean hidden) throws IOException{
		Path path = Paths.get("dosFile.txt");
		
		if(!Files.exists(path))
			Files.createFile(path);
		
		DosFileAttributeView dfav = Files.getFileAttributeView(path, DosFileAttributeView.class);
		dfav.setHidden(hidden);
		dfav.setReadOnly(readOnly);
	}
}

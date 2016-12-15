package files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilesOld {
	public static void main(String[] args) throws IOException {
		File file = new File("teste.txt");
		writeOldFile(file);
		readOldFile(file);
	}

	public static void writeOldFile(File file) throws IOException {
		if(!file.exists())
			file.createNewFile();
		else{
			try(FileWriter fw = new FileWriter(file);BufferedWriter bw = new BufferedWriter(fw)){
				bw.write("teste\n");
				bw.write("oi");
			}
		}
	}
	
	public static void readOldFile(File file) throws IOException{
		try(FileReader fr = new FileReader(file);BufferedReader br = new BufferedReader(fr)){
			int i = 1;
			while(br.ready()){
				System.out.println(br.readLine());
				i++;
			}
			System.out.println(i);
		}
	}
}

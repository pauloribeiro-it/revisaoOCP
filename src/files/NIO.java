package files;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class NIO {
	public static void main(String[] args) throws IOException {
		// verificaExistenciaArquivo();
		// createFile();
		// copy();
		// delete();
		// move();
		// normalizePath();
		resolve();
	}

	public static void verificaExistenciaArquivo() {
		String way1 = "C:\\Users\\Paulo\\Desktop\\Estudos\\Java\\NIO\\teste.txt";
		String way2[] = { "C:", "Users", "Paulo", "Desktop", "Estudos", "Java",
				"NIO", "teste.txt" };
		Path arquivo1 = Paths.get(way1);
		Path arquivo2 = Paths.get(way2[0], way2[1], way2[2], way2[3], way2[4],
				way2[5], way2[6], way2[7]);
		Path arquivo3 = Paths
				.get(URI.create("file:///C:/Users/Paulo/Desktop/Estudos/Java/NIO/teste.txt"));
		System.out.println(Files.exists(arquivo1));
		System.out.println(Files.exists(arquivo2));
		System.out.println(Files.exists(arquivo3));
	}

	public static void createFile() throws IOException {
		String path = "C:\\Users\\Paulo\\Desktop\\Estudos\\Java\\NIO\\testeCriacao.txt";
		Path arquivo = Paths.get(path);
		if (!Files.exists(arquivo))
			Files.createFile(arquivo);
	}

	public static void copy() throws IOException {
		String caminhoArquivoExistente = "C:\\Users\\Paulo\\Desktop\\Estudos\\Java\\NIO\\testeCriacao.txt";
		String caminhoCopiaArquivo = "C:\\Users\\Paulo\\Desktop\\Estudos\\Java\\NIO\\testeCriacaoCopia.txt";
		Path arquivoExistente = Paths.get(caminhoArquivoExistente);
		Path arquivoCopia = Paths.get(caminhoCopiaArquivo);
		Files.copy(arquivoExistente, arquivoCopia,
				StandardCopyOption.REPLACE_EXISTING);
	}

	public static void delete() throws IOException {
		String caminho = "C:\\Users\\Paulo\\Desktop\\Estudos\\Java\\NIO\\teste.txt";
		Files.deleteIfExists(Paths.get(caminho));
	}

	public static void move() throws IOException {
		String caminhoOrigem = "C:\\Users\\Paulo\\Desktop\\Estudos\\Java\\NIO\\origem\\origem.txt";
		String caminhoDestino = "C:\\Users\\Paulo\\Desktop\\Estudos\\Java\\NIO\\destino\\destino.txt";
		Path arquivoOrigem = Paths.get(caminhoOrigem);
		Path arquivoDestino = Paths.get(caminhoDestino);
		Files.move(arquivoOrigem, arquivoDestino,
				StandardCopyOption.REPLACE_EXISTING);
	}

	public static void normalizePath() throws IOException {
		Files.createDirectories(Paths.get("Build_Project"));
		Files.createDirectories(Paths.get("Build_Project\\scripts"));
		Files.createDirectories(Paths.get("My_Project"));
		Files.createDirectories(Paths.get("My_Project\\source"));

		String buildProject = "/Build_Project/scripts";
		String upTwoDirectories = "../..";
		String myProject = "/My_Project/source";
		Path path = Paths.get(buildProject, upTwoDirectories, myProject);

		System.out.println("Original: " + path);
		System.out.println("Normalized: " + path.normalize());
	}

	public static void resolve() {
		Path absolute1 = Paths.get("/home/java");
		Path absolute2 = Paths.get("/usr/local");
		Path absolute3 = Paths.get("/home/java/temp/music.txt");
		Path relative1 = Paths.get("temp");
		Path relative2 = Paths.get("temp/music.pdf");
		System.out.println("1: " + absolute1.relativize(absolute3));
		System.out.println("2: " + absolute3.relativize(absolute1));
		System.out.println("3: " + absolute1.relativize(absolute2));
		System.out.println("4: " + relative1.relativize(relative2));
		// System.out.println("5: " + absolute1.relativize(relative1));//BAD
	}

}

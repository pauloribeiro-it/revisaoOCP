package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializator {
	
	private static final String NOME_ARQUIVO = "objects.dat";
	
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		Pessoa p1 = new Pessoa("Paulo",23);
		p1.setSexo("M");
		escreveNoArquivo(p1);
		Pessoa pessoa = leDoArquivo();
		System.out.println("Nome da pessoa = "+pessoa.getNome()+" "+pessoa.getSexo());
	}
	
	public static void escreveNoArquivo(Pessoa pessoa)throws IOException{
		try(FileOutputStream fos = new FileOutputStream(NOME_ARQUIVO);ObjectOutputStream os = new ObjectOutputStream(fos)){
			os.writeObject(pessoa);
		}
	}
	
	public static Pessoa leDoArquivo()throws IOException, ClassNotFoundException{
		try(FileInputStream fis = new FileInputStream(NOME_ARQUIVO);ObjectInputStream ois = new ObjectInputStream(fis)){
			return ((Pessoa)ois.readObject());
		}
	}
}

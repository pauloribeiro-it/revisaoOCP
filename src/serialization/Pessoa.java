package serialization;

import java.io.Serializable;

public class Pessoa implements Serializable{
	
	private static final long serialVersionUID = -319668287218757543L;
	private String nome;
	private Integer idade;
	private String sexo;
	private Teste t = new Teste();
	
	public Pessoa(){
		this.sexo="F";
	}
	
	public Pessoa(String nome, Integer idade) {
		this.nome = nome;
		this.idade = idade;
		this.sexo="F";
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
}
class Teste{}

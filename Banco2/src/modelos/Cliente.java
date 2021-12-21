package modelos;

public class Cliente {
	
	// Atributos
	private int codigo, idade;
	private String nome, cidade;
	
	// Get e Set
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	// Construtores
	public Cliente() {}
	
	public Cliente(int codigo, String nome, int idade, String cidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.idade = idade;
		this.cidade = cidade;
	}
	
}
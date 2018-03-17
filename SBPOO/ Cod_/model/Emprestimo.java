package model;

public class Emprestimo {

	private String matricula_aluno;
	private String codigo_livro;
	private String nome;
	private String categoria;



	public String getMatricula_aluno() {
		return matricula_aluno;
	}

	public void setMatricula_aluno(String matricula_aluno) {
		this.matricula_aluno = matricula_aluno;
	}

	public Emprestimo(String nome,String matricula_aluno, String codigo_livro, String categoria ) {
		/*
		 * Construtor do vetor de Emprestimo! Responsabilidade de Emprestimo
		 */
		this.nome=nome;
		this.matricula_aluno = matricula_aluno;
		this.codigo_livro = codigo_livro;
		this.categoria = categoria;
		

	}

	public String getCodigo_livro() {
		return codigo_livro;
	}

	public void setCodigo_livro(String codigo_livro) {
		this.codigo_livro = codigo_livro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}

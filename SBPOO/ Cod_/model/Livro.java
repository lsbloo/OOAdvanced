package model;

public class Livro {
	private String nome;
	private int qtLivros;
	private String autor;
	private String codigo_livro;
	private String data_lancamento;
	private boolean emp;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getCodigo_livro() {
		return codigo_livro;
	}
	public void setCodigo_livro(String codigo_livro) {
		this.codigo_livro = codigo_livro;
	}
	public String getData_lancamento() {
		return data_lancamento;
	}
	public void setData_lancamento(String data_lancamento) {
		this.data_lancamento = data_lancamento;
	}
	public boolean getEmp() {
		return emp;
	}
	public void setEmp(boolean emp) {
		this.emp = emp;
	}
	
	
	public Livro(String nome_livro ,String codigo_livro, int qtLivros, String data_lancamento,String autor){
		this.nome=nome_livro;
		this.qtLivros=qtLivros;
		this.codigo_livro=codigo_livro;
		this.data_lancamento=data_lancamento;
		this.autor=autor;
	}
	public int getQtLivros() {
		return qtLivros;
	}
	public void setQtLivros(int qtLivros) {
		this.qtLivros = qtLivros;
	}
	

}

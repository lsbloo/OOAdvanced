package model;

public class Professor extends Pessoa {
	private String codigo;
	private String curso;
	private boolean emp;
	private int cont = 0;
	/*
	 * Classe Professor herda de Pessoa Atributos -codigo,-login,-senha
	 */

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public Professor(String nome, String cpf, String rg, String curso, String codigo) {
		setNome(nome);
		setCpf(cpf);
		setRg(rg);
		this.codigo = codigo;
		this.curso = curso;
		setEmp(true);
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public boolean isEmp() {
		return emp;
	}

	public void setEmp(boolean emp) {
		this.emp = emp;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}
	public int getCont() {
		return cont;
	}

}

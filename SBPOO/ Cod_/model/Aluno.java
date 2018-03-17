package model;

public class Aluno extends Pessoa{
	private String matricula;
	private String curso;
	private boolean emprestimo;
	
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public void setMatricula(String matricula){
		this.matricula=matricula;
	}
	public String getMatricula(){
		return matricula;
	}
	
	public Aluno(String nome_aluno,String cpf_aluno,String matricula_aluno,String rg_aluno, String curso){
		this.matricula=matricula_aluno;
		this.curso = curso;
		setNome(nome_aluno);
		setCpf(cpf_aluno);
		setRg(rg_aluno);
		setEmprestimo(true);
	}
	public boolean isEmprestimo() {
		return emprestimo;
	}
	public void setEmprestimo(boolean emprestimo) {
		this.emprestimo = emprestimo;
	}

}

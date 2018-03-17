package control;
import model.Aluno;
public interface Data_Aluno_Inter {
	
	public void AddAluno(Aluno aluno);
	public void ListarAluno();
	public int QntAlunos();
	public Aluno buscarObjetoAluno(String nome_aluno);
	/*
	 * Login de Aluno {Independente ADM!}
	 */
	public void realizarAcessoAluno(String nome_aluno,String matricula_aluno);
	
	

}

package control;
import model.Professor;
public interface Data_Professor_Inter{
	
	public void addProfessor(Professor professorn);
	public void ListarProfessor();
	public int QntProfessores();
	
	
	
	public void realizarAcessoProfessor(String nome_prof,String codigo_prof);
	/*
	 * Search
	 */
	public boolean buscarProfessor(String nome_professor);
}

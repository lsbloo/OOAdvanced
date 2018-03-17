package control;
import model.Livro;
public interface Data_Livro_inter {
	
	
	public void addLivro(Livro livro);
	public void listarLivro();
	public int  qntLivro();
	public void removerLivro(String nome_livro);
	public boolean BuscarLivro(String nome_livro);
	
	
	
	/*
	 * Método de devolucao de Livros();
	 */
	
	 
	public boolean xlFF();
}

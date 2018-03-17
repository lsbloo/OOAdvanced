package control;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;


import model.Livro;
import model.Strategy;

public class Data_Livro implements Data_Livro_inter ,Strategy{

	public LinkedList<Livro> livros = new LinkedList<Livro>();
	static boolean vlivro;
	static int quantidadeLivro_original;

	public void addLivro(Livro livro) {
		livros.add(livro);
	}

	public void ListarLivro() {
		for (Livro livro : livros) {
			System.out.println("Nome: " + " " + livro.getNome() + " Paginas: " + " " + livro.getQtLivros() + " "
					+ " Codigo: " + livro.getCodigo_livro() + " " + " Autor: " + livro.getAutor() + " "
					+ " Data Lan�amento: " + livro.getData_lancamento() + " " + " Disponivel: ");

		}

	}

	public int qntLivro() {
		if (livros.size() > 0) {
			vlivro = true;
			return livros.size();
		} else {
			vlivro = false;
			return 0;
		}

	}

	public void removerLivro(String nome_livro) {
		for (Livro livro : livros) {
			if (livro.getNome().equals(nome_livro)) {
				livros.remove(livro);
			}

		}

	}

	public boolean BuscarLivro(String nome_livro) {
		for (Livro livro : livros) {
			if (livro.getNome().equals(nome_livro)) {
				return true;
			}
		}
		return false;
	}

	public int qtLivros(String codigo_livro) {
		for (Livro livro : livros) {
			if (livro.getCodigo_livro().equals(codigo_livro)) {// Livro Existe!
				return livro.getQtLivros();
			}
		}
		return 0;

	}
	public Livro buscarObjetoLivro(String nome) {
		for (Livro livro: livros){
				if(livro.getNome().equals(nome)){
					return livro;
				}
		}
		return null;
	}


	public boolean xlFF() {
		if (vlivro) {
			return true;
		}
		return vlivro;
	}

	@Override
	public void listarLivro() {
		// TODO Auto-generated method stub

	}

	@Override
	public void armazenarIO() {
		// TODO Auto-generated method stub
		try {
			// LINUX > > > File file = new
			// File("/home/osvaldoairon/Documentos/SBPOO/Livros.txt"); quebra de
			// linha linux /n
			File file = new File("Livros.txt"); // Windows Desktop ! quebra de
												// linha windows >> /r/n
			String dados_livros = "";
			String conteudo;

			FileWriter arq = new FileWriter(file);
			arq.write("--------------- Relatório de Livros Salvos pelo Sistema ---------------------");
			arq.write("\r\n");
			for (Livro livro : livros) {

				dados_livros = "Nome: " + livro.getNome() + "\r\n" + "Quantidade de Livros: " + livro.getQtLivros()
						+ "\r\n" + "Codigo: " + livro.getCodigo_livro() + "\r\n" + "Autor: " + livro.getAutor() + "\r\n"
						+ "Lançamento: " + livro.getData_lancamento();
				arq.write("\r\n");
				conteudo = dados_livros;
				conteudo += "\r\n";

				arq.write(conteudo);

			}
			arq.write("------------------------------------------------------------------------------");
			arq.write("\r\n");
			arq.write("Armazenados com sucesso!");
			arq.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

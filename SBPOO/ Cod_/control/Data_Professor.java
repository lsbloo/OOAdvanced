package control;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import model.Professor;
import model.Strategy;

public class Data_Professor implements Data_Professor_Inter, Strategy {
	/*
	 * #Classe Responsavel por armazanementos de Dados tipo Aluno # Métodos
	 * addAluno - , ListarAlunos , -QuantidadeAluno , -pesquisaAluno;
	 * #OBSERVAÇÃO - PRECISA IMPORTAR DO PACOTE MODEL A CLASSE PROFESSOR PARA
	 * FAZER OPERACOES;
	 * 
	 */
	static boolean acesso_professor;
	static boolean dado_professor;

	public LinkedList<Professor> professores = new LinkedList<Professor>();
	static int qnt_Professor;

	public void addProfessor(Professor professor) {
		professores.add(professor);
		// System.out.println("Professor Adicionado!");
	}

	public void ListarProfessor() {
		for (int i = 0; i < professores.size(); i++) {
			System.out.println("Nome: " + professores.get(i).getNome() + " Codigo: " + professores.get(i).getCodigo()
					+ " CPF: " + professores.get(i).getCpf() + " RG: " + professores.get(i).getRg());
		}

	}

	public void alterarProfessor(String nome, Professor professor_editado) {
		for (Professor professor : professores) {
			if (professor.getNome().equals(nome)) {
				professores.remove(professor);
				professores.add(professor_editado);

			}

		}
	}

	public int QntProfessores() {
		if (professores.size() > 0) {
			dado_professor = true;
			return professores.size();
		}
		return 0;
	}

	public boolean checkProfessor(String codigo) {
		for (Professor professor : professores) {
			if (professor.getCodigo().equals(codigo)) {
				if (professor.getCont() > 3) {
					return false;
				}

			}
		}
		return true;
	}

	public boolean checkProfessor2(String nome) {
		for (int i = 0; i < professores.size(); i++) {
			if (professores.get(i).getNome().equals(nome)) {
				return true;
			}
		}
		return false;
	}

	public void adicionarCont(String codigo) {
		for (Professor professor : professores) {
			if (professor.getCodigo().equals(codigo)) {
				int cont = professor.getCont();
				cont = cont + 1;
				professor.setCont(cont);
			}
		}
	}

	public void removeCont(String codigo) {
		for (Professor professor : professores) {
			if (professor.getCodigo().equals(codigo)) {
				int cont = professor.getCont();
				cont = cont - 1;
				professor.setCont(cont);
			}
		}
	}

	public String retornaNome(String codigo) {
		for (int i = 0; i < professores.size(); i++) {
			if (professores.get(i).getCodigo().equals(codigo)) {
				return professores.get(i).getNome();
			}
		}
		return null;
	}

	public void realizarAcessoProfessor(String nome_prof, String codigo_prof) {
		// TODO Auto-generated method stub
		if (dado_professor) {
			for (int i = 0; i < professores.size(); i++) {
				if (professores.get(i).getNome().equals(nome_prof)) {
					if (professores.get(i).getCodigo().equals(codigo_prof)) {
						acesso_professor = true;
					}
				}
			}
		}

	}

	public boolean acessoProfessor() {
		if (acesso_professor) {
			return true;
		}
		return acesso_professor;
	}

	public boolean mataAcessoProf() {
		if (acesso_professor) {
			acesso_professor = false;
		}
		return acesso_professor;
	}

	public boolean buscarProfessor(String nome_professor) {
		for (int i = 0; i < professores.size(); i++) {
			if (professores.get(i).getNome().equals(nome_professor)) {
				return true;
			}
		}
		return false;
	}

	public Professor buscarObjetoProfessor(String nome) {
		for (Professor professor : professores) {
			if (professor.getNome().equals(nome)) {
				return professor;
			}
		}
		return null;
	}

	@Override
	public void armazenarIO() {
		// TODO Auto-generated method stub
		try {
			// File file = new
			// File("/home/osvaldoairon/Documentos/SBPOO/Professores.txt");
			File file = new File("Professores.txt");
			String dados_prof = "";
			String conteudo;

			FileWriter arq = new FileWriter(file);
			arq.write("--------------- Relatório de Professores Salvos pelo Sistema ---------------------");
			arq.write("\r\n");
			for (int i = 0; i < professores.size(); i++) {

				dados_prof = "Nome: " + professores.get(i).getNome() + "\r\n" + "Código: "
						+ professores.get(i).getCodigo() + "\r\n" + "CPF: " + professores.get(i).getCpf() + "\r\n"
						+ "RG: " + professores.get(i).getRg();
				arq.write("\r\n");
				conteudo = dados_prof;
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

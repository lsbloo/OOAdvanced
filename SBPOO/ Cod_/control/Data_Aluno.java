package control;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import model.Aluno;
import model.Strategy;

public class Data_Aluno implements Data_Aluno_Inter,Strategy {
	static int qnt_Aluno;
	static boolean dados_alunos;
	public LinkedList<Aluno> alunos = new LinkedList<Aluno>();
	static boolean acesso_aluno;

	public int QntAlunos() {
		qnt_Aluno = alunos.size();
		if (alunos.size() >= 1) {
			dados_alunos = true;
			return alunos.size();
		}
		return 0;
	}

	public void AddAluno(Aluno aluno) {
		alunos.add(aluno);

	}

	public void ListarAlunos() {
		for (Aluno aluno : alunos) {
			System.out.println("Nome: " + aluno.getNome() + " Registro Geral: " + aluno.getRg() + " Matricula: "
					+ aluno.getMatricula() + " CPF: " + aluno.getCpf() + " CURSO: " + aluno.getCurso());

		}

	}

	public String retornaNome(String matricula) {
		for (Aluno aluno : alunos) {
			if (aluno.getMatricula().equals(matricula)) {
				return aluno.getNome();
			}
		}
		return null;
	}

	public void realizarAcessoAluno(String nome_aluno, String cpf_aluno) {
		if (dados_alunos) {
			for (int i = 0; i < alunos.size(); i++) {
				if (alunos.get(i).getNome().equals(nome_aluno)) {
					if (alunos.get(i).getCpf().equals(cpf_aluno)) {
						acesso_aluno = true;

					}

				}
			}

		}

	}

	public boolean acessoAluno() {
		if (acesso_aluno) {
			return acesso_aluno;
		}
		return acesso_aluno;
	}

	public boolean mataAcessoAluno() {
		/*
		 * 
		 */
		if (acesso_aluno) {
			acesso_aluno = false;
		}
		return acesso_aluno;
	}

	public boolean checkAluno(String matricula) {
		for (Aluno aluno : alunos) {
			if (aluno.getMatricula().equals(matricula)) {
				if (aluno.isEmprestimo()) {
					return true;
				}
			}
		}
		return false;
	}
	public boolean checkAlunoNome(String nome){
		for (Aluno aluno : alunos) {
			if (aluno.getNome().equals(nome)) {
					return true;
				}
			}
		return false;
		}
		

	public void alterarEmprestimoTrue(String matricula) {
		for (Aluno aluno : alunos) {
			if (aluno.getMatricula().equals(matricula)) {
					aluno.setEmprestimo(true);
				}
			}
		}

	public void alterarEmprestimoFalse(String matricula) {
		for (Aluno aluno : alunos) {
			if (aluno.getMatricula().equals(matricula)) {
					aluno.setEmprestimo(false);
				}
			}
		}
	

	public void alterarAluno(String nome, Aluno aluno_editado) {
		for (Aluno aluno : alunos) {
			if (aluno.getNome().equals(nome)) {
				alunos.remove(aluno);
				alunos.add(aluno_editado);

			}

		}
	}

	public boolean verificaA(String nome_aluno, String matricula_aluno) {
		for (Aluno aluno : alunos) {
			if (aluno.getNome().equals(nome_aluno) && aluno.getMatricula().equals(matricula_aluno)) { // Aluno
																										// Existe
				return true;

			}
		}
		return false;
	}

	@Override
	public void ListarAluno() {
		// TODO Auto-generated method stub

	}

	public Aluno buscarObjetoAluno(String nome) {
		for (Aluno aluno : alunos){
				if(aluno.getNome().equals(nome)){
					return aluno;
				}
		}
		return null;
	}

	@Override
	public void armazenarIO() {
		// TODO Auto-generated method stub
		/*
		 * Funcao para armazenar dados do array em um diretorio(arquivo)
		 * {Alunos}
		 */

		try {
			// File file = new
			// File("/home/osvaldoairon/Documentos/SBPOO/Alunos.txt");
			File file = new File("Alunos.txt"); // quebra de linha \r\n
			String dados_aluno = "";
			String conteudo;

			FileWriter arq = new FileWriter(file);
			arq.write("--------------- Relatório de Alunos Salvos pelo Sistema ---------------------");
			arq.write("\r\n");
			for (int i = 0; i < alunos.size(); i++) {

				dados_aluno = "Nome: " + alunos.get(i).getNome() + "\r\n" + "Matricula: " + alunos.get(i).getMatricula()
						+ "\r\n" + "CPF: " + alunos.get(i).getCpf() + "\r\n" + "Curso: " + alunos.get(i).getCurso()
						+ "\r\n" + "RG: " + alunos.get(i).getRg();
				arq.write("\r\n");
				conteudo = dados_aluno;
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



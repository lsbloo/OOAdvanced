package model;

import java.io.IOException;

public class Disp extends Pilha_ADM implements Observer  {

	public Subject objectm;
	static int cont_obs;

	Pilha_ADM logs = new Pilha_ADM();

	public Disp(ObjectM obj) {
		// TODO Auto-generated constructor stub
		this.objectm = obj;
		objectm.registrarObserver(this);

	}


	@Override
	public void update(String nome_adm, String senha_adm) throws IOException {
		/*
		 * Logs> \/
		 * 
		 */
		logs.Empilhar(nome_adm);
		display();

	}
	
	
	public void display() throws IOException {
		/*
		 * Imprime saida recente
		 */
		// System.out.println("Nome: "+nome_adm+" "+"Senha: "+senha_adm);
		System.err.println("Funcao display-Observer Atualizada!");
		logs.salvarLogs();
		cont_obs++;
	}

	public void showInfC() {
		System.out.println(cont_obs);
	}
}

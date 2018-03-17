package control;

import java.io.IOException;
import java.util.ArrayList;

import model.Administrador;
import model.Disp;
import model.ObjectM;

public class Data_ADM implements Login_Acesso_Singleton {

	ArrayList<Administrador> administradores = new ArrayList<Administrador>();
	static int qnt_ADM;
	static final String senha_padrao = "49946325";
	static boolean acesso;

	/*
	 * Observer \./
	 */
	ObjectM obj = new ObjectM();
	Disp disp = new Disp(obj);

	public void addAdm(Administrador adm) {
		administradores.add(adm);
		//System.err.println(administradores.size());
		//System.out.println(adm.getNome_adm());
	}
	
	public void listarADM() {
		//System.err.println(administradores.size());
		//System.out.println("Lista Vazia"+administradores.isEmpty());
		/*
		 * Listar ADM LINKEDlist();
		 */
		for(int i = 0 ; i<administradores.size();i++){
			System.err.println(administradores.get(i).getNome_adm());
		}
	}

	public int QntADM() {
		qnt_ADM = administradores.size();
		System.out.println(qnt_ADM);
		return qnt_ADM;
	}

	
		
	public void realizarAcesso(String login, String senha) throws IOException {
		
		for (int i=0;i<administradores.size();i++) {
			if (administradores.get(i).getLogin().equals(login)) {
				if (administradores.get(i).getSenha().equals(senha)) {
					acesso = true;
					obj.setLogs(login, senha_padrao);
					
				} else {
					acesso=false;
				}
			}
		}
	}

	public boolean Acesso() {
		return acesso;
	}

	public boolean mataAcesso() {
		/*
		 * essa funcao \\ // Mata o retorno verdadeiro do acesso , permitindo
		 * assim uma nova checagem se outro Frame for aberto;
		 */
		if (acesso) {
			acesso = false;
		}
		return acesso;
	}

}

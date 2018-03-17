package model;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;


public class Pilha_ADM implements Pilha_adm_inter {
	/*
	 * Classe Responsavel pelo Registro de Log do sistema
	 * utiliza a estrutura de dados Pilha {FIFO}
	 * Objetivo: Realizar o registro e saida do relatorio de logins feitos
	 * pelo sistema , trabalha em conjunto com o Padrão Observer();
	 */
	LinkedList<String > pilha = new LinkedList<String>();
	

	@Override
	public void Empilhar(String adm) {
		// TODO Auto-generated method stub
		pilha.add(adm);
		//System.out.println("Adicionado!");
		
	}

	@Override
	public void Desempilhar() {
		// TODO Auto-generated method stub
		pilha.remove(0);
		System.out.println("Removido!");
	}

	@Override
	public void verifica_fast() {
		// TODO Auto-generated method stub
		System.out.println("Tamanho da pilha!"+pilha.size());
	}
	public void salvarLogs(){
		try{
			File logs = new File("Registro de Log.txt");
			
			
			FileWriter arq = new FileWriter(logs);
			arq.write("------------------------  Registo de Log do Sistema -------------------");
			arq.write("\r\n");
			for(int i = 0 ; i<pilha.size();i++){
				arq.write("Logs usuario: "+pilha.get(i));
				arq.write("\r\n");
				
			}
			arq.write("------------------------------------------------------------------------------");
			arq.write("\r\n");
			arq.write("Registro Log ADM");
			arq.close();
			
		}catch(IOException e){
			System.err.println("erro log adm!");
		}
	}
	
}
	
	



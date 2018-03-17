package model;

import java.io.IOException;
import java.util.ArrayList;

public class ObjectM implements Subject{
	private ArrayList<Observer> observadores;
	private String nome_adm;
	private String senha_adm;
	
	
	public ObjectM (){
		observadores = new ArrayList<Observer>();
	}
	@Override
	public void registrarObserver(Observer o) {
		// TODO Auto-generated method stub
		/*
		 * Adicionando objeto observer em arraylist;
		 */
		observadores.add(o);
		
		
	}

	@Override
	public void removerObserver(Observer o) {
		// TODO Auto-generated method stub
		int i = observadores.indexOf(o);
		if(i >= 0){
			observadores.remove(i);
		}
		
	}

	@Override
	public void notificarObservers() throws IOException {
		// TODO Auto-generated method stub
		for(int i = 0 ; i<observadores.size();i++){
			Observer observer = null;
			try {
				observer = (Observer)observadores.get(i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			observer.update(nome_adm, senha_adm);
		}
		
	}
	public void trocaM() throws IOException{
		notificarObservers();
		
	}
	public void setLogs(String nome_adm,String senha_adm) throws IOException{
		this.nome_adm = nome_adm;
		this.senha_adm = senha_adm;
		trocaM();
		
	}
	
	

}

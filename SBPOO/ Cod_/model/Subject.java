package model;

import java.io.IOException;

public interface Subject {
	
	/*
	 * Registrar um Obj , Observer;
	 */
	public void registrarObserver(Observer o);
	
	/*
	 * Remover; 
	 */
	
	public void removerObserver(Observer o);
	/*
	 * Notificar()<-
	 */
	public void notificarObservers() throws IOException;
}

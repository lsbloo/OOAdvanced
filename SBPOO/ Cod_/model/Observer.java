package model;

import java.io.IOException;

public interface Observer {
	
	/*
	 * Atualiza Obj observer
	 */
	public void update(String nome_adm , String senha_adm) throws IOException;
	

}

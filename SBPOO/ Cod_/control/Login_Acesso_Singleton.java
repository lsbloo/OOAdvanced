package control;

import java.io.IOException;

public interface Login_Acesso_Singleton {
	
	/*
	 * LOG{ADM};
	 **/

	public void realizarAcesso(String login_adm, String senha_adm) throws IOException;


}

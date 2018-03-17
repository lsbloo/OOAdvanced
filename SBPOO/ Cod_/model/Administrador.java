package model;

public class Administrador {
	private String login;
	private String senha;
	private String nome_adm;
	
	public void setLogin(String login){
		this.login=login;
	}
	public String getLogin(){
		return login;
	}
	public void setSenha(String senha){
		this.senha=senha;
	}
	public String getSenha(){
		return senha;
	}
	public void setNome_adm(String nome_adm){
		this.nome_adm=nome_adm;
	}
	public String getNome_adm(){
		return nome_adm;
	}
	public Administrador(String login_adm , String senha_adm , String nome_adm){
		this.login=login_adm;
		this.senha=senha_adm;
		this.nome_adm=nome_adm;
	}
}

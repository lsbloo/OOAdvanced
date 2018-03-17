package model;

public class Pessoa {
	private String nome;
	private String cpf;
	private String rg;
	
	public void setNome(String nome){
		this.nome=nome;
	}
	public String getNome(){
		return nome;
	}

	public void setCpf(String cpf){
		this.cpf=cpf;
	}
	public String getCpf(){
		return cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	

}

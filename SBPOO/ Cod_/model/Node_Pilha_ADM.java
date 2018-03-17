package model;

public class Node_Pilha_ADM {
	
	private String adm;
	private Node_Pilha_ADM anterior;
	
	public void setAdm(String adm){
		this.adm = adm;
	}
	public String getAdm(){
		return adm;
	}
	public void setAnterior(Node_Pilha_ADM anterior){
		this.anterior=anterior;
	}
	public Node_Pilha_ADM getAnterior(){
		return anterior;
	}
	

}

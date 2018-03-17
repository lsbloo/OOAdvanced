package model;

public interface Pilha_adm_inter {
	
	/*
	 * Metodo Empilhar parametro adm {}:
	 * Objetivo: pegar nome+senha de log do adm e armazenar em uma pilha encadeada , já que eu nao sei quantos adm podem acessar
	 * o sistema;
	 */
	public void Empilhar(String adm);
	
	
	/*
	 * Remove da Pilha Log do adm {} 1x1 , whileD
	 */
	public void Desempilhar();
	
	
	
	
	/*
	 * verifica se a pilha ta vazia ou nao
	 */
	public void verifica_fast();

}

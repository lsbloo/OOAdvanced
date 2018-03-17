package model;

public interface Strategy {
	/*
	 * Aplicacao do padrao de projeto Strategy
	 * define uma familia de algoritmos , encapsula cada um deles
	 * e os torna intercambiaveis  Strategy deixa o algoritmo variar independete
	 * dos clientes que o utilizam;
	 * 
	 * Classes DAtas , implementao essa interface
	 * e usam esse unico algoritmo de armazenamento implementado na classe
	 * e a chamada é feita na classe janela do view ;
	 * 
	 * clases datas = concrectStrategy
	 * interface Strategy = Strategy
	 * Contexts = Classe janela chamando a acao
	 */
	public void armazenarIO();

}

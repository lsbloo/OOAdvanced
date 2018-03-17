package model;
import control.Data_Aluno;
import control.Data_Professor;
import control.Data_Livro;
public enum Enum_IO {
	/*
	 * Fabrica de Objetos do tipo Strategy ;
	 */

	
	
	Data_Aluno{
		@Override
		public Strategy obterIO() {
			// TODO Auto-generated method stub
			return new Data_Aluno();
		}
	},Data_Professor {
		@Override
		public Strategy obterIO() {
			// TODO Auto-generated method stub
			return new Data_Professor();
		}
	},Data_Livro {
		public Strategy obterIO() {
			// TODO Auto-generated method stub
			return new Data_Livro();
		}
	};
	
	
	/*
	 * Abstract metodo Strategy; , faz requisicao do tipo de OBj da fabrica
	 */
	public abstract Strategy obterIO();

}

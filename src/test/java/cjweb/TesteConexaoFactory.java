package cjweb;

import br.com.fabricadeprogramador.persistencia.jdbc.ConexaoFactory;

public class TesteConexaoFactory {

	public static void main(String[] args) {
	
		//Testando a classe Conexão
		ConexaoFactory.getConection();
		System.out.println("Conectou");

	}

}

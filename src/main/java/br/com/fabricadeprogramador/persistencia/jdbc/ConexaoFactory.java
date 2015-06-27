package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static Connection getConection() {
		try {
			return DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/postgres", "postgres", "tor");
		} catch (SQLException ex) {
			// Embrulhando a SQLException em uma RuntimeException para a classe
			// que chama a conexão não ficar dependete do JDBC
			throw new RuntimeException("Não conectou com o banco!", ex);

		}
	}
}

package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class ConexaoFactory {

	public static Connection getConection() {
		try {

			Class.forName("org.postgresql.Driver");

			return DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/postgres", "postgres",
					"tor");
		} catch (SQLException ex) {
			// Embrulhando a SQLException em uma RuntimeException para a classe
			// que chama a conexão não ficar dependete do JDBC
			throw new RuntimeException("Não conectou com o banco!", ex);

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Erro ao carregar a classe Driver",e);

		}
	}
}

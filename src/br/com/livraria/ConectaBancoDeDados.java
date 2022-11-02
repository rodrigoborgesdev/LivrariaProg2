
package br.com.livraria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBancoDeDados {
	
	// LOGIN E SENHA DO SEU MYSQL E A URL DA DATABASE
	private static final String USERNAME = "SEU LOGIN";
	private static final String PASSWORD = "SUA SENHA";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/livraria";
	
	public static Connection conexao() throws SQLException, ClassNotFoundException {
			Connection conectar = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			return conectar;
	}
	
}

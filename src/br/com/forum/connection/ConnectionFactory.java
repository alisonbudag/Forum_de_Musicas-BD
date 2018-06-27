package br.com.forum.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionFactory {
	
	//Constante para acessar o Banco de Dados
	private final String url = "jdbc:mysql://localhost:3306/forum_de_musicas";
	private final String user = "alison";
	private final String password = "ato123";
	
	//Método para retornar a conexão com o DB
	public Connection obterConexao(){
			
		//Variável para retornar conexão
		Connection conexao = null;
		
		//Realizar a conexão
		try{
			conexao = DriverManager.getConnection(url, user, password);
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Falha: "+e.getMessage());
			throw new RuntimeException(e);
		}
		
		//Retorno
		return conexao;
		
	}
	
}

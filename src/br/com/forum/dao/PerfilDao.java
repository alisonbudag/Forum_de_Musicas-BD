package br.com.forum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.com.forum.bean.PerfilBean;
import br.com.forum.connection.ConnectionFactory;

public class PerfilDao {
	
	//Atributo contendo a conexão
	private Connection conexao;
	
	//Construtor
	public PerfilDao(){
		
		//Instanciar um objeto da classe ConnectionFactory
		ConnectionFactory cf = new ConnectionFactory();
		conexao = cf.obterConexao();
		
	}
	
	//Método para puxar os dados de perfil para exibição
	public void puxarDados(int idUserLogado, PerfilBean obj){
		
		//SQL
		String sql = "SELECT nome, email, idade, cidade, estado, pais, isAdm, isMod FROM perfis WHERE perfis.idLogin=?";
				
		//Tenta realizar o comando
		try {
					
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, idUserLogado);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				obj.setNome(rs.getString("nome"));
				obj.setEmail(rs.getString("email"));
				obj.setIdade(rs.getInt("idade"));
				obj.setCidade(rs.getString("cidade"));
				obj.setEstado(rs.getString("estado"));
				obj.setPais(rs.getString("pais"));
				obj.setAdm(rs.getBoolean("isAdm"));
				obj.setMod(rs.getBoolean("isMod"));
			}
				
			pstmt.execute();
			pstmt.close();
					
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao alterar os dados.");
		}
		
	}

}

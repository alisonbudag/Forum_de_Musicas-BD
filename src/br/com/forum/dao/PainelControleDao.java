package br.com.forum.dao;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import br.com.forum.connection.ConnectionFactory;

public class PainelControleDao {

	// Atributo contendo a conexão
	private Connection conexao;

	// Construtor
	public PainelControleDao() {

		// Instanciar um objeto da classe ConnectionFactory
		ConnectionFactory cf = new ConnectionFactory();
		conexao = cf.obterConexao();

	}

	public DefaultTableModel listarMembros() {

		// DefaultTableModel
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Usuário");
		modelo.addColumn("Nível de Acesso");

		// SQL
		String sql = "SELECT user, isAdm, isMod, isBanned FROM logins, perfis WHERE perfis.idLogin=logins.idLogin";

		// Realizar a exclusão
		try {

			// Preparar
			Statement st = conexao.createStatement();

			ResultSet rs = st.executeQuery(sql);

			// Laço
			int indice = 0;
			while (rs.next()) {
				modelo.addRow(new Object[] {
						rs.getString("user")
					});
				
				if(rs.getBoolean("isBanned")) {
					modelo.setValueAt("Banido", indice, 1);
				}else if(rs.getBoolean("isAdm")){
					modelo.setValueAt("Administrador", indice, 1);
				}else if(rs.getBoolean("isMod")) {
					modelo.setValueAt("Moderador", indice, 1);
				}else {
					modelo.setValueAt("Membro", indice, 1);
				}
				
				indice++;
			}

			// Finalizar conexão com o banco de dados
			st.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao exibir tabela" + e.getMessage());
		}

		// Retorno
		return modelo;

	}
	
	//Método para banir/desbanir membro
	public void banirMembro(String usuarioSelecionado, boolean isBanned) {
		
		//SQL
		String sql = "UPDATE perfis INNER JOIN logins SET isBanned=? WHERE user=? AND isBanned=? AND logins.idLogin=perfis.idLogin";
		
		//Inverter o valor do isBanned para fazer a alteração
		boolean banido=false;
		
		if(isBanned) {
			banido=false;
		}else {
			banido=true;
		}
		
		//Executar
		try{
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setBoolean(1, banido);
            ps.setString(2, usuarioSelecionado);
            ps.setBoolean(3, isBanned);
            
            //Executar
            ps.executeUpdate();
            
            //Finalizar a conexão
            ps.close();
            
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Falha ao banir, erro: "+e.getMessage());
		}	
		
	}
	
	//Método para colocar/tirar moderador
	public void darMod(String usuarioSelecionado, boolean isMod) {
		
		//SQL
		String sql = "UPDATE perfis INNER JOIN logins SET isMod=? WHERE user=? AND isMod=? AND logins.idLogin=perfis.idLogin";
		
		//Inverter o valor do isMod para fazer a alteração
		boolean moderador=false;
		
		if(isMod) {
			moderador=false;
		}else {
			moderador=true;
		}
		
		//Executar
		try{
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setBoolean(1, moderador);
            ps.setString(2, usuarioSelecionado);
            ps.setBoolean(3, isMod);
            
            //Executar
            ps.executeUpdate();
            
            //Finalizar a conexão
            ps.close();
            
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Falha ao dar/tirar moderador, erro: "+e.getMessage());
		}	
		
	}

}

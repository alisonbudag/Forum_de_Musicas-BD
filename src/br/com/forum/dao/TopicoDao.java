package br.com.forum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import br.com.forum.bean.LoginBean;
import br.com.forum.bean.PerfilBean;
import br.com.forum.bean.TopicoBean;
import br.com.forum.connection.ConnectionFactory;

public class TopicoDao {

	// Atributo contendo a conexão
	private Connection conexao;

	// Construtor
	public TopicoDao() {

		// Instanciar um objeto da classe ConnectionFactory
		ConnectionFactory cf = new ConnectionFactory();
		conexao = cf.obterConexao();

	}

	// Método para puxar os dados de tópico para exibição
	public void puxarDadosTopico(String topicoSelecionado, String sessaoSelecionada, TopicoBean obj) {

		// SQL
		String sql = "SELECT tituloTopico, mensagemTopico FROM topicos, subsessoes WHERE tituloTopico=? AND nomeSubsessao=? AND topicos.idSubsessao=subsessoes.idSubsessao";

		// Tenta realizar o comando
		try {

			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, topicoSelecionado);
			pstmt.setString(2, sessaoSelecionada);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				obj.setTituloTopico(rs.getString("tituloTopico"));
				obj.setMensagemTopico(rs.getString("mensagemTopico"));
			}

			pstmt.execute();
			pstmt.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha.");
		}

	}

	// Método para exibir os tópicos na JList do Frame SessaoView
	public DefaultListModel<String> listarTopico(String sessaoSelecionada) {

		DefaultListModel<String> modelo = new DefaultListModel<>();

		// SQL
		String sql = "SELECT tituloTopico from topicos, subsessoes WHERE nomeSubsessao=? AND topicos.idSubsessao=subsessoes.idSubsessao";

		// Tenta realizar o comando
		try {

			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, sessaoSelecionada);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				modelo.addElement(rs.getString("tituloTopico"));
			}

			pstmt.execute();
			pstmt.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao mostrar dados do JList.");
		}

		return modelo;

	}

	// Método para puxar os dados de perfil do OP (Original Poster / Criador do tópíco) para exibição
	public void puxarDadosPerfilOP(String sessaoSelecionada, String topicoSelecionado, PerfilBean obj) {

		// SQL
		String sql = "SELECT nome, email, idade, cidade, estado, pais, isAdm, isMod FROM perfis, topicos, subsessoes WHERE tituloTopico=? AND nomeSubsessao=? AND perfis.idPerfil=topicos.idPerfil AND subsessoes.idSubsessao=topicos.idSubsessao";

		// Tenta realizar o comando
		try {

			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, topicoSelecionado);
			pstmt.setString(2, sessaoSelecionada);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
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

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao puxar os dados.");
		}

	}
	
	// Método para puxar o user do OP (Original Poster / Criador do tópíco) para exibição
	public String puxarUserOP(String sessaoSelecionada, String topicoSelecionado, LoginBean obj) {

		String user = "";
		
		// SQL
		String sql = "SELECT user FROM logins, topicos, subsessoes, perfis WHERE tituloTopico=? AND nomeSubsessao=? AND perfis.idPerfil=topicos.idPerfil AND subsessoes.idSubsessao=topicos.idSubsessao AND perfis.idLogin=logins.idLogin";

		// Tenta realizar o comando
		try {

			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, topicoSelecionado);
			pstmt.setString(2, sessaoSelecionada);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				user = rs.getString("user");
			}

			pstmt.execute();
			pstmt.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao puxar os dados.");
		}
		
		return user;

	}
	
	//Método para excluir o tópico
	public void excluirTopico(String sessaoSelecionada, String topicoSelecionado){
		
		//SQL
		String sql = "delete from topicos where idTopico = (SELECT * from (SELECT idTopico from subsessoes, topicos where nomeSubsessao=? AND tituloTopico=? AND topicos.idSubsessao=subsessoes.idSubsessao) as t)";
		
		//Realizar a exclusão
		try{
			
			//Preparar a exclusão
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, sessaoSelecionada);
			pstmt.setString(2, topicoSelecionado);
			
			//Executar o comando
			pstmt.execute();
			
			//Finalizar conexão com o banco de dados
			pstmt.close();
			
			//Mensagem
			JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
			
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Falha ao excluir"+e.getMessage());
		}
		
	}

}

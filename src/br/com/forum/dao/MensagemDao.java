package br.com.forum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.com.forum.bean.MensagemBean;
import br.com.forum.bean.PerfilBean;
import br.com.forum.connection.ConnectionFactory;

public class MensagemDao {

	// Atributo contendo a conex�o
	private Connection conexao;

	// Construtor
	public MensagemDao() {

		// Instanciar um objeto da classe ConnectionFactory
		ConnectionFactory cf = new ConnectionFactory();
		conexao = cf.obterConexao();

	}

	// M�todo para retornar o idTopico do t�pico selecionado
	public int idTopico(String sessaoSelecionada, String topicoSelecionado) {

		int idTopico = 0;

		// SQL
		String sql = "SELECT idTopico from subsessoes, topicos where nomeSubsessao=? AND tituloTopico=? AND topicos.idSubsessao=subsessoes.idSubsessao";

		// Realizar a exclus�o
		try {

			// Preparar a exclus�o
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, sessaoSelecionada);
			pstmt.setString(2, topicoSelecionado);

			// La�o
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				idTopico = rs.getInt("idTopico");
			}

			// Executar o comando
			pstmt.execute();

			// Finalizar conex�o com o banco de dados
			pstmt.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao excluir" + e.getMessage());
		}

		return idTopico;

	}

	// Cadastrar a mensagem no BD
	public void cadastrarMensagem(MensagemBean obj) {

		// SQL
		String sql = "INSERT INTO mensagens (corpoMensagem, idTopico, idPerfil) VALUES (?, ?, ?)";

		// Tentar realizar o cadastro
		try {

			// Preparar o envio dos par�metros
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, obj.getCorpoMensagem());
			pstmt.setInt(2, obj.getIdTopico());
			pstmt.setInt(3, obj.getIdPerfil());

			// Executar o comando
			pstmt.execute();

			// Finalizar a conex�o
			pstmt.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao cadastrar, erro: " + e.getMessage());
		}

	}
	
	//M�todo para validar o cadastro da mensagem no BD
	public boolean validarCadastroMensagem(int idUsuarioLogado, String sessaoSelecionada, String topicoSelecionado, String mensagem) {
		
		boolean valida = false;
		
		if(mensagem.equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos.", null, JOptionPane.ERROR_MESSAGE);
		}else {
			if(mensagem.length() > 1200) {
				JOptionPane.showMessageDialog(null, "A mensagem s� pode conter at� 1200 caracteres.", null, JOptionPane.ERROR_MESSAGE);
			}else {
				
				//Dar set nos dados da mensagem
				MensagemBean mb = new MensagemBean();
				mb.setCorpoMensagem(mensagem);
				mb.setIdTopico(idTopico(sessaoSelecionada, topicoSelecionado));
				mb.setIdPerfil(idUsuarioLogado);
				
				//Cadastrar mensagem
				cadastrarMensagem(mb);
				
				//Mensagem de sucesso
				JOptionPane.showMessageDialog(null, "Mensagem enviada com sucesso!");
				
				valida = true;
				
			}
			
		}
		
		return valida;
		
	}

}

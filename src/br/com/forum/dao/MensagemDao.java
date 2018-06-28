package br.com.forum.dao;

import java.awt.Color;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import br.com.forum.bean.MensagemBean;
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

			// Preparar
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

	// M�todo para validar o cadastro da mensagem no BD
	public boolean validarCadastroMensagem(int idUsuarioLogado, String sessaoSelecionada, String topicoSelecionado,
			String mensagem) {

		boolean valida = false;

		if (mensagem.equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos.", null, JOptionPane.ERROR_MESSAGE);
		} else {
			if (mensagem.length() > 1200) {
				JOptionPane.showMessageDialog(null, "A mensagem s� pode conter at� 1200 caracteres.", null,
						JOptionPane.ERROR_MESSAGE);
			} else {

				// Dar set nos dados da mensagem
				MensagemBean mb = new MensagemBean();
				mb.setCorpoMensagem(mensagem);
				mb.setIdTopico(idTopico(sessaoSelecionada, topicoSelecionado));
				mb.setIdPerfil(idUsuarioLogado);

				// Cadastrar mensagem
				cadastrarMensagem(mb);

				// Mensagem de sucesso
				JOptionPane.showMessageDialog(null, "Mensagem enviada com sucesso!");

				valida = true;

			}

		}

		return valida;

	}

	// M�todo para contar quantas mensagens existem no BD
	public int contarMensagens() {

		int contarMensagens = 0;

		// SQL
		String sql = "SELECT COUNT(*) FROM mensagens";

		// Realizar a exclus�o
		try {

			// Preparar a exclus�o
			Statement st = conexao.createStatement();

			// La�o
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				contarMensagens = rs.getInt("COUNT(*)");
			}

			// Finalizar conex�o com o banco de dados
			st.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao excluir" + e.getMessage());
		}

		return contarMensagens;

	}

	// M�todo para excluir as mensagens do t�pico
	public void excluirMensagens(String sessaoSelecionada, String topicoSelecionado) {

		// SQL
		String sql = "DELETE FROM mensagens WHERE idTopico = (SELECT * FROM (SELECT idTopico from subsessoes, topicos where nomeSubsessao=? AND tituloTopico=? AND topicos.idSubsessao=subsessoes.idSubsessao) as t)";

		// Realizar a exclus�o
		try {

			// Preparar a exclus�o
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, sessaoSelecionada);
			pstmt.setString(2, topicoSelecionado);

			// Executar o comando
			pstmt.execute();

			// Finalizar conex�o com o banco de dados
			pstmt.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao excluir mensagens" + e.getMessage());
		}
	}

	// M�todo de estrutura do JPanel das mensagens
	public JScrollPane estrutura(String sessaoSelecionada, String topicoSelecionado) {

		// Contando elementos
		int contarElementos = contarMensagens();

		// Objeto JPanel
		JPanel jp = new JPanel();
		jp.setBackground(Color.GRAY);
		if (contarElementos > 0) {
			jp.setLayout(new GridLayout(contarElementos, 0, 5, 5));
		} else {
			jp.setLayout(new GridLayout(contarElementos + 1, 0, 5, 5));
		}
		jp.setBorder(new LineBorder(new Color(0, 0, 0)));

		int espacamento = 20;

		// SQL
		String sql = "SELECT corpoMensagem FROM mensagens WHERE idTopico=?";

		// Realizar a exclus�o
		try {

			// Preparar a
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, idTopico(sessaoSelecionada, topicoSelecionado));

			ResultSet rs = pstmt.executeQuery();

			// La�o
			while (rs.next()) {
				JTextArea txtNovaResposta = new JTextArea();
				txtNovaResposta.setEditable(false);
				txtNovaResposta.setBackground(Color.LIGHT_GRAY);
				txtNovaResposta.setText(rs.getString("corpoMensagem"));
				JScrollPane barraNovaResposta = new JScrollPane(txtNovaResposta);
				barraNovaResposta.setBounds(10, espacamento, 100, 100);
				espacamento += 20;

				jp.add(barraNovaResposta);
			}

			// Executar o comando
			pstmt.execute();

			// Finalizar conex�o com o banco de dados
			pstmt.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao exibir mensagens" + e.getMessage());
		}

		// JScrollPane
		JScrollPane barra = new JScrollPane(jp);
		barra.setBounds(10, 229, 480, 124);

		// Retorno
		return barra;
	}

}

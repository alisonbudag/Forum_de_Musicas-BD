package br.com.forum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.com.forum.bean.TopicoBean;
import br.com.forum.connection.ConnectionFactory;

public class NovoTopicoDao {

	// Atributo contendo a conex�o
	private Connection conexao;

	// Construtor
	public NovoTopicoDao() {

		// Instanciar um objeto da classe ConnectionFactory
		ConnectionFactory cf = new ConnectionFactory();
		conexao = cf.obterConexao();

	}

	// M�todo para verificar se j� existe um t�pico com o mesmo nome na sess�o
	// selecionada
	public boolean tituloExistente(String titulo, String sessaoSelecionada) {

		boolean existe = false;

		// SQL
		String sql = "SELECT tituloTopico FROM topicos, subsessoes WHERE tituloTopico=? AND nomeSubsessao=? AND topicos.idSubsessao = subsessoes.idSubsessao";

		// Executar
		try {

			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, titulo);
			ps.setString(2, sessaoSelecionada);
			ResultSet rs = ps.executeQuery();

			// La�o
			if (rs.next()) {
				// Se r.next() for verdade existe um t�pico com este nome nesta sess�o
				existe = true;
			}

			// Finalizar a conex�o
			ps.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha, erro: " + e.getMessage());
		}

		return existe;

	}

	// M�todo para cadastrar o t�pico no BD
	public void cadastrarTopico(TopicoBean obj, int idUsuarioLogado) {

		// SQL
		String sql = "INSERT INTO topicos (tituloTopico, mensagemTopico, idSubsessao, idPerfil) VALUES (?, ?, ?, ?)";

		// Tentar realizar o cadastro
		try {

			// Preparar o envio dos par�metros
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, obj.getTituloTopico());
			ps.setString(2, obj.getMensagemTopico());
			ps.setInt(3, obj.getIdSubsessao());
			ps.setInt(4, obj.getIdPerfil());

			// Executar o comando
			ps.execute();

			// Finalizar a conex�o
			ps.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao cadastrar, erro: " + e.getMessage());
		}

	}

	// M�todo para retornar o idSubsessao para criar o t�pico
	public int idSubsessao(String sessaoSelecionada) {

		int idSubsessao = 0;

		// SQL
		String sql = "SELECT idSubsessao FROM subsessoes WHERE nomeSubsessao=?";

		// Executar
		try {
			// Comando para realizar a conex�o e executar o comando SQL
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, sessaoSelecionada);
			ResultSet rs = ps.executeQuery();

			// La�o
			if (rs.next()) {
				idSubsessao = rs.getInt("idSubsessao");
			}

			// Finalizar conex�o
			ps.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao executar a sele��o.");
		}

		return idSubsessao;
	}

	// M�todo para criar e validar o t�pico
	public boolean criarTopico(String titulo, String mensagem, int idUsuarioLogado, String sessaoSelecionada) {

		boolean valida = false;

		if (titulo.equals("") || mensagem.equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos.", null, JOptionPane.ERROR_MESSAGE);
		} else {

			// Verificar se j� existe um t�pico de mesmo nome na mesma sess�o
			if (tituloExistente(titulo, sessaoSelecionada) == true) {
				JOptionPane.showMessageDialog(null, "J� existe um t�pico com este nome nesta sess�o.", null,
						JOptionPane.ERROR_MESSAGE);
			} else {

				// Verificar se os campos n�o ultrapassam os limites de chars
				if ((titulo.length() < 41) && (mensagem.length() < 1201)) {

					// Dar set nos dados do topico
					TopicoBean tb = new TopicoBean();
					tb.setTituloTopico(titulo);
					tb.setMensagemTopico(mensagem);
					tb.setIdPerfil(idUsuarioLogado);
					tb.setIdSubsessao(idSubsessao(sessaoSelecionada));

					// Cadastrar t�pico
					cadastrarTopico(tb, idUsuarioLogado);

					// Retornar mensagem de sucesso
					JOptionPane.showMessageDialog(null, "T�pico criado com sucesso!");

					valida = true;

				} else {
					JOptionPane.showMessageDialog(null,
							"O t�tulo s� pode ter 40 caracteres.\nA mensagem s� pode ter 1200 caracteres.", null,
							JOptionPane.ERROR_MESSAGE);
				}

			}

		}

		return valida;

	}

}

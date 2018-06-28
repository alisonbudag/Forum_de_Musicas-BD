package br.com.forum.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.forum.bean.LoginBean;
import br.com.forum.bean.PerfilBean;
import br.com.forum.bean.TopicoBean;
import br.com.forum.dao.LoginDao;
import br.com.forum.dao.PerfilDao;
import br.com.forum.dao.TopicoDao;

public class TopicoView extends JFrame {

	private JPanel contentPane;
	private JTextField txtTeste;

	public TopicoView(int idUsuarioLogado, String sessaoSelecionada, String topicoSelecionado) {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHome.setBounds(50, 11, 43, 25);
		contentPane.add(lblHome);
		
		lblHome.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				HomeView hv = new HomeView(idUsuarioLogado);
				
				dispose();
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JLabel lblPerfil = new JLabel("Perfil");
		lblPerfil.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPerfil.setBounds(175, 11, 43, 25);
		contentPane.add(lblPerfil);
		lblPerfil.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				PerfilView pv = new PerfilView(idUsuarioLogado);
				
				dispose();
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JLabel lblLogout = new JLabel("Logout");
		lblLogout.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLogout.setBounds(300, 11, 139, 25);
		contentPane.add(lblLogout);
		lblLogout.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				LoginView lv = new LoginView();
				
				dispose();
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JLabel lblSair = new JLabel("Sair");
		lblSair.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSair.setBounds(425, 11, 43, 25);
		contentPane.add(lblSair);
		
		lblSair.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				dispose();
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//Puxando dados do topico
		TopicoDao td = new TopicoDao();
		TopicoBean tb = new TopicoBean();
		td.puxarDadosTopico(topicoSelecionado, sessaoSelecionada, tb);
		
		//Puxar dados de perfil do criador do topico
		PerfilBean pb = new PerfilBean();
		td.puxarDadosPerfilOP(sessaoSelecionada, topicoSelecionado, pb);
		
		//Puxar usuário do criador do topico
		LoginBean lb = new LoginBean();
		String op = td.puxarUserOP(sessaoSelecionada, topicoSelecionado, lb);
		
		//Pegar o tipo de usuário do criador do topico (ADM, MOD ou Membro)
		String tipoDeUsuario = "";
		
		if(pb.isAdm()) {
			tipoDeUsuario = "Administrador";
		}else if(pb.isMod()) {
			tipoDeUsuario = "Moderador";
		}else {
			tipoDeUsuario = "Membro";
		}
		
		JLabel lblSessao = new JLabel(sessaoSelecionada+" - "+tb.getTituloTopico());
		lblSessao.setBackground(Color.LIGHT_GRAY);
		lblSessao.setOpaque(true);
		lblSessao.setHorizontalAlignment(SwingConstants.CENTER);
		lblSessao.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSessao.setBounds(10, 47, 480, 27);
		contentPane.add(lblSessao);
		
		JButton btnResponder = new JButton("Responder");
		btnResponder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResponderTopicoView rtv = new ResponderTopicoView(idUsuarioLogado, sessaoSelecionada, topicoSelecionado);
				dispose();
			}
		});
		btnResponder.setBounds(384, 366, 106, 23);
		contentPane.add(btnResponder);
		
		JLabel lblCriadorTopico = new JLabel("Criado por: "+op+" ("+tipoDeUsuario+")");
		lblCriadorTopico.setBackground(Color.LIGHT_GRAY);
		lblCriadorTopico.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCriadorTopico.setHorizontalAlignment(SwingConstants.LEFT);
		lblCriadorTopico.setBounds(10, 85, 350, 25);
		contentPane.add(lblCriadorTopico);
		
		JTextArea txtrMsgtopico = new JTextArea();
		txtrMsgtopico.setLineWrap(true);
		txtrMsgtopico.setBackground(Color.LIGHT_GRAY);
		txtrMsgtopico.setEditable(false);
		txtrMsgtopico.setText(tb.getMensagemTopico());
		JScrollPane barraMsgTopico = new JScrollPane(txtrMsgtopico);
		barraMsgTopico.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		barraMsgTopico.setBounds(10, 116, 480, 85);
		contentPane.add(barraMsgTopico);
		
		//Chamar JPanel
		/*JPanelMensagem a = new JPanelMensagem();
		contentPane.add(a.estrutura(index, topicoSelecionado));*/
		
		//Botão para voltar
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SessaoView sv = new SessaoView(idUsuarioLogado, sessaoSelecionada);
				dispose();
			}
		});
		btnVoltar.setBounds(10, 366, 106, 23);
		contentPane.add(btnVoltar);
		
		//Reestruturando o objeto PerfilBean para os dados do usuário logado. Deste modo, só o dono do tópico ou o admin poderá excluí-lo
		PerfilDao pd = new PerfilDao();
		pd.puxarDados(idUsuarioLogado, pb);
		
		//Botão para excluir o tópico
		JButton btnExcluirTopico = new JButton("Excluir tópico");
		btnExcluirTopico.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnExcluirTopico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int confirm = JOptionPane.showConfirmDialog(null, "Você tem certeza?", "Excluir tópico", 0);
				if(confirm == 0) {
					TopicoDao td = new TopicoDao();
					td.excluirTopico(sessaoSelecionada, topicoSelecionado);
					//a.excluirRespostasTopico(index, topicoSelecionado);
					SessaoView sv = new SessaoView(idUsuarioLogado, sessaoSelecionada);
					dispose();
				}
				
			}
		});
		btnExcluirTopico.setBounds(370, 85, 120, 23);
		if(pb.isAdm() || pb.isMod() || pb.getNome().equals(op)) {
			btnExcluirTopico.setVisible(true);
		}else {
			btnExcluirTopico.setVisible(false);
		}
		contentPane.add(btnExcluirTopico);
		
		JLabel lblRespostas = new JLabel("Respostas:");
		lblRespostas.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRespostas.setHorizontalAlignment(SwingConstants.LEFT);
		lblRespostas.setBounds(10, 205, 480, 14);
		contentPane.add(lblRespostas);
		
		setVisible(true);
	}
}

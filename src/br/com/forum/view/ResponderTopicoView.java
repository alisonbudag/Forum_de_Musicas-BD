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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ResponderTopicoView extends JFrame {

	private JPanel contentPane;

	public ResponderTopicoView(int idUsuarioLogado, String sessaoSelecionada, String topicoSelecionado) {
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
		
		JLabel lblSessao = new JLabel("Responder tópico: "+topicoSelecionado);
		lblSessao.setBackground(Color.LIGHT_GRAY);
		lblSessao.setOpaque(true);
		lblSessao.setHorizontalAlignment(SwingConstants.CENTER);
		lblSessao.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSessao.setBounds(10, 64, 480, 27);
		contentPane.add(lblSessao);
		
		JLabel lblMensagem = new JLabel("Mensagem");
		lblMensagem.setHorizontalAlignment(SwingConstants.LEFT);
		lblMensagem.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMensagem.setBounds(10, 102, 480, 25);
		contentPane.add(lblMensagem);
		
		JTextArea txtMensagem = new JTextArea();
		txtMensagem.setLineWrap(true);
		JScrollPane barraResponder = new JScrollPane(txtMensagem);
		barraResponder.setBounds(10, 138, 480, 221);
		contentPane.add(barraResponder);
		
		JButton btnEnviar = new JButton("Enviar");
		/*btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mensagem = txtMensagem.getText();
				codigo.Topico a = new codigo.Topico();
				a.validaResponderTopico(mensagem, index, topicoSelecionado);
				
				Topico b = new Topico(index, topicoSelecionado);
				dispose();
			}
		});*/
		btnEnviar.setBounds(401, 366, 89, 23);
		contentPane.add(btnEnviar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TopicoView tv = new TopicoView(idUsuarioLogado, sessaoSelecionada, topicoSelecionado);
				dispose();
			}
		});
		btnVoltar.setBounds(10, 366, 89, 23);
		contentPane.add(btnVoltar);
		
		setVisible(true);
	}
}

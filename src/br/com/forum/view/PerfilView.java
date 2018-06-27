package br.com.forum.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PerfilView extends JFrame {

	private JPanel contentPane;

	public PerfilView() {
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
				
				HomeView hv = new HomeView();
				
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
				
				PerfilView pv = new PerfilView();
				
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
		
		JLabel lblSessao = new JLabel("PERFIL");
		lblSessao.setBackground(Color.LIGHT_GRAY);
		lblSessao.setOpaque(true);
		lblSessao.setHorizontalAlignment(SwingConstants.CENTER);
		lblSessao.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSessao.setBounds(10, 64, 480, 27);
		contentPane.add(lblSessao);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setOpaque(true);
		lblNome.setBackground(Color.LIGHT_GRAY);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBounds(10, 102, 84, 35);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBackground(Color.LIGHT_GRAY);
		lblIdade.setOpaque(true);
		lblIdade.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdade.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIdade.setBounds(10, 148, 84, 35);
		contentPane.add(lblIdade);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBackground(Color.LIGHT_GRAY);
		lblEmail.setOpaque(true);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBounds(10, 194, 84, 35);
		contentPane.add(lblEmail);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBackground(Color.LIGHT_GRAY);
		lblCidade.setOpaque(true);
		lblCidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCidade.setBounds(10, 240, 84, 35);
		contentPane.add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBackground(Color.LIGHT_GRAY);
		lblEstado.setOpaque(true);
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEstado.setBounds(10, 286, 84, 35);
		contentPane.add(lblEstado);
		
		JLabel lblPais = new JLabel("Pa\u00EDs");
		lblPais.setBackground(Color.LIGHT_GRAY);
		lblPais.setOpaque(true);
		lblPais.setHorizontalAlignment(SwingConstants.CENTER);
		lblPais.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPais.setBounds(10, 332, 84, 35);
		contentPane.add(lblPais);
		
		//Puxar Dados Perfil
		String nome = "";
		int idade = 0;
		String email = "";
		String cidade = "";
		String estado = "";
		String pais = "";
		
		JLabel seuNome = new JLabel(nome);
		seuNome.setBackground(Color.LIGHT_GRAY);
		seuNome.setOpaque(true);
		seuNome.setHorizontalAlignment(SwingConstants.CENTER);
		seuNome.setFont(new Font("Tahoma", Font.BOLD, 16));
		seuNome.setBounds(104, 102, 239, 35);
		contentPane.add(seuNome);
		
		JLabel suaIdade = new JLabel(String.valueOf(idade));
		suaIdade.setBackground(Color.LIGHT_GRAY);
		suaIdade.setOpaque(true);
		suaIdade.setHorizontalAlignment(SwingConstants.CENTER);
		suaIdade.setFont(new Font("Tahoma", Font.BOLD, 16));
		suaIdade.setBounds(104, 148, 239, 35);
		contentPane.add(suaIdade);
		
		JLabel seuEmail = new JLabel(email);
		seuEmail.setBackground(Color.LIGHT_GRAY);
		seuEmail.setOpaque(true);
		seuEmail.setHorizontalAlignment(SwingConstants.CENTER);
		seuEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		seuEmail.setBounds(104, 194, 239, 35);
		contentPane.add(seuEmail);
		
		JLabel suaCidade = new JLabel(cidade);
		suaCidade.setBackground(Color.LIGHT_GRAY);
		suaCidade.setOpaque(true);
		suaCidade.setHorizontalAlignment(SwingConstants.CENTER);
		suaCidade.setFont(new Font("Tahoma", Font.BOLD, 16));
		suaCidade.setBounds(104, 240, 239, 35);
		contentPane.add(suaCidade);
		
		JLabel seuEstado = new JLabel(estado);
		seuEstado.setBackground(Color.LIGHT_GRAY);
		seuEstado.setOpaque(true);
		seuEstado.setHorizontalAlignment(SwingConstants.CENTER);
		seuEstado.setFont(new Font("Tahoma", Font.BOLD, 16));
		seuEstado.setBounds(104, 286, 239, 35);
		contentPane.add(seuEstado);
		
		JLabel seuPais = new JLabel(pais);
		seuPais.setBackground(Color.LIGHT_GRAY);
		seuPais.setOpaque(true);
		seuPais.setHorizontalAlignment(SwingConstants.CENTER);
		seuPais.setFont(new Font("Tahoma", Font.BOLD, 16));
		seuPais.setBounds(104, 332, 239, 35);
		contentPane.add(seuPais);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/semFoto.jpg")));
		lblNewLabel.setBounds(355, 102, 135, 127);
		contentPane.add(lblNewLabel);
		
		JButton btnAtualizarFoto = new JButton("Atualizar foto");
		btnAtualizarFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Disponível na próxima versão.");
			}
		});
		btnAtualizarFoto.setBounds(353, 240, 137, 25);
		contentPane.add(btnAtualizarFoto);
		
		setVisible(true);
	}
}

package br.com.forum.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.forum.dao.CadastroDao;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class CadastroView extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtUsuario;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtPais;
	private JTextField txtEmail;
	private JPasswordField txtRepetirSenha;
	private JPasswordField txtSenha;

	public CadastroView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 276, 427);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setTitle("Cadastrar");

		//Labels e TextFields/PasswordFields
		JLabel lblNovoUsuario = new JLabel("NOVO USU\u00C1RIO");
		lblNovoUsuario.setBackground(Color.LIGHT_GRAY);
		lblNovoUsuario.setOpaque(true);
		lblNovoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovoUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNovoUsuario.setBounds(10, 11, 235, 22);
		contentPane.add(lblNovoUsuario);

		//Nome
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBackground(Color.LIGHT_GRAY);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setOpaque(true);
		lblNome.setBounds(10, 44, 97, 20);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(117, 44, 128, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		//Usuário
		JLabel lblUsuario = new JLabel("Usu\u00E1rio");
		lblUsuario.setOpaque(true);
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsuario.setBackground(Color.LIGHT_GRAY);
		lblUsuario.setBounds(10, 75, 97, 20);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(117, 75, 128, 20);
		contentPane.add(txtUsuario);
		
		//Senha
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setOpaque(true);
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSenha.setBackground(Color.LIGHT_GRAY);
		lblSenha.setBounds(10, 106, 97, 20);
		contentPane.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(117, 106, 128, 20);
		contentPane.add(txtSenha);
		
		//Repetir Senha
		JLabel lblRepetirSenha = new JLabel("Repetir Senha");
		lblRepetirSenha.setOpaque(true);
		lblRepetirSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblRepetirSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRepetirSenha.setBackground(Color.LIGHT_GRAY);
		lblRepetirSenha.setBounds(10, 137, 97, 20);
		contentPane.add(lblRepetirSenha);
		
		txtRepetirSenha = new JPasswordField();
		txtRepetirSenha.setBounds(117, 138, 128, 20);
		contentPane.add(txtRepetirSenha);
		
		//Email
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setOpaque(true);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBackground(Color.LIGHT_GRAY);
		lblEmail.setBounds(10, 168, 97, 20);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(117, 168, 128, 20);
		contentPane.add(txtEmail);
		
		//Idade
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setOpaque(true);
		lblIdade.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIdade.setBackground(Color.LIGHT_GRAY);
		lblIdade.setBounds(10, 199, 97, 20);
		contentPane.add(lblIdade);
		
		JComboBox<Integer> comboIdade = new JComboBox<Integer>();
		comboIdade.setBounds(117, 200, 128, 20);
		contentPane.add(comboIdade);
		for (int i = 12; i < 100; i++) {
			comboIdade.addItem(i);
		}
		
		//País
		JLabel lblPais = new JLabel("Pa\u00EDs");
		lblPais.setOpaque(true);
		lblPais.setHorizontalAlignment(SwingConstants.CENTER);
		lblPais.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPais.setBackground(Color.LIGHT_GRAY);
		lblPais.setBounds(10, 230, 97, 20);
		contentPane.add(lblPais);
		
		txtPais = new JTextField();
		txtPais.setColumns(10);
		txtPais.setBounds(117, 230, 128, 20);
		contentPane.add(txtPais);
		
		//Estado
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setOpaque(true);
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstado.setBackground(Color.LIGHT_GRAY);
		lblEstado.setBounds(10, 261, 97, 20);
		contentPane.add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(117, 261, 128, 20);
		contentPane.add(txtEstado);
		
		//Cidade
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setOpaque(true);
		lblCidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCidade.setBackground(Color.LIGHT_GRAY);
		lblCidade.setBounds(10, 292, 97, 20);
		contentPane.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(117, 292, 128, 20);
		contentPane.add(txtCidade);
		
		//Botão Cadastrar
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCadastrar.setBounds(10, 323, 235, 23);
		contentPane.add(btnCadastrar);
		
		//Ação botão Cadastrar
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				String usuario = txtUsuario.getText();
				String senha = String.valueOf(txtSenha.getPassword());
				String repSenha = String.valueOf(txtRepetirSenha.getPassword());
				String email = txtEmail.getText();
				int idade = (int) comboIdade.getSelectedItem();
				String estado = txtEstado.getText();
				String cidade = txtCidade.getText();
				String pais = txtPais.getText();
				
				CadastroDao cd = new CadastroDao();
				
				if(cd.validarCadastro(nome, usuario, senha, repSenha, email, idade, pais, estado, cidade) == true) {
					
					LoginView lv = new LoginView();
					dispose();

				}
				
				
			}
		});
		
		//Botão cancelar
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBounds(10, 354, 235, 23);
		contentPane.add(btnCancelar);
		
		//Ação botão cancelar
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginView lv = new LoginView();
				dispose();
			}
		});

		setVisible(true);
	}
}

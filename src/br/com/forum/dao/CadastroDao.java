package br.com.forum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.com.forum.bean.LoginBean;
import br.com.forum.bean.PerfilBean;
import br.com.forum.connection.ConnectionFactory;

public class CadastroDao {
	
	//Atributo contendo a conexão
	private Connection conexao;
	
	//Construtor
	public CadastroDao(){
		
		//Instanciar um objeto da classe ConnectionFactory
		ConnectionFactory cf = new ConnectionFactory();
		conexao = cf.obterConexao();
		
	}

	//Cadastrar dados na tabela perfis
	public void cadastrarPerfil(PerfilBean obj) {
		
		//SQL
		String sql = "INSERT INTO perfis (nome, email, idade, cidade, estado, pais, isAdm, isMod, isBanned, idLogin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
		//Tentar realizar o cadastro
		try{
					
			//Preparar o envio dos parâmetros
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, obj.getNome());
			pstmt.setString(2, obj.getEmail());
			pstmt.setInt(3, obj.getIdade());
			pstmt.setString(4, obj.getCidade());
			pstmt.setString(5, obj.getEstado());
			pstmt.setString(6, obj.getPais());
			pstmt.setBoolean(7, obj.isAdm());
			pstmt.setBoolean(8, obj.isMod());
			pstmt.setBoolean(9, obj.isBanned());
			pstmt.setInt(10, obj.getIdLogin());
					
			//Executar o comando
			pstmt.execute();
			
			//Finalizar a conexão
			pstmt.close();
				
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Falha ao cadastrar, erro: "+e.getMessage());
		}
		
	}
	
	//Cadastrar dados na tabela logins
	public void cadastrarLogin(LoginBean obj) {
		
		//SQL
		String sql = "INSERT INTO logins (user, password) VALUES (?, ?)";
				
		//Tentar realizar o cadastro
		try{
					
			//Preparar o envio dos parâmetros
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, obj.getUser());
			pstmt.setString(2, obj.getPassword());
					
			//Executar o comando
			pstmt.execute();
			
			//Finalizar a conexão
			pstmt.close();
				
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Falha ao cadastrar, erro: "+e.getMessage());
		}
		
	}
	
	//Retornar o idLogin para cadastrar o perfil
	public Integer idLogin() {
		
		int idLogin = 0;
		
		//SQL
		String sql = "SELECT * FROM logins order by idLogin desc limit 1";
				
		//Executar
		try{
			//Comando para realizar a conexão e executar o comando SQL
			Statement stmt = conexao.createStatement();
					
			//Obter todos os dados da tabela
			ResultSet rs = stmt.executeQuery(sql);
					
			//Laço
			if(rs.next()){
				idLogin = rs.getInt("idLogin");
			}
			
			//Finalizar conexão
			stmt.close();
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Falha ao executar a seleção.");
		}
		
		return idLogin;
	}
	
	//Verificar se já existe o nome de usuário
	public boolean verificarUsuario(String usuario) {
		
		boolean valida = true;
		
		//SQL
		String sql = "SELECT * FROM logins";
						
		//Executar
		try{
			//Comando para realizar a conexão e executar o comando SQL
			Statement stmt = conexao.createStatement();
							
			//Obter todos os dados da tabela
			ResultSet rs = stmt.executeQuery(sql);
							
			//Laço
			while(rs.next()){
				if(usuario.equals(rs.getString("user"))) {
					valida = false;
					break;
				}
			}
					
			//Finalizar conexão
			stmt.close();
					
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Falha ao executar a seleção.");
		}
		
		return valida;
		
	}
	
	//Validar Cadastro
	public boolean validarCadastro(String nome, String usuario, String senha, String repSenha, String email, int idade, String pais, String estado, String cidade) {
		
		boolean valida = false;
		
		//Verificar se todos os campos estão preenchidos
		if(nome.equals("") || usuario.equals("") || senha.equals("") || repSenha.equals("") || email.equals("") || pais.equals("") || estado.equals("") || cidade.equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos.", null, JOptionPane.ERROR_MESSAGE);
		}else {
			
			//Verificar se as senhas combinam
			if(senha.equals(repSenha)) {
				
				//Verificar se usuário já existe
				if(verificarUsuario(usuario) == true) {
					
					//Verificar o tamanho do usuário e da senha
					if((usuario.length() < 3) || (usuario.length() > 12) || (senha.length() < 3) || (senha.length() > 20)) {
						JOptionPane.showMessageDialog(null, "O usuário precisa ter entre 3 e 12 carácteres.\nA senha precisa ter entre 3 e 20 carácteres.", null, JOptionPane.ERROR_MESSAGE);
					}else {
						
						//Dar set nos dados do Login
						LoginBean lb = new LoginBean();
						lb.setUser(usuario);
						lb.setPassword(senha);
						
						//Dar set nos dados do perfil
						PerfilBean pb = new PerfilBean();
						pb.setNome(nome);
						pb.setEmail(email);
						pb.setIdade(idade);
						pb.setPais(pais);
						pb.setEstado(estado);
						pb.setCidade(cidade);
						pb.setAdm(false);
						pb.setMod(false);
						pb.setBanned(false);
						pb.setIdLogin(idLogin());
						
						//Cadastrar
						cadastrarLogin(lb);
						cadastrarPerfil(pb);
						
						//Dar boas vindas
						JOptionPane.showMessageDialog(null, "Bem vindo ao Darkest Side of the Music, " + nome + "!");
						
						valida = true;
											
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Este nome de usuário já existe.", null, JOptionPane.ERROR_MESSAGE);
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "Falha na validação da senha.", null, JOptionPane.ERROR_MESSAGE);
			}
		}
		
		return valida;
		
	}
	
}

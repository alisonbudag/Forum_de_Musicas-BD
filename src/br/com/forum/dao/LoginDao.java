package br.com.forum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.com.forum.connection.ConnectionFactory;


public class LoginDao {
	
	//Atributo contendo a conex�o
	private Connection conexao;
	
	//Construtor
	public LoginDao(){
		
		//Instanciar um objeto da classe ConnectionFactory
		ConnectionFactory cf = new ConnectionFactory();
		conexao = cf.obterConexao();
		
	}
	
	//Validar acesso ao sistema
	public boolean efetuarLogin(String login, String senha) {
		
		boolean validar = false;
		
		if(login.equals("") || senha.equals("")) {
			JOptionPane.showMessageDialog(null, "Login e/ou senha inv�lidos.", null, JOptionPane.ERROR_MESSAGE);
		}else {
			
			//SQL
			String sql = "SELECT idLogin, user, password from logins WHERE user=? AND password=?";
			
			//Executar
			try{
				
				PreparedStatement ps = conexao.prepareStatement(sql);
	            ps.setString(1, login);
	            ps.setString(2, senha);
	            ResultSet rs = ps.executeQuery();
	            
	            //La�o
	            if (rs.next()) {
	            	 // Se r.next() for verdade existe uma combina��o login/senha 
	            	validar = true;
	            	
	            } else {
	            	JOptionPane.showMessageDialog(null, "Login e/ou senha inv�lidos.", null, JOptionPane.ERROR_MESSAGE);
	            }
	            
	            //Finalizar a conex�o
	            ps.close();
	            
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Falha ao cadastrar, erro: "+e.getMessage());
			}	
			
		}
		
		return validar;
		
	}

	//Verificar se o usu�rio est� banido
	public boolean isBanned(String login) {
		
		boolean isBanned = false;
		
		//SQL
		String sql = "SELECT perfis.nome from perfis, logins WHERE user=? AND perfis.idLogin = logins.idLogin AND isBanned=1";
		
		//Executar
		try{
			
		PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, login);
        ResultSet rs = ps.executeQuery();
            
        //La�o
        if (rs.next()) {
        	// Se r.next() for verdade a conta est� banida
           	isBanned = true;
           	JOptionPane.showMessageDialog(null, "Esta conta est� banida.", null, JOptionPane.ERROR_MESSAGE);	
        }
            
        //Finalizar a conex�o
        ps.close();
            
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Falha ao cadastrar, erro: "+e.getMessage());
		}	
		
		return isBanned;
		
	}
	
}

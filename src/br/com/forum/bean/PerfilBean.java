package br.com.forum.bean;

public class PerfilBean {
	
	//Atributos
	private int idPerfil, idade, idLogin;
	private String nome, email, cidade, estado, pais;
	private boolean isAdm, isMod, isBanned;
	
	//Getters and Setters
	public int getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public int getIdLogin() {
		return idLogin;
	}
	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public boolean isAdm() {
		return isAdm;
	}
	public void setAdm(boolean isAdm) {
		this.isAdm = isAdm;
	}
	public boolean isMod() {
		return isMod;
	}
	public void setMod(boolean isMod) {
		this.isMod = isMod;
	}
	public boolean isBanned() {
		return isBanned;
	}
	public void setBanned(boolean isBanned) {
		this.isBanned = isBanned;
	}
	
}

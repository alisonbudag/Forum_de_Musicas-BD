package br.com.forum.bean;

public class MensagemBean {
	
	//Atributos
	private int idMensagem, idTopico, idPerfil;
	private String corpoMensagem;
	
	//Getters and Setters
	public int getIdMensagem() {
		return idMensagem;
	}
	public void setIdMensagem(int idMensagem) {
		this.idMensagem = idMensagem;
	}
	public int getIdTopico() {
		return idTopico;
	}
	public void setIdTopico(int idTopico) {
		this.idTopico = idTopico;
	}
	public int getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}
	public String getCorpoMensagem() {
		return corpoMensagem;
	}
	public void setCorpoMensagem(String corpoMensagem) {
		this.corpoMensagem = corpoMensagem;
	}	

}

package br.com.forum.bean;

public class TopicoBean {
	
	//Atributos
	private int idTopico, idSubsessao, idPerfil;
	private String tituloTopico, mensagemTopico;
	
	//Getters and Setters
	public int getIdTopico() {
		return idTopico;
	}
	public void setIdTopico(int idTopico) {
		this.idTopico = idTopico;
	}
	public int getIdSubsessao() {
		return idSubsessao;
	}
	public void setIdSubsessao(int idSubsessao) {
		this.idSubsessao = idSubsessao;
	}
	public int getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}
	public String getTituloTopico() {
		return tituloTopico;
	}
	public void setTituloTopico(String tituloTopico) {
		this.tituloTopico = tituloTopico;
	}
	public String getMensagemTopico() {
		return mensagemTopico;
	}
	public void setMensagemTopico(String mensagemTopico) {
		this.mensagemTopico = mensagemTopico;
	}

}

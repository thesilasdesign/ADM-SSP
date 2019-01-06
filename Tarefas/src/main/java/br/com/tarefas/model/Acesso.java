package br.com.tarefas.model;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
 
public class Acesso extends Authenticator {
 
	private String usuario = "";
	private String senha = "";
 
	public Acesso() {}
 
	public Acesso(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}
 
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(usuario, senha);
	}
 
	public String getSenha() {
		return senha;
	}
	public String getUsuario() {
		return usuario;
	}
}

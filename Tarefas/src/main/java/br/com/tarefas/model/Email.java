package br.com.tarefas.model;

import java.io.Serializable;

public class Email implements Serializable {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corpo == null) ? 0 : corpo.hashCode());
		result = prime * result + ((de == null) ? 0 : de.hashCode());
		result = prime * result + ((para == null) ? 0 : para.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Email other = (Email) obj;
		if (corpo == null) {
			if (other.corpo != null)
				return false;
		} else if (!corpo.equals(other.corpo))
			return false;
		if (de == null) {
			if (other.de != null)
				return false;
		} else if (!de.equals(other.de))
			return false;
		if (para == null) {
			if (other.para != null)
				return false;
		} else if (!para.equals(other.para))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	private static final long serialVersionUID = 8928827540810848202L;

	private String para;

	private String corpo;

	private String de;

	private String titulo;

	private String senha;

	public String getCorpo() {
		return corpo;
	}

	public String getDe() {
		return de;
	}

	public String getPara() {
		return para;
	}

	public String getSenha() {
		return senha;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public void setDe(String de) {
		this.de = de;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String toString() {
		return "Email [para=" + para + ", corpo=" + corpo + ", de=" + de + ", titulo=" + titulo + ", senha=" + senha
				+ "]";
	}
}
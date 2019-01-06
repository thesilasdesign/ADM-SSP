package br.com.tarefas.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Ministerio {
	
	@Id
	@GeneratedValue
	private Long MinisterioId;
	private String Comum;
	private String Cidade;
	private String Nome;
	private String Ministerio;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar DataOrdenacao;
	private String Telefone;
	private String Celular;
	public Long getMinisterioId() {
		return MinisterioId;
	}
	public void setMinisterioId(Long ministerioId) {
		MinisterioId = ministerioId;
	}
	public String getComum() {
		return Comum;
	}
	public void setComum(String comum) {
		Comum = comum;
	}
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getMinisterio() {
		return Ministerio;
	}
	public void setMinisterio(String ministerio) {
		Ministerio = ministerio;
	}
	public Calendar getDataOrdenacao() {
		return DataOrdenacao;
	}
	public void setDataOrdenacao(Calendar dataOrdenacao) {
		DataOrdenacao = dataOrdenacao;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	public String getCelular() {
		return Celular;
	}
	public void setCelular(String celular) {
		Celular = celular;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MinisterioId == null) ? 0 : MinisterioId.hashCode());
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
		Ministerio other = (Ministerio) obj;
		if (MinisterioId == null) {
			if (other.MinisterioId != null)
				return false;
		} else if (!MinisterioId.equals(other.MinisterioId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Ministerio [MinisterioId=" + MinisterioId + ", Comum=" + Comum + ", Cidade=" + Cidade + ", Nome=" + Nome
				+ ", Ministerio=" + Ministerio + ", DataOrdenacao=" + DataOrdenacao + ", Telefone=" + Telefone
				+ ", Celular=" + Celular + "]";
	}
	
	

}

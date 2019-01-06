package br.com.tarefas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Agenda {
	
	@Id
	@GeneratedValue
	private Long AgendaId;
	private String Nome;
	private String Cargo;
	private String Comum;
	private String Telefone;
	private String Celular;
	private String Email;
	public Long getAgendaId() {
		return AgendaId;
	}
	public void setAgendaId(Long agendaId) {
		AgendaId = agendaId;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCargo() {
		return Cargo;
	}
	public void setCargo(String cargo) {
		Cargo = cargo;
	}
	public String getComum() {
		return Comum;
	}
	public void setComum(String comum) {
		Comum = comum;
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
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	@Override
	public String toString() {
		return "Agenda [AgendaId=" + AgendaId + ", Nome=" + Nome + ", Cargo=" + Cargo + ", Comum=" + Comum
				+ ", Telefone=" + Telefone + ", Celular=" + Celular + ", Email=" + Email + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AgendaId == null) ? 0 : AgendaId.hashCode());
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
		Agenda other = (Agenda) obj;
		if (AgendaId == null) {
			if (other.AgendaId != null)
				return false;
		} else if (!AgendaId.equals(other.AgendaId))
			return false;
		return true;
	}
	
	
	
}
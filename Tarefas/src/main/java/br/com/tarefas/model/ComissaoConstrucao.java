package br.com.tarefas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ComissaoConstrucao {
	
	@Id
	@GeneratedValue
	private Long ComissaoConstrucaoId;
	private String Nome;
	private String Servico;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ComissaoConstrucaoId == null) ? 0 : ComissaoConstrucaoId.hashCode());
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
		ComissaoConstrucao other = (ComissaoConstrucao) obj;
		if (ComissaoConstrucaoId == null) {
			if (other.ComissaoConstrucaoId != null)
				return false;
		} else if (!ComissaoConstrucaoId.equals(other.ComissaoConstrucaoId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ComissaoConstrucao [ComissaoConstrucaoId=" + ComissaoConstrucaoId + ", Nome=" + Nome + ", Servico="
				+ Servico + ", Comum=" + Comum + ", Telefone=" + Telefone + ", Celular=" + Celular + "]";
	}
	public Long getComissaoConstrucaoId() {
		return ComissaoConstrucaoId;
	}
	public void setComissaoConstrucaoId(Long comissaoConstrucaoId) {
		ComissaoConstrucaoId = comissaoConstrucaoId;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getServico() {
		return Servico;
	}
	public void setServico(String servico) {
		Servico = servico;
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
	private String Comum;
	private String Telefone;
	private String Celular;
	
	
}
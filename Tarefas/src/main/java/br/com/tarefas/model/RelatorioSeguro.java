package br.com.tarefas.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class RelatorioSeguro {
	
	@Id
	@GeneratedValue
	private Long RelatorioSeguroId;
	private String Nome;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar DataNascimento;
	private String CPF;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar DataTrabalhada;
	public Long getRelatorioSeguroId() {
		return RelatorioSeguroId;
	}
	public void setRelatorioSeguroId(Long relatorioSeguroId) {
		RelatorioSeguroId = relatorioSeguroId;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public Calendar getDataNascimento() {
		return DataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		DataNascimento = dataNascimento;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public Calendar getDataTrabalhada() {
		return DataTrabalhada;
	}
	public void setDataTrabalhada(Calendar dataTrabalhada) {
		DataTrabalhada = dataTrabalhada;
	}
	@Override
	public String toString() {
		return "RelatorioSeguro [RelatorioSeguroId=" + RelatorioSeguroId + ", Nome=" + Nome + ", DataNascimento="
				+ DataNascimento + ", CPF=" + CPF + ", DataTrabalhada=" + DataTrabalhada + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CPF == null) ? 0 : CPF.hashCode());
		result = prime * result + ((DataNascimento == null) ? 0 : DataNascimento.hashCode());
		result = prime * result + ((DataTrabalhada == null) ? 0 : DataTrabalhada.hashCode());
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		result = prime * result + ((RelatorioSeguroId == null) ? 0 : RelatorioSeguroId.hashCode());
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
		RelatorioSeguro other = (RelatorioSeguro) obj;
		if (CPF == null) {
			if (other.CPF != null)
				return false;
		} else if (!CPF.equals(other.CPF))
			return false;
		if (DataNascimento == null) {
			if (other.DataNascimento != null)
				return false;
		} else if (!DataNascimento.equals(other.DataNascimento))
			return false;
		if (DataTrabalhada == null) {
			if (other.DataTrabalhada != null)
				return false;
		} else if (!DataTrabalhada.equals(other.DataTrabalhada))
			return false;
		if (Nome == null) {
			if (other.Nome != null)
				return false;
		} else if (!Nome.equals(other.Nome))
			return false;
		if (RelatorioSeguroId == null) {
			if (other.RelatorioSeguroId != null)
				return false;
		} else if (!RelatorioSeguroId.equals(other.RelatorioSeguroId))
			return false;
		return true;
	}

	
}

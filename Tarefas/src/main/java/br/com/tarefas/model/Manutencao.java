package br.com.tarefas.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Manutencao {
	
	@Id
	@GeneratedValue
	private Long ManutencaoId;
	private String Comum;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar DataSolicitacao;
	private String ResponsavelSolicitacao;
	private String MinisterioCargo;
	private String Email;
	private String Telefone;
	private String MinisterioCiente;
	private String Observacao;
	private String Itens;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar Estimativa;
	private String Caixa;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar PrazoRetorno;
	private String Adm;
	private String Engenharia;
	private String Anciao;
	public Long getManutencaoId() {
		return ManutencaoId;
	}
	public void setManutencaoId(Long manutencaoId) {
		ManutencaoId = manutencaoId;
	}
	public String getComum() {
		return Comum;
	}
	public void setComum(String comum) {
		Comum = comum;
	}
	public Calendar getDataSolicitacao() {
		return DataSolicitacao;
	}
	public void setDataSolicitacao(Calendar dataSolicitacao) {
		DataSolicitacao = dataSolicitacao;
	}
	public String getResponsavelSolicitacao() {
		return ResponsavelSolicitacao;
	}
	public void setResponsavelSolicitacao(String responsavelSolicitacao) {
		ResponsavelSolicitacao = responsavelSolicitacao;
	}
	public String getMinisterioCargo() {
		return MinisterioCargo;
	}
	public void setMinisterioCargo(String ministerioCargo) {
		MinisterioCargo = ministerioCargo;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	public String getMinisterioCiente() {
		return MinisterioCiente;
	}
	public void setMinisterioCiente(String ministerioCiente) {
		MinisterioCiente = ministerioCiente;
	}
	public String getObservacao() {
		return Observacao;
	}
	public void setObservacao(String observacao) {
		Observacao = observacao;
	}
	public String getItens() {
		return Itens;
	}
	public void setItens(String itens) {
		Itens = itens;
	}
	public Calendar getEstimativa() {
		return Estimativa;
	}
	public void setEstimativa(Calendar estimativa) {
		Estimativa = estimativa;
	}
	public String getCaixa() {
		return Caixa;
	}
	public void setCaixa(String caixa) {
		Caixa = caixa;
	}
	public Calendar getPrazoRetorno() {
		return PrazoRetorno;
	}
	public void setPrazoRetorno(Calendar prazoRetorno) {
		PrazoRetorno = prazoRetorno;
	}
	public String getAdm() {
		return Adm;
	}
	public void setAdm(String adm) {
		Adm = adm;
	}
	public String getEngenharia() {
		return Engenharia;
	}
	public void setEngenharia(String engenharia) {
		Engenharia = engenharia;
	}
	public String getAnciao() {
		return Anciao;
	}
	public void setAnciao(String anciao) {
		Anciao = anciao;
	}
	@Override
	public String toString() {
		return "Manutencao [ManutencaoId=" + ManutencaoId + ", Comum=" + Comum + ", DataSolicitacao=" + DataSolicitacao
				+ ", ResponsavelSolicitacao=" + ResponsavelSolicitacao + ", MinisterioCargo=" + MinisterioCargo
				+ ", Email=" + Email + ", Telefone=" + Telefone + ", MinisterioCiente=" + MinisterioCiente
				+ ", Observacao=" + Observacao + ", Itens=" + Itens + ", Estimativa=" + Estimativa + ", Caixa=" + Caixa
				+ ", PrazoRetorno=" + PrazoRetorno + ", Adm=" + Adm + ", Engenharia=" + Engenharia + ", Anciao="
				+ Anciao + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Adm == null) ? 0 : Adm.hashCode());
		result = prime * result + ((Anciao == null) ? 0 : Anciao.hashCode());
		result = prime * result + ((Caixa == null) ? 0 : Caixa.hashCode());
		result = prime * result + ((Comum == null) ? 0 : Comum.hashCode());
		result = prime * result + ((DataSolicitacao == null) ? 0 : DataSolicitacao.hashCode());
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ((Engenharia == null) ? 0 : Engenharia.hashCode());
		result = prime * result + ((Estimativa == null) ? 0 : Estimativa.hashCode());
		result = prime * result + ((Itens == null) ? 0 : Itens.hashCode());
		result = prime * result + ((ManutencaoId == null) ? 0 : ManutencaoId.hashCode());
		result = prime * result + ((MinisterioCargo == null) ? 0 : MinisterioCargo.hashCode());
		result = prime * result + ((MinisterioCiente == null) ? 0 : MinisterioCiente.hashCode());
		result = prime * result + ((Observacao == null) ? 0 : Observacao.hashCode());
		result = prime * result + ((PrazoRetorno == null) ? 0 : PrazoRetorno.hashCode());
		result = prime * result + ((ResponsavelSolicitacao == null) ? 0 : ResponsavelSolicitacao.hashCode());
		result = prime * result + ((Telefone == null) ? 0 : Telefone.hashCode());
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
		Manutencao other = (Manutencao) obj;
		if (Adm == null) {
			if (other.Adm != null)
				return false;
		} else if (!Adm.equals(other.Adm))
			return false;
		if (Anciao == null) {
			if (other.Anciao != null)
				return false;
		} else if (!Anciao.equals(other.Anciao))
			return false;
		if (Caixa == null) {
			if (other.Caixa != null)
				return false;
		} else if (!Caixa.equals(other.Caixa))
			return false;
		if (Comum == null) {
			if (other.Comum != null)
				return false;
		} else if (!Comum.equals(other.Comum))
			return false;
		if (DataSolicitacao == null) {
			if (other.DataSolicitacao != null)
				return false;
		} else if (!DataSolicitacao.equals(other.DataSolicitacao))
			return false;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (Engenharia == null) {
			if (other.Engenharia != null)
				return false;
		} else if (!Engenharia.equals(other.Engenharia))
			return false;
		if (Estimativa == null) {
			if (other.Estimativa != null)
				return false;
		} else if (!Estimativa.equals(other.Estimativa))
			return false;
		if (Itens == null) {
			if (other.Itens != null)
				return false;
		} else if (!Itens.equals(other.Itens))
			return false;
		if (ManutencaoId == null) {
			if (other.ManutencaoId != null)
				return false;
		} else if (!ManutencaoId.equals(other.ManutencaoId))
			return false;
		if (MinisterioCargo == null) {
			if (other.MinisterioCargo != null)
				return false;
		} else if (!MinisterioCargo.equals(other.MinisterioCargo))
			return false;
		if (MinisterioCiente == null) {
			if (other.MinisterioCiente != null)
				return false;
		} else if (!MinisterioCiente.equals(other.MinisterioCiente))
			return false;
		if (Observacao == null) {
			if (other.Observacao != null)
				return false;
		} else if (!Observacao.equals(other.Observacao))
			return false;
		if (PrazoRetorno == null) {
			if (other.PrazoRetorno != null)
				return false;
		} else if (!PrazoRetorno.equals(other.PrazoRetorno))
			return false;
		if (ResponsavelSolicitacao == null) {
			if (other.ResponsavelSolicitacao != null)
				return false;
		} else if (!ResponsavelSolicitacao.equals(other.ResponsavelSolicitacao))
			return false;
		if (Telefone == null) {
			if (other.Telefone != null)
				return false;
		} else if (!Telefone.equals(other.Telefone))
			return false;
		return true;
	}
	
	
	
}
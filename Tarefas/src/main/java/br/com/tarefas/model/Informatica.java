package br.com.tarefas.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Informatica {

	@Id
	@GeneratedValue
	private Long InformaticaId;
	private String TipoServico;
	private String Solicitacao;
	private String Descricao;
	private String Local;
	private String Solicitante;
	private String EmailSolicitante;
	private String Status;
	private String Atendente;
	private String ObservacaoAtendente;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar DataAbertura;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar DataFechamento;
	
	public String getObservacaoAtendente() {
		return ObservacaoAtendente;
	}

	public void setObservacaoAtendente(String observacaoAtendente) {
		ObservacaoAtendente = observacaoAtendente;
	}

	public Long getInformaticaId() {
		return InformaticaId;
	}

	public void setInformaticaId(Long informaticaId) {
		InformaticaId = informaticaId;
	}

	public String getTipoServico() {
		return TipoServico;
	}

	public void setTipoServico(String tipoServico) {
		TipoServico = tipoServico;
	}

	public String getSolicitacao() {
		return Solicitacao;
	}

	public void setSolicitacao(String solicitacao) {
		Solicitacao = solicitacao;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public String getLocal() {
		return Local;
	}

	public void setLocal(String local) {
		Local = local;
	}

	public String getSolicitante() {
		return Solicitante;
	}

	public void setSolicitante(String solicitante) {
		Solicitante = solicitante;
	}

	public String getEmailSolicitante() {
		return EmailSolicitante;
	}

	public void setEmailSolicitante(String emailSolicitante) {
		EmailSolicitante = emailSolicitante;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getAtendente() {
		return Atendente;
	}

	public void setAtendente(String atendente) {
		Atendente = atendente;
	}

	public Calendar getDataAbertura() {
		return DataAbertura;
	}

	public void setDataAbertura(Calendar dataAbertura) {
		DataAbertura = dataAbertura;
	}

	public Calendar getDataFechamento() {
		return DataFechamento;
	}

	public void setDataFechamento(Calendar dataFechamento) {
		DataFechamento = dataFechamento;
	}

	@Override
	public String toString() {
		return "Informatica [ObservacaoAtendente=" + ObservacaoAtendente + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((InformaticaId == null) ? 0 : InformaticaId.hashCode());
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
		Informatica other = (Informatica) obj;
		if (InformaticaId == null) {
			if (other.InformaticaId != null)
				return false;
		} else if (!InformaticaId.equals(other.InformaticaId))
			return false;
		return true;
	}

}

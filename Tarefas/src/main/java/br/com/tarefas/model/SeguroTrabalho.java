package br.com.tarefas.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class SeguroTrabalho {

	@Id
	@GeneratedValue
	private Long SeguroTrabalhoId;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar Data;
	private String UsoSeguro;
	private String Observacao;
	private String Sinistro;
	private String Comum;
	
	@ManyToOne
	@JoinColumn(name ="SeguroId")
	private Seguro seguro;

	public Long getSeguroTrabalhoId() {
		return SeguroTrabalhoId;
	}

	public void setSeguroTrabalhoId(Long seguroTrabalhoId) {
		SeguroTrabalhoId = seguroTrabalhoId;
	}

	public Calendar getData() {
		return Data;
	}

	public void setData(Calendar data) {
		Data = data;
	}

	public String getUsoSeguro() {
		return UsoSeguro;
	}

	public void setUsoSeguro(String usoSeguro) {
		UsoSeguro = usoSeguro;
	}

	public String getObservacao() {
		return Observacao;
	}

	public void setObservacao(String observacao) {
		Observacao = observacao;
	}

	public String getSinistro() {
		return Sinistro;
	}

	public void setSinistro(String sinistro) {
		Sinistro = sinistro;
	}

	public String getComum() {
		return Comum;
	}

	public void setComum(String comum) {
		Comum = comum;
	}

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	@Override
	public String toString() {
		return "SeguroTrabalho [SeguroTrabalhoId=" + SeguroTrabalhoId + ", Data=" + Data + ", UsoSeguro=" + UsoSeguro
				+ ", Observacao=" + Observacao + ", Sinistro=" + Sinistro + ", Comum=" + Comum + ", seguro=" + seguro
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Comum == null) ? 0 : Comum.hashCode());
		result = prime * result + ((Data == null) ? 0 : Data.hashCode());
		result = prime * result + ((Observacao == null) ? 0 : Observacao.hashCode());
		result = prime * result + ((SeguroTrabalhoId == null) ? 0 : SeguroTrabalhoId.hashCode());
		result = prime * result + ((Sinistro == null) ? 0 : Sinistro.hashCode());
		result = prime * result + ((UsoSeguro == null) ? 0 : UsoSeguro.hashCode());
		result = prime * result + ((seguro == null) ? 0 : seguro.hashCode());
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
		SeguroTrabalho other = (SeguroTrabalho) obj;
		if (Comum == null) {
			if (other.Comum != null)
				return false;
		} else if (!Comum.equals(other.Comum))
			return false;
		if (Data == null) {
			if (other.Data != null)
				return false;
		} else if (!Data.equals(other.Data))
			return false;
		if (Observacao == null) {
			if (other.Observacao != null)
				return false;
		} else if (!Observacao.equals(other.Observacao))
			return false;
		if (SeguroTrabalhoId == null) {
			if (other.SeguroTrabalhoId != null)
				return false;
		} else if (!SeguroTrabalhoId.equals(other.SeguroTrabalhoId))
			return false;
		if (Sinistro == null) {
			if (other.Sinistro != null)
				return false;
		} else if (!Sinistro.equals(other.Sinistro))
			return false;
		if (UsoSeguro == null) {
			if (other.UsoSeguro != null)
				return false;
		} else if (!UsoSeguro.equals(other.UsoSeguro))
			return false;
		if (seguro == null) {
			if (other.seguro != null)
				return false;
		} else if (!seguro.equals(other.seguro))
			return false;
		return true;
	}
}

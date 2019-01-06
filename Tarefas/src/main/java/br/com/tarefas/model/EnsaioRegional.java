package br.com.tarefas.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class EnsaioRegional {
	
	@Id
	@GeneratedValue
	private Long EnsaioRegionalId;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar DataEnsaio;
	private String Musicos;
	private String Organistas;
	private String Irmandade;
	private String RegionalAtendimento;
	private String AnciaoAtendimento;
	private String TotalGeral;
	public Long getEnsaioRegionalId() {
		return EnsaioRegionalId;
	}
	public void setEnsaioRegionalId(Long ensaioRegionalId) {
		EnsaioRegionalId = ensaioRegionalId;
	}
	public Calendar getDataEnsaio() {
		return DataEnsaio;
	}
	public void setDataEnsaio(Calendar dataEnsaio) {
		DataEnsaio = dataEnsaio;
	}
	public String getMusicos() {
		return Musicos;
	}
	public void setMusicos(String musicos) {
		Musicos = musicos;
	}
	public String getOrganistas() {
		return Organistas;
	}
	public void setOrganistas(String organistas) {
		Organistas = organistas;
	}
	public String getIrmandade() {
		return Irmandade;
	}
	public void setIrmandade(String irmandade) {
		Irmandade = irmandade;
	}
	public String getRegionalAtendimento() {
		return RegionalAtendimento;
	}
	public void setRegionalAtendimento(String regionalAtendimento) {
		RegionalAtendimento = regionalAtendimento;
	}
	public String getAnciaoAtendimento() {
		return AnciaoAtendimento;
	}
	public void setAnciaoAtendimento(String anciaoAtendimento) {
		AnciaoAtendimento = anciaoAtendimento;
	}
	public String getTotalGeral() {
		return TotalGeral;
	}
	public void setTotalGeral(String totalGeral) {
		TotalGeral = totalGeral;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((EnsaioRegionalId == null) ? 0 : EnsaioRegionalId.hashCode());
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
		EnsaioRegional other = (EnsaioRegional) obj;
		if (EnsaioRegionalId == null) {
			if (other.EnsaioRegionalId != null)
				return false;
		} else if (!EnsaioRegionalId.equals(other.EnsaioRegionalId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "EnsaioRegional [EnsaioRegionalId=" + EnsaioRegionalId + ", DataEnsaio=" + DataEnsaio + ", Musicos="
				+ Musicos + ", Organistas=" + Organistas + ", Irmandade=" + Irmandade + ", RegionalAtendimento="
				+ RegionalAtendimento + ", AnciaoAtendimento=" + AnciaoAtendimento + ", TotalGeral=" + TotalGeral + "]";
	}
	
	
	

}

package br.com.tarefas.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class SantaCeia {
	
	@Id
	@GeneratedValue
	private Long SantaCeiaId;
	private String CodigoIgreja;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar DataSantaCeia;
	private String Comum;
	private String Anciao;
	private Integer Homens;
	private Integer Mulheres;
	private Integer Total;
	private String Ano;
	
	public Long getSantaCeiaId() {
		return SantaCeiaId;
	}
	
	public Calendar getDataSantaCeia() {
		return DataSantaCeia;
	}
	public void setDataSantaCeia(Calendar dataSantaCeia) {
		DataSantaCeia = dataSantaCeia;
	}
	
	public void setSantaCeiaId(Long santaCeiaId) {
		SantaCeiaId = santaCeiaId;
	}
	public String getCodigoIgreja() {
		return CodigoIgreja;
	}
	public void setCodigoIgreja(String codigoIgreja) {
		CodigoIgreja = codigoIgreja;
	}
	public String getComum() {
		return Comum;
	}
	public void setComum(String comum) {
		Comum = comum;
	}
	public String getAnciao() {
		return Anciao;
	}
	public void setAnciao(String anciao) {
		Anciao = anciao;
	}
	public Integer getHomens() {
		return Homens;
	}
	public void setHomens(Integer homens) {
		Homens = homens;
	}
	public Integer getMulheres() {
		return Mulheres;
	}
	public void setMulheres(Integer mulheres) {
		Mulheres = mulheres;
	}
	public Integer getTotal() {
		return Total;
	}
	public void setTotal(Integer total) {
		Total = total;
	}
	public String getAno() {
		return Ano;
	}
	public void setAno(String ano) {
		Ano = ano;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((SantaCeiaId == null) ? 0 : SantaCeiaId.hashCode());
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
		SantaCeia other = (SantaCeia) obj;
		if (SantaCeiaId == null) {
			if (other.SantaCeiaId != null)
				return false;
		} else if (!SantaCeiaId.equals(other.SantaCeiaId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SantaCeia [SantaCeiaId=" + SantaCeiaId + ", CodigoIgreja=" + CodigoIgreja + ", Comum=" + Comum
				+ ", Anciao=" + Anciao + ", Homens=" + Homens + ", Mulheres=" + Mulheres + ", Total=" + Total + ", Ano="
				+ Ano + "]";
	}
	
	
	

}

package br.com.tarefas.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Batismo {
	
	@Id
	@GeneratedValue
	private Long BatismoId;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar DataBatismo;
	
	private String Atendimento;
	private Integer QuantidadeTotal;
	private Integer QuantidadeMulher;
	private Integer QuantidadeHomem;
	private String LocalidadeAnciao;
	private String Igreja;
	public Long getBatismoId() {
		return BatismoId;
	}
	public void setBatismoId(Long batismoId) {
		BatismoId = batismoId;
	}
	public Calendar getDataBatismo() {
		return DataBatismo;
	}
	public void setDataBatismo(Calendar dataBatismo) {
		DataBatismo = dataBatismo;
	}
	public String getAtendimento() {
		return Atendimento;
	}
	public void setAtendimento(String atendimento) {
		Atendimento = atendimento;
	}
	public Integer getQuantidadeTotal() {
		return QuantidadeTotal;
	}
	public void setQuantidadeTotal(Integer quantidadeTotal) {
		QuantidadeTotal = quantidadeTotal;
	}
	public Integer getQuantidadeMulher() {
		return QuantidadeMulher;
	}
	public void setQuantidadeMulher(Integer quantidadeMulher) {
		QuantidadeMulher = quantidadeMulher;
	}
	public Integer getQuantidadeHomem() {
		return QuantidadeHomem;
	}
	public void setQuantidadeHomem(Integer quantidadeHomem) {
		QuantidadeHomem = quantidadeHomem;
	}
	public String getLocalidadeAnciao() {
		return LocalidadeAnciao;
	}
	public void setLocalidadeAnciao(String localidadeAnciao) {
		LocalidadeAnciao = localidadeAnciao;
	}
	public String getIgreja() {
		return Igreja;
	}
	public void setIgreja(String igreja) {
		Igreja = igreja;
	}
	@Override
	public String toString() {
		return "Batismo [BatismoId=" + BatismoId + ", DataBatismo=" + DataBatismo + ", Atendimento=" + Atendimento
				+ ", QuantidadeTotal=" + QuantidadeTotal + ", QuantidadeMulher=" + QuantidadeMulher
				+ ", QuantidadeHomem=" + QuantidadeHomem + ", LocalidadeAnciao=" + LocalidadeAnciao + ", Igreja="
				+ Igreja + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((BatismoId == null) ? 0 : BatismoId.hashCode());
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
		Batismo other = (Batismo) obj;
		if (BatismoId == null) {
			if (other.BatismoId != null)
				return false;
		} else if (!BatismoId.equals(other.BatismoId))
			return false;
		return true;
	}
	
	
	

}

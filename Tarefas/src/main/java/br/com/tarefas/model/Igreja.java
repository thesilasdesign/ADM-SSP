package br.com.tarefas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Igreja {
	
	@Id
	@GeneratedValue
	private Long IgrejaId;
	private String CodIgrejas;
	private String Comum;
	private String Endereco;
	private String Cep;
	private String Anciao;
	private String Cooperador;
	private String Diacono;
	private String DiasCulto;
	@SuppressWarnings("unused")
	private String Ativo;
	public Long getIgrejaId() {
		return IgrejaId;
	}
	public void setIgrejaId(Long igrejaId) {
		IgrejaId = igrejaId;
	}
	public String getCodIgrejas() {
		return CodIgrejas;
	}
	public void setCodIgrejas(String codIgrejas) {
		CodIgrejas = codIgrejas;
	}
	public String getComum() {
		return Comum;
	}
	public void setComum(String comum) {
		Comum = comum;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public String getCep() {
		return Cep;
	}
	public void setCep(String cep) {
		Cep = cep;
	}
	public String getAnciao() {
		return Anciao;
	}
	public void setAnciao(String anciao) {
		Anciao = anciao;
	}
	public String getCooperador() {
		return Cooperador;
	}
	public void setCooperador(String cooperador) {
		Cooperador = cooperador;
	}
	public String getDiacono() {
		return Diacono;
	}
	public void setDiacono(String diacono) {
		Diacono = diacono;
	}
	public String getDiasCulto() {
		return DiasCulto;
	}
	public void setDiasCulto(String diasCulto) {
		DiasCulto = diasCulto;
	}
	@Override
	public String toString() {
		return "Igreja [IgrejaId=" + IgrejaId + ", CodIgrejas=" + CodIgrejas + ", Comum=" + Comum + ", Endereco="
				+ Endereco + ", Cep=" + Cep + ", Anciao=" + Anciao + ", Cooperador=" + Cooperador + ", Diacono="
				+ Diacono + ", DiasCulto=" + DiasCulto + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CodIgrejas == null) ? 0 : CodIgrejas.hashCode());
		result = prime * result + ((IgrejaId == null) ? 0 : IgrejaId.hashCode());
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
		Igreja other = (Igreja) obj;
		if (CodIgrejas == null) {
			if (other.CodIgrejas != null)
				return false;
		} else if (!CodIgrejas.equals(other.CodIgrejas))
			return false;
		if (IgrejaId == null) {
			if (other.IgrejaId != null)
				return false;
		} else if (!IgrejaId.equals(other.IgrejaId))
			return false;
		return true;
	}
	
	
	

}

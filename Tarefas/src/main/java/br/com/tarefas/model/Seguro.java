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
public class Seguro {

	@Id
	@GeneratedValue
	private Long SeguroId;
	private String Nome;
	private String Comum;
	private String Cpf;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar DataNascimento;
	private String Ministerio;
	

	@OneToMany(mappedBy = "seguro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<SeguroTrabalho> seguroTrabalho;

	public Seguro() {

	}

	public Long getSeguroId() {
		return SeguroId;
	}

	public void setSeguroId(Long seguroId) {
		SeguroId = seguroId;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getComum() {
		return Comum;
	}

	public void setComum(String comum) {
		Comum = comum;
	}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		Cpf = cpf;
	}

	public Calendar getDataNascimento() {
		return DataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		DataNascimento = dataNascimento;
	}

	public String getMinisterio() {
		return Ministerio;
	}

	public void setMinisterio(String ministerio) {
		Ministerio = ministerio;
	}

	public List<SeguroTrabalho> getSeguroTrabalho() {
		return seguroTrabalho;
	}

	public void setSeguroTrabalho(List<SeguroTrabalho> seguroTrabalho) {
		this.seguroTrabalho = seguroTrabalho;
	}

	@Override
	public String toString() {
		return "Seguro [SeguroId=" + SeguroId + ", Nome=" + Nome + ", Comum=" + Comum + ", Cpf=" + Cpf
				+ ", DataNascimento=" + DataNascimento + ", Ministerio=" + Ministerio + ", seguroTrabalho="
				+ seguroTrabalho + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Comum == null) ? 0 : Comum.hashCode());
		result = prime * result + ((Cpf == null) ? 0 : Cpf.hashCode());
		result = prime * result + ((DataNascimento == null) ? 0 : DataNascimento.hashCode());
		result = prime * result + ((Ministerio == null) ? 0 : Ministerio.hashCode());
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		result = prime * result + ((SeguroId == null) ? 0 : SeguroId.hashCode());
		result = prime * result + ((seguroTrabalho == null) ? 0 : seguroTrabalho.hashCode());
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
		Seguro other = (Seguro) obj;
		if (Comum == null) {
			if (other.Comum != null)
				return false;
		} else if (!Comum.equals(other.Comum))
			return false;
		if (Cpf == null) {
			if (other.Cpf != null)
				return false;
		} else if (!Cpf.equals(other.Cpf))
			return false;
		if (DataNascimento == null) {
			if (other.DataNascimento != null)
				return false;
		} else if (!DataNascimento.equals(other.DataNascimento))
			return false;
		if (Ministerio == null) {
			if (other.Ministerio != null)
				return false;
		} else if (!Ministerio.equals(other.Ministerio))
			return false;
		if (Nome == null) {
			if (other.Nome != null)
				return false;
		} else if (!Nome.equals(other.Nome))
			return false;
		if (SeguroId == null) {
			if (other.SeguroId != null)
				return false;
		} else if (!SeguroId.equals(other.SeguroId))
			return false;
		if (seguroTrabalho == null) {
			if (other.seguroTrabalho != null)
				return false;
		} else if (!seguroTrabalho.equals(other.seguroTrabalho))
			return false;
		return true;
	}
	
	
	

	
}

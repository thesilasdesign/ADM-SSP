package br.com.tarefas.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Aprendiz {
	
	@Id
	@GeneratedValue
	private Long AprendizId;
	private String Comum;
	private String Nome;
	private String Endereco;
	private String Bairro;
	private String Cidade;
	private String Telefone;
	private String Celular;
	private String Email;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar DataBatismo;
	private String Oficializado;
	public String getOficializado() {
		return Oficializado;
	}
	public void setOficializado(String oficializado) {
		Oficializado = oficializado;
	}
	private String Instrumento;
	
	public Long getAprendizId() {
		return AprendizId;
	}
	public void setMusicoId(Long aprendizId) {
		AprendizId = aprendizId;
	}
	public String getComum() {
		return Comum;
	}
	public void setComum(String comum) {
		Comum = comum;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public String getBairro() {
		return Bairro;
	}
	public void setBairro(String bairro) {
		Bairro = bairro;
	}
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
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
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Calendar getDataBatismo() {
		return DataBatismo;
	}
	public void setDataBatismo(Calendar dataBatismo) {
		DataBatismo = dataBatismo;
	}

	public String getInstrumento() {
		return Instrumento;
	}
	public void setInstrumento(String instrumento) {
		Instrumento = instrumento;
	}
	@Override
	public String toString() {
		return "Musicos [MusicoId=" + AprendizId + ", Comum=" + Comum + ", Nome=" + Nome + ", Endereco=" + Endereco
				+ ", Bairro=" + Bairro + ", Cidade=" + Cidade + ", Telefone=" + Telefone + ", Celular=" + Celular
				+ ", Email=" + Email + ", DataBatismo=" + DataBatismo + ", Batizado=" + Oficializado + ", Instrumento="
				+ Instrumento + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AprendizId == null) ? 0 : AprendizId.hashCode());
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
		Aprendiz other = (Aprendiz) obj;
		if (AprendizId == null) {
			if (other.AprendizId != null)
				return false;
		} else if (!AprendizId.equals(other.AprendizId))
			return false;
		return true;
	}
	
	
	
}

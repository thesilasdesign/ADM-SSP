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
public class Comentario {
	
	@Id
	@GeneratedValue
	private Long ComentarioId;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar DataComentario;
	private String Texto;
	private String Nome;
	@ManyToOne
	@JoinColumn(name = "compraId")
	private Compra compra;
	
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public Long getComentarioId() {
		return ComentarioId;
	}
	public void setComentarioId(Long comentarioId) {
		ComentarioId = comentarioId;
	}
	public Calendar getDataComentario() {
		return DataComentario;
	}
	public void setDataComentario(Calendar dataComentario) {
		DataComentario = dataComentario;
	}
	
	public String getTexto() {
		return Texto;
	}
	public void setTexto(String texto) {
		Texto = texto;
	}
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ComentarioId == null) ? 0 : ComentarioId.hashCode());
		result = prime * result + ((DataComentario == null) ? 0 : DataComentario.hashCode());
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		result = prime * result + ((Texto == null) ? 0 : Texto.hashCode());
		result = prime * result + ((compra == null) ? 0 : compra.hashCode());
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
		Comentario other = (Comentario) obj;
		if (ComentarioId == null) {
			if (other.ComentarioId != null)
				return false;
		} else if (!ComentarioId.equals(other.ComentarioId))
			return false;
		if (DataComentario == null) {
			if (other.DataComentario != null)
				return false;
		} else if (!DataComentario.equals(other.DataComentario))
			return false;
		if (Nome == null) {
			if (other.Nome != null)
				return false;
		} else if (!Nome.equals(other.Nome))
			return false;
		if (Texto == null) {
			if (other.Texto != null)
				return false;
		} else if (!Texto.equals(other.Texto))
			return false;
		if (compra == null) {
			if (other.compra != null)
				return false;
		} else if (!compra.equals(other.compra))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Comentario [ComentarioId=" + ComentarioId + ", DataComentario=" + DataComentario + ", Texto=" + Texto
				+ ", Nome=" + Nome + ", compra=" + compra + "]";
	}
	
	


	
}

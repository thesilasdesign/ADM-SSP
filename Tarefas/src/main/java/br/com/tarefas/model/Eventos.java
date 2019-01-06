package br.com.tarefas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Eventos {

	@Id
	@GeneratedValue
	private Long EventosId;
	private String Titulo;
	private String Data;	
	private String Local;
	
	@Column(name="Texto", columnDefinition="TEXT")
	private String Texto;
	
	public Long getEventosId() {
		return EventosId;
	}
	public void setEventosId(Long eventosId) {
		EventosId = eventosId;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getLocal() {
		return Local;
	}
	public void setLocal(String local) {
		Local = local;
	}
	public String getTexto() {
		return Texto;
	}
	public void setTexto(String texto) {
		Texto = texto;
	}
	
	public String getData() {
		return Data;
	}
	public void setData(String data) {
		Data = data;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((EventosId == null) ? 0 : EventosId.hashCode());
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
		Eventos other = (Eventos) obj;
		if (EventosId == null) {
			if (other.EventosId != null)
				return false;
		} else if (!EventosId.equals(other.EventosId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Eventos [EventosId=" + EventosId + ", Titulo=" + Titulo + ", Data=" + Data + ", Local="
				+ Local + ", Texto=" + Texto + "]";
	}

	
	
}


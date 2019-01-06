package br.com.tarefas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Notificacao {
	
	@Id
	@GeneratedValue
	private Long NotificacaoId;
	private String Campo1;
	private String Campo2;
	private String Campo3;
	private String Campo4;
	
	public Long getNotificacaoId() {
		return NotificacaoId;
	}
	public void setNotificacaoId(Long notificacaoId) {
		NotificacaoId = notificacaoId;
	}
	public String getCampo1() {
		return Campo1;
	}
	public void setCampo1(String campo1) {
		Campo1 = campo1;
	}
	public String getCampo2() {
		return Campo2;
	}
	public void setCampo2(String campo2) {
		Campo2 = campo2;
	}
	public String getCampo3() {
		return Campo3;
	}
	public void setCampo3(String campo3) {
		Campo3 = campo3;
	}
	public String getCampo4() {
		return Campo4;
	}
	public void setCampo4(String campo4) {
		Campo4 = campo4;
	}
	@Override
	public String toString() {
		return "Notificacao [NotificacaoId=" + NotificacaoId + ", Campo1=" + Campo1 + ", Campo2=" + Campo2 + ", Campo3="
				+ Campo3 + ", Campo4=" + Campo4 + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Campo1 == null) ? 0 : Campo1.hashCode());
		result = prime * result + ((Campo2 == null) ? 0 : Campo2.hashCode());
		result = prime * result + ((Campo3 == null) ? 0 : Campo3.hashCode());
		result = prime * result + ((Campo4 == null) ? 0 : Campo4.hashCode());
		result = prime * result + ((NotificacaoId == null) ? 0 : NotificacaoId.hashCode());
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
		Notificacao other = (Notificacao) obj;
		if (Campo1 == null) {
			if (other.Campo1 != null)
				return false;
		} else if (!Campo1.equals(other.Campo1))
			return false;
		if (Campo2 == null) {
			if (other.Campo2 != null)
				return false;
		} else if (!Campo2.equals(other.Campo2))
			return false;
		if (Campo3 == null) {
			if (other.Campo3 != null)
				return false;
		} else if (!Campo3.equals(other.Campo3))
			return false;
		if (Campo4 == null) {
			if (other.Campo4 != null)
				return false;
		} else if (!Campo4.equals(other.Campo4))
			return false;
		if (NotificacaoId == null) {
			if (other.NotificacaoId != null)
				return false;
		} else if (!NotificacaoId.equals(other.NotificacaoId))
			return false;
		return true;
	}
	
		
}
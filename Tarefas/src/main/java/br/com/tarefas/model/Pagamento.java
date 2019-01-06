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
public class Pagamento {
	
	@Id
	@GeneratedValue
	private Long PagamentoId;
	@ManyToOne
	@JoinColumn(name = "compraId")
	private Compra compra;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar Vencimento;
	private Float ValorParcela;
	private String TipoPagamento;
	private String Observacao;
	private String AvistaPrazo;
	private String NumeroParcela;
	
	
	public String getNumeroParcela() {
		return NumeroParcela;
	}
	public void setNumeroParcela(String numeroParcela) {
		NumeroParcela = numeroParcela;
	}
	public Long getPagamentoId() {
		return PagamentoId;
	}
	public void setPagamentoId(Long pagamentoId) {
		PagamentoId = pagamentoId;
	}
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	public Calendar getVencimento() {
		return Vencimento;
	}
	public void setVencimento(Calendar vencimento) {
		Vencimento = vencimento;
	}
	public Float getValorParcela() {
		return ValorParcela;
	}
	public void setValorParcela(Float valorParcela) {
		ValorParcela = valorParcela;
	}
	public String getTipoPagamento() {
		return TipoPagamento;
	}
	public void setTipoPagamento(String tipoPagamento) {
		TipoPagamento = tipoPagamento;
	}
	public String getObservacao() {
		return Observacao;
	}
	public void setObservacao(String observacao) {
		Observacao = observacao;
	}
	public String getAvistaPrazo() {
		return AvistaPrazo;
	}
	public void setAvistaPrazo(String avistaPrazo) {
		AvistaPrazo = avistaPrazo;
	}
	@Override
	public String toString() {
		return "Pagamento [PagamentoId=" + PagamentoId + ", compra=" + compra + ", Vencimento=" + Vencimento
				+ ", ValorParcela=" + ValorParcela + ", TipoPagamento=" + TipoPagamento + ", Observacao=" + Observacao
				+ ", AvistaPrazo=" + AvistaPrazo + ", NumeroParcela=" + NumeroParcela + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AvistaPrazo == null) ? 0 : AvistaPrazo.hashCode());
		result = prime * result + ((NumeroParcela == null) ? 0 : NumeroParcela.hashCode());
		result = prime * result + ((Observacao == null) ? 0 : Observacao.hashCode());
		result = prime * result + ((PagamentoId == null) ? 0 : PagamentoId.hashCode());
		result = prime * result + ((TipoPagamento == null) ? 0 : TipoPagamento.hashCode());
		result = prime * result + ((ValorParcela == null) ? 0 : ValorParcela.hashCode());
		result = prime * result + ((Vencimento == null) ? 0 : Vencimento.hashCode());
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
		Pagamento other = (Pagamento) obj;
		if (AvistaPrazo == null) {
			if (other.AvistaPrazo != null)
				return false;
		} else if (!AvistaPrazo.equals(other.AvistaPrazo))
			return false;
		if (NumeroParcela == null) {
			if (other.NumeroParcela != null)
				return false;
		} else if (!NumeroParcela.equals(other.NumeroParcela))
			return false;
		if (Observacao == null) {
			if (other.Observacao != null)
				return false;
		} else if (!Observacao.equals(other.Observacao))
			return false;
		if (PagamentoId == null) {
			if (other.PagamentoId != null)
				return false;
		} else if (!PagamentoId.equals(other.PagamentoId))
			return false;
		if (TipoPagamento == null) {
			if (other.TipoPagamento != null)
				return false;
		} else if (!TipoPagamento.equals(other.TipoPagamento))
			return false;
		if (ValorParcela == null) {
			if (other.ValorParcela != null)
				return false;
		} else if (!ValorParcela.equals(other.ValorParcela))
			return false;
		if (Vencimento == null) {
			if (other.Vencimento != null)
				return false;
		} else if (!Vencimento.equals(other.Vencimento))
			return false;
		if (compra == null) {
			if (other.compra != null)
				return false;
		} else if (!compra.equals(other.compra))
			return false;
		return true;
	}
	
}
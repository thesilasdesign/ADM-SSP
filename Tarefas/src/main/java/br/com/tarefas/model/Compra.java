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
public class Compra {

	@Id
	@GeneratedValue
	private Long CompraId;

	public List<CompraItem> getCompraItem() {
		return compraItem;
	}

	public void setCompraItem(List<CompraItem> compraItem) {
		this.compraItem = compraItem;
	}

	@OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CompraItem> compraItem;

	@OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Comentario> comentario;
	
	@OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Pagamento> pagamento;

	public Compra() {

	}
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar DataAbertura;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar DataEntrega;
	private String HoraEntrega;
	private String EnderecoEntrega;
	private String Telefone;
	private String Pessoa;
	private String Comum;
	private String Descricao;
	private String Status;
	private String Solicitante;
	private String EmailSolicitante;
	private String Comprador;
	private String CompradorId;
	private String AprovacaoId;
	private String AprovacaoPresidente;
	private String CentroCusto;
	private String Fornecedor;
	private Double ValorTotal;
	
	public Double getValorTotal() {
		return ValorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		ValorTotal = valorTotal;
	}

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar DataAprovacaoPresidente;
	private String AprovacaoTesoureiro;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar DataAprovacaoTesoureiro;
	private String AprovacaoEngenheiro;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar DataAprovacaoEngenheiro;

	
	public String getFornecedor() {
		return Fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		Fornecedor = fornecedor;
	}

	public String getCentroCusto() {
		return CentroCusto;
	}

	public void setCentroCusto(String centroCusto) {
		CentroCusto = centroCusto;
	}

	public String getAprovacaoPresidente() {
		return AprovacaoPresidente;
	}

	public void setAprovacaoPresidente(String aprovacaoPresidente) {
		AprovacaoPresidente = aprovacaoPresidente;
	}

	public Calendar getDataAprovacaoPresidente() {
		return DataAprovacaoPresidente;
	}

	public void setDataAprovacaoPresidente(Calendar dataAprovacaoPresidente) {
		DataAprovacaoPresidente = dataAprovacaoPresidente;
	}

	public String getAprovacaoTesoureiro() {
		return AprovacaoTesoureiro;
	}

	public void setAprovacaoTesoureiro(String aprovacaoTesoureiro) {
		AprovacaoTesoureiro = aprovacaoTesoureiro;
	}

	public Calendar getDataAprovacaoTesoureiro() {
		return DataAprovacaoTesoureiro;
	}

	public void setDataAprovacaoTesoureiro(Calendar dataAprovacaoTesoureiro) {
		DataAprovacaoTesoureiro = dataAprovacaoTesoureiro;
	}

	public String getAprovacaoEngenheiro() {
		return AprovacaoEngenheiro;
	}

	public void setAprovacaoEngenheiro(String aprovacaoEngenheiro) {
		AprovacaoEngenheiro = aprovacaoEngenheiro;
	}

	public Calendar getDataAprovacaoEngenheiro() {
		return DataAprovacaoEngenheiro;
	}

	public void setDataAprovacaoEngenheiro(Calendar dataAprovacaoEngenheiro) {
		DataAprovacaoEngenheiro = dataAprovacaoEngenheiro;
	}

	public Long getCompraId() {
		return CompraId;
	}

	public void setCompraId(Long compraId) {
		CompraId = compraId;
	}

	public Calendar getDataAbertura() {
		return DataAbertura;
	}

	public void setDataAbertura(Calendar dataAbertura) {
		DataAbertura = dataAbertura;
	}

	public Calendar getDataEntrega() {
		return DataEntrega;
	}

	public void setDataEntrega(Calendar dataEntrega) {
		DataEntrega = dataEntrega;
	}

	public String getHoraEntrega() {
		return HoraEntrega;
	}

	public void setHoraEntrega(String horaEntrega) {
		HoraEntrega = horaEntrega;
	}

	public String getEnderecoEntrega() {
		return EnderecoEntrega;
	}

	public void setEnderecoEntrega(String enderecoEntrega) {
		EnderecoEntrega = enderecoEntrega;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public String getPessoa() {
		return Pessoa;
	}

	public void setPessoa(String pessoa) {
		Pessoa = pessoa;
	}

	public String getComum() {
		return Comum;
	}

	public void setComum(String comum) {
		Comum = comum;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getSolicitante() {
		return Solicitante;
	}

	public void setSolicitante(String solicitante) {
		Solicitante = solicitante;
	}

	public String getEmailSolicitante() {
		return EmailSolicitante;
	}

	public void setEmailSolicitante(String emailSolicitante) {
		EmailSolicitante = emailSolicitante;
	}

	public String getComprador() {
		return Comprador;
	}

	public void setComprador(String comprador) {
		Comprador = comprador;
	}

	public String getCompradorId() {
		return CompradorId;
	}

	public void setCompradorId(String compradorId) {
		CompradorId = compradorId;
	}

	public String getAprovacaoId() {
		return AprovacaoId;
	}

	public void setAprovacaoId(String aprovacaoId) {
		AprovacaoId = aprovacaoId;
	}

	public List<Comentario> getComentario() {
		return comentario;
	}

	public void setComentario(List<Comentario> comentario) {
		this.comentario = comentario;
	}
	
	public List<Pagamento> getPagamento() {
		return pagamento;
	}

	public void setPagamento(List<Pagamento> pagamento) {
		this.pagamento = pagamento;
	}

	
	@Override
	public String toString() {
		return "Compra [CompraId=" + CompraId + ", compraItem=" + compraItem + ", comentario=" + comentario
				+ ", pagamento=" + pagamento + ", DataAbertura=" + DataAbertura + ", DataEntrega=" + DataEntrega
				+ ", HoraEntrega=" + HoraEntrega + ", EnderecoEntrega=" + EnderecoEntrega + ", Telefone=" + Telefone
				+ ", Pessoa=" + Pessoa + ", Comum=" + Comum + ", Descricao=" + Descricao + ", Status=" + Status
				+ ", Solicitante=" + Solicitante + ", EmailSolicitante=" + EmailSolicitante + ", Comprador=" + Comprador
				+ ", CompradorId=" + CompradorId + ", AprovacaoId=" + AprovacaoId + ", AprovacaoPresidente="
				+ AprovacaoPresidente + ", CentroCusto=" + CentroCusto + ", Fornecedor=" + Fornecedor + ", ValorTotal="
				+ ValorTotal + ", DataAprovacaoPresidente=" + DataAprovacaoPresidente + ", AprovacaoTesoureiro="
				+ AprovacaoTesoureiro + ", DataAprovacaoTesoureiro=" + DataAprovacaoTesoureiro
				+ ", AprovacaoEngenheiro=" + AprovacaoEngenheiro + ", DataAprovacaoEngenheiro="
				+ DataAprovacaoEngenheiro + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AprovacaoEngenheiro == null) ? 0 : AprovacaoEngenheiro.hashCode());
		result = prime * result + ((AprovacaoId == null) ? 0 : AprovacaoId.hashCode());
		result = prime * result + ((AprovacaoPresidente == null) ? 0 : AprovacaoPresidente.hashCode());
		result = prime * result + ((AprovacaoTesoureiro == null) ? 0 : AprovacaoTesoureiro.hashCode());
		result = prime * result + ((CentroCusto == null) ? 0 : CentroCusto.hashCode());
		result = prime * result + ((CompraId == null) ? 0 : CompraId.hashCode());
		result = prime * result + ((Comprador == null) ? 0 : Comprador.hashCode());
		result = prime * result + ((CompradorId == null) ? 0 : CompradorId.hashCode());
		result = prime * result + ((Comum == null) ? 0 : Comum.hashCode());
		result = prime * result + ((DataAbertura == null) ? 0 : DataAbertura.hashCode());
		result = prime * result + ((DataAprovacaoEngenheiro == null) ? 0 : DataAprovacaoEngenheiro.hashCode());
		result = prime * result + ((DataAprovacaoPresidente == null) ? 0 : DataAprovacaoPresidente.hashCode());
		result = prime * result + ((DataAprovacaoTesoureiro == null) ? 0 : DataAprovacaoTesoureiro.hashCode());
		result = prime * result + ((DataEntrega == null) ? 0 : DataEntrega.hashCode());
		result = prime * result + ((Descricao == null) ? 0 : Descricao.hashCode());
		result = prime * result + ((EmailSolicitante == null) ? 0 : EmailSolicitante.hashCode());
		result = prime * result + ((EnderecoEntrega == null) ? 0 : EnderecoEntrega.hashCode());
		result = prime * result + ((Fornecedor == null) ? 0 : Fornecedor.hashCode());
		result = prime * result + ((HoraEntrega == null) ? 0 : HoraEntrega.hashCode());
		result = prime * result + ((Pessoa == null) ? 0 : Pessoa.hashCode());
		result = prime * result + ((Solicitante == null) ? 0 : Solicitante.hashCode());
		result = prime * result + ((Status == null) ? 0 : Status.hashCode());
		result = prime * result + ((Telefone == null) ? 0 : Telefone.hashCode());
		result = prime * result + ((ValorTotal == null) ? 0 : ValorTotal.hashCode());
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
		result = prime * result + ((compraItem == null) ? 0 : compraItem.hashCode());
		result = prime * result + ((pagamento == null) ? 0 : pagamento.hashCode());
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
		Compra other = (Compra) obj;
		if (AprovacaoEngenheiro == null) {
			if (other.AprovacaoEngenheiro != null)
				return false;
		} else if (!AprovacaoEngenheiro.equals(other.AprovacaoEngenheiro))
			return false;
		if (AprovacaoId == null) {
			if (other.AprovacaoId != null)
				return false;
		} else if (!AprovacaoId.equals(other.AprovacaoId))
			return false;
		if (AprovacaoPresidente == null) {
			if (other.AprovacaoPresidente != null)
				return false;
		} else if (!AprovacaoPresidente.equals(other.AprovacaoPresidente))
			return false;
		if (AprovacaoTesoureiro == null) {
			if (other.AprovacaoTesoureiro != null)
				return false;
		} else if (!AprovacaoTesoureiro.equals(other.AprovacaoTesoureiro))
			return false;
		if (CentroCusto == null) {
			if (other.CentroCusto != null)
				return false;
		} else if (!CentroCusto.equals(other.CentroCusto))
			return false;
		if (CompraId == null) {
			if (other.CompraId != null)
				return false;
		} else if (!CompraId.equals(other.CompraId))
			return false;
		if (Comprador == null) {
			if (other.Comprador != null)
				return false;
		} else if (!Comprador.equals(other.Comprador))
			return false;
		if (CompradorId == null) {
			if (other.CompradorId != null)
				return false;
		} else if (!CompradorId.equals(other.CompradorId))
			return false;
		if (Comum == null) {
			if (other.Comum != null)
				return false;
		} else if (!Comum.equals(other.Comum))
			return false;
		if (DataAbertura == null) {
			if (other.DataAbertura != null)
				return false;
		} else if (!DataAbertura.equals(other.DataAbertura))
			return false;
		if (DataAprovacaoEngenheiro == null) {
			if (other.DataAprovacaoEngenheiro != null)
				return false;
		} else if (!DataAprovacaoEngenheiro.equals(other.DataAprovacaoEngenheiro))
			return false;
		if (DataAprovacaoPresidente == null) {
			if (other.DataAprovacaoPresidente != null)
				return false;
		} else if (!DataAprovacaoPresidente.equals(other.DataAprovacaoPresidente))
			return false;
		if (DataAprovacaoTesoureiro == null) {
			if (other.DataAprovacaoTesoureiro != null)
				return false;
		} else if (!DataAprovacaoTesoureiro.equals(other.DataAprovacaoTesoureiro))
			return false;
		if (DataEntrega == null) {
			if (other.DataEntrega != null)
				return false;
		} else if (!DataEntrega.equals(other.DataEntrega))
			return false;
		if (Descricao == null) {
			if (other.Descricao != null)
				return false;
		} else if (!Descricao.equals(other.Descricao))
			return false;
		if (EmailSolicitante == null) {
			if (other.EmailSolicitante != null)
				return false;
		} else if (!EmailSolicitante.equals(other.EmailSolicitante))
			return false;
		if (EnderecoEntrega == null) {
			if (other.EnderecoEntrega != null)
				return false;
		} else if (!EnderecoEntrega.equals(other.EnderecoEntrega))
			return false;
		if (Fornecedor == null) {
			if (other.Fornecedor != null)
				return false;
		} else if (!Fornecedor.equals(other.Fornecedor))
			return false;
		if (HoraEntrega == null) {
			if (other.HoraEntrega != null)
				return false;
		} else if (!HoraEntrega.equals(other.HoraEntrega))
			return false;
		if (Pessoa == null) {
			if (other.Pessoa != null)
				return false;
		} else if (!Pessoa.equals(other.Pessoa))
			return false;
		if (Solicitante == null) {
			if (other.Solicitante != null)
				return false;
		} else if (!Solicitante.equals(other.Solicitante))
			return false;
		if (Status == null) {
			if (other.Status != null)
				return false;
		} else if (!Status.equals(other.Status))
			return false;
		if (Telefone == null) {
			if (other.Telefone != null)
				return false;
		} else if (!Telefone.equals(other.Telefone))
			return false;
		if (ValorTotal == null) {
			if (other.ValorTotal != null)
				return false;
		} else if (!ValorTotal.equals(other.ValorTotal))
			return false;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (compraItem == null) {
			if (other.compraItem != null)
				return false;
		} else if (!compraItem.equals(other.compraItem))
			return false;
		if (pagamento == null) {
			if (other.pagamento != null)
				return false;
		} else if (!pagamento.equals(other.pagamento))
			return false;
		return true;
	}
}

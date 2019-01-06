package br.com.tarefas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CompraItem {
	
	@Id
	@GeneratedValue
	private Long CompraItemId;
	
	@ManyToOne
	@JoinColumn(name = "compraId")
	private Compra compra;
	
	@ManyToOne
	@JoinColumn(name = "manutencaoId")
	private Manutencao manutencao;
	
	private String Fornecedor;
	private String MarcaModelo;
	private Integer Quantidade;
	private String Descricao;
	private Float ValorUnidade;
	private Float ValorTotal;
	
	public Manutencao getManutencao() {
		return manutencao;
	}
	public void setManutencao(Manutencao manutencao) {
		this.manutencao = manutencao;
	}
	
	public Long getCompraItemId() {
		return CompraItemId;
	}
	public void setCompraItemId(Long compraItemId) {
		CompraItemId = compraItemId;
	}
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	public String getFornecedor() {
		return Fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		Fornecedor = fornecedor;
	}
	public String getMarcaModelo() {
		return MarcaModelo;
	}
	public void setMarcaModelo(String marcaModelo) {
		MarcaModelo = marcaModelo;
	}
	public Integer getQuantidade() {
		return Quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		Quantidade = quantidade;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public Float getValorUnidade() {
		return ValorUnidade;
	}
	public void setValorUnidade(Float valorUnidade) {
		ValorUnidade = valorUnidade;
	}
	public Float getValorTotal() {
		return ValorTotal;
	}
	public void setValorTotal(Float valorTotal) {
		ValorTotal = valorTotal;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CompraItemId == null) ? 0 : CompraItemId.hashCode());
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
		CompraItem other = (CompraItem) obj;
		if (CompraItemId == null) {
			if (other.CompraItemId != null)
				return false;
		} else if (!CompraItemId.equals(other.CompraItemId))
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
		return "CompraItem [CompraItemId=" + CompraItemId + ", compra=" + compra + ", Fornecedor=" + Fornecedor
				+ ", MarcaModelo=" + MarcaModelo + ", Quantidade=" + Quantidade + ", Descricao=" + Descricao
				+ ", ValorUnidade=" + ValorUnidade + ", ValorTotal=" + ValorTotal + "]";
	}
	
	

}

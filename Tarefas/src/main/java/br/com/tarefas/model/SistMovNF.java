package br.com.tarefas.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class SistMovNF {
	
	@Id
	@GeneratedValue
	private Long SistMovNFId;
	@NotNull @Size(min=11)
	private String NumeroDigitado;
	private String ProvLnc;
	private String DespLnc;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar Pgto;
	private Float ValorPgto;
	private String Documento;
	private String Autenticacao;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar VencBoleto;
	private Float ValorBoleto;
	private String Empresa;
	private String NfCf;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar DataNfCf;
	private Float ValorNfCf;
	private String Sintegra;
	private String Pedido;
	private String Local;
	private String Observacao;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar DataCadastro;
	
	public Long getSistMovNFId() {
		return SistMovNFId;
	}
	public void setSistMovNFId(Long sistMovNFId) {
		SistMovNFId = sistMovNFId;
	}
	public String getNumeroDigitado() {
		return NumeroDigitado;
	}
	public void setNumeroDigitado(String numeroDigitado) {
		NumeroDigitado = numeroDigitado;
	}
	public String getProvLnc() {
		return ProvLnc;
	}
	public void setProvLnc(String provLnc) {
		ProvLnc = provLnc;
	}
	public String getDespLnc() {
		return DespLnc;
	}
	public void setDespLnc(String despLnc) {
		DespLnc = despLnc;
	}
	public Calendar getPgto() {
		return Pgto;
	}
	public void setPgto(Calendar pgto) {
		Pgto = pgto;
	}
	public Float getValorPgto() {
		return ValorPgto;
	}
	public void setValorPgto(Float valorPgto) {
		ValorPgto = valorPgto;
	}
	public String getDocumento() {
		return Documento;
	}
	public void setDocumento(String documento) {
		Documento = documento;
	}
	public String getAutenticacao() {
		return Autenticacao;
	}
	public void setAutenticacao(String autenticacao) {
		Autenticacao = autenticacao;
	}
	public Calendar getVencBoleto() {
		return VencBoleto;
	}
	public void setVencBoleto(Calendar vencBoleto) {
		VencBoleto = vencBoleto;
	}
	public Float getValorBoleto() {
		return ValorBoleto;
	}
	public void setValorBoleto(Float valorBoleto) {
		ValorBoleto = valorBoleto;
	}
	public String getEmpresa() {
		return Empresa;
	}
	public void setEmpresa(String empresa) {
		Empresa = empresa;
	}
	public String getNfCf() {
		return NfCf;
	}
	public void setNfCf(String nfCf) {
		NfCf = nfCf;
	}
	public Calendar getDataNfCf() {
		return DataNfCf;
	}
	public void setDataNfCf(Calendar dataNfCf) {
		DataNfCf = dataNfCf;
	}
	public Float getValorNfCf() {
		return ValorNfCf;
	}
	public void setValorNfCf(Float valorNfCf) {
		ValorNfCf = valorNfCf;
	}
	public String getSintegra() {
		return Sintegra;
	}
	public void setSintegra(String sintegra) {
		Sintegra = sintegra;
	}
	public String getPedido() {
		return Pedido;
	}
	public void setPedido(String pedido) {
		Pedido = pedido;
	}
	public String getLocal() {
		return Local;
	}
	public void setLocal(String local) {
		Local = local;
	}
	public String getObservacao() {
		return Observacao;
	}
	public void setObservacao(String observacao) {
		Observacao = observacao;
	}
	public Calendar getDataCadastro() {
		return DataCadastro;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		DataCadastro = dataCadastro;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((NumeroDigitado == null) ? 0 : NumeroDigitado.hashCode());
		result = prime * result + ((SistMovNFId == null) ? 0 : SistMovNFId.hashCode());
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
		SistMovNF other = (SistMovNF) obj;
		if (NumeroDigitado == null) {
			if (other.NumeroDigitado != null)
				return false;
		} else if (!NumeroDigitado.equals(other.NumeroDigitado))
			return false;
		if (SistMovNFId == null) {
			if (other.SistMovNFId != null)
				return false;
		} else if (!SistMovNFId.equals(other.SistMovNFId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SistMovNF [SistMovNFId=" + SistMovNFId + ", NumeroDigitado=" + NumeroDigitado + ", ProvLnc=" + ProvLnc
				+ ", DespLnc=" + DespLnc + ", Pgto=" + Pgto + ", ValorPgto=" + ValorPgto + ", Documento=" + Documento
				+ ", Autenticacao=" + Autenticacao + ", VencBoleto=" + VencBoleto + ", ValorBoleto=" + ValorBoleto
				+ ", Empresa=" + Empresa + ", NfCf=" + NfCf + ", DataNfCf=" + DataNfCf + ", ValorNfCf=" + ValorNfCf
				+ ", Sintegra=" + Sintegra + ", Pedido=" + Pedido + ", Local=" + Local + ", Observacao=" + Observacao
				+ ", DataCadastro=" + DataCadastro + "]";
	}
	
	
	

}
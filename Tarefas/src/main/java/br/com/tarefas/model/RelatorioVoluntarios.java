package br.com.tarefas.model;

import java.util.Calendar;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

public class RelatorioVoluntarios {
	
	private Long RelatorioVoluntarios;
	private String TipoRelatorio;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar DataInicial;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Calendar DataFinal;
	private String Comum;
	
	public Long getRelatorioVoluntarios() {
		return RelatorioVoluntarios;
	}
	public void setRelatorioVoluntarios(Long relatorioVoluntarios) {
		RelatorioVoluntarios = relatorioVoluntarios;
	}
	public String getTipoRelatorio() {
		return TipoRelatorio;
	}
	public void setTipoRelatorio(String tipoRelatorio) {
		TipoRelatorio = tipoRelatorio;
	}
	public Calendar getDataInicial() {
		return DataInicial;
	}
	public void setDataInicial(Calendar dataInicial) {
		DataInicial = dataInicial;
	}
	public Calendar getDataFinal() {
		return DataFinal;
	}
	public void setDataFinal(Calendar dataFinal) {
		DataFinal = dataFinal;
	}
	
	public String getComum() {
		return Comum;
	}
	public void setComum(String comum) {
		Comum = comum;
	}
	@Override
	public String toString() {
		return "RelatorioVoluntarios [RelatorioVoluntarios=" + RelatorioVoluntarios + ", TipoRelatorio=" + TipoRelatorio
				+ ", DataInicial=" + DataInicial + ", DataFinal=" + DataFinal + ", Comum=" + Comum + "]";
	}
	
	

}

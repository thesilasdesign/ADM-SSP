package br.com.tarefas.dao;

import java.util.List;

import br.com.tarefas.model.SeguroTrabalho;

public interface SeguroTrabalhoDao extends GenericDao<SeguroTrabalho, Long> {

	public List<SeguroTrabalho> GeraRelatorio(String dataIni, String dataFim, String comum);

}

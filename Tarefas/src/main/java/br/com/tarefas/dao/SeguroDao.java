package br.com.tarefas.dao;

import java.util.Date;
import java.util.List;

import br.com.tarefas.model.Seguro;

public interface SeguroDao extends GenericDao<Seguro, Long> {

	public List<Seguro> findByPeriodo(Date inicio, Date fim);
	
	public List<String> BuscaVoluntario(String comum);
	
	public List<Seguro> ListaMinisterio();
	
	public Seguro BuscaCpf(String cpf);
	
}

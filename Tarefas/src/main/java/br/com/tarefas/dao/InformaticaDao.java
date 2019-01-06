package br.com.tarefas.dao;

import java.util.List;

import br.com.tarefas.model.Informatica;
import br.com.tarefas.model.SistMovNF;

public interface InformaticaDao extends GenericDao<Informatica, Long> {
	
	public List<Informatica> ChamadosDoUsuario(String email);
	
	public List<Informatica> ChamadosAbertos();
	
	public List<Informatica> ChamadosEmAtendimento(String nomeAtendente);
	
	public List<SistMovNF> BuscaDados(String Search);
	
}

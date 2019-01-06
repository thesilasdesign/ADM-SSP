package br.com.tarefas.dao;

import br.com.tarefas.model.Tarefa;

public interface TarefaDao extends GenericDao<Tarefa, Long> {
	public void finalizar(Long id);
}

package br.com.tarefas.service;

import java.util.List;

import br.com.tarefas.model.Tarefa;

public interface TarefaService {

	Tarefa buscaPorId(Long id);

	List<Tarefa> lista();

	void adiciona(Tarefa t);

	void altera(Tarefa t);

	void remove(Tarefa t);

	void finaliza(Long id);

}

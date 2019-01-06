package br.com.tarefas.service;

import java.util.List;

import br.com.tarefas.model.Igreja;

public interface IgrejaService {

	Igreja buscaPorId(Long id);

	List<Igreja> lista();

	void adiciona(Igreja t);

	void altera(Igreja t);

	void remove(Long id);
}

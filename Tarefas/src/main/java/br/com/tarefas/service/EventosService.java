package br.com.tarefas.service;

import java.util.List;

import br.com.tarefas.model.Eventos;


public interface EventosService {

	Eventos buscaPorId(Long id);

	List<Eventos> lista();

	void adiciona(Eventos t);

	void removeById(Long id);

}

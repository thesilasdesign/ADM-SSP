package br.com.tarefas.service;

import java.util.List;

import br.com.tarefas.model.Ministerio;

public interface MinisterioService {
	
	Ministerio buscaPorId(Long id);

	List<Ministerio> lista();

	void adiciona(Ministerio t);

	void removeById(Long id);
	
}

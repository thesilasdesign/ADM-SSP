package br.com.tarefas.service;

import java.util.List;

import br.com.tarefas.model.Instrutor;

public interface InstrutorService {
	
	Instrutor buscaPorId(Long id);

	List<Instrutor> lista();

	void adiciona(Instrutor t);

	void removeById(Long id);
	
}

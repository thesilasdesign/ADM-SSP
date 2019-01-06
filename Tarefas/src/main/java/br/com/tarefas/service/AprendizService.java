package br.com.tarefas.service;

import java.util.List;

import br.com.tarefas.model.Aprendiz;

public interface AprendizService {
	
	Aprendiz buscaPorId(Long id);

	List<Aprendiz> lista();

	void adiciona(Aprendiz t);

	void removeById(Long id);
	
}

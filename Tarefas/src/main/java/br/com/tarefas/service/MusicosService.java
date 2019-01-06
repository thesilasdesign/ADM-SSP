package br.com.tarefas.service;

import java.util.List;

import br.com.tarefas.model.Musicos;

public interface MusicosService {
	
	Musicos buscaPorId(Long id);

	List<Musicos> lista();

	void adiciona(Musicos t);

	void removeById(Long id);
	
}

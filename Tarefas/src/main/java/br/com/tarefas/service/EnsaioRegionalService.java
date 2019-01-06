package br.com.tarefas.service;

import java.util.List;

import br.com.tarefas.model.EnsaioRegional;

public interface EnsaioRegionalService {
	
	EnsaioRegional buscaPorId(Long id);

	List<EnsaioRegional> lista();

	void adiciona(EnsaioRegional t);

	void removeById(Long id);
	
}

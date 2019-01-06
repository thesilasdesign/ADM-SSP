package br.com.tarefas.service;

import java.util.List;

import br.com.tarefas.model.SistMovNF;

public interface SistMovNFService {
	
	SistMovNF buscaPorId(Long id);

	List<SistMovNF> lista();
	
	void adiciona(SistMovNF t);
	
	void atualiza(SistMovNF t);

	void removeById(Long id);
	
}

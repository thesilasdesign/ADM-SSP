package br.com.tarefas.service;

import java.util.List;

import br.com.tarefas.model.SantaCeia;

public interface SantaCeiaService {
	
	SantaCeia buscaPorId(Long id);

	List<SantaCeia> lista();

	void adiciona(SantaCeia t);

	void removeById(Long id);
	
	String Somatoria();
	
}

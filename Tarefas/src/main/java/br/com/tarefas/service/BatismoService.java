package br.com.tarefas.service;

import java.util.List;

import br.com.tarefas.model.Batismo;

public interface BatismoService {
	
	Batismo buscaPorId(Long id);

	List<Batismo> lista();

	void adiciona(Batismo t);

	void removeById(Long id);
	
	String Somatoria();

}

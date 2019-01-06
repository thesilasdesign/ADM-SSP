package br.com.tarefas.service;

import java.util.List;

import br.com.tarefas.model.Agenda;

public interface AgendaService {
	
	Agenda buscaPorId(Long id);

	List<Agenda> lista();

	void adiciona(Agenda t);

	void removeById(Long id);
	
	void atualiza(Agenda t);
	
}

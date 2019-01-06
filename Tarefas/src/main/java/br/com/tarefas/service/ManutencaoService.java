package br.com.tarefas.service;

import java.util.List;

import br.com.tarefas.model.Manutencao;

public interface ManutencaoService {
	
	Manutencao buscaPorId(Long id);

	List<Manutencao> lista();

	void adiciona(Manutencao t);

	void removeById(Long id);
	
	void atualiza(Manutencao t);
	
	Manutencao adicionaId(Manutencao t);
	
}

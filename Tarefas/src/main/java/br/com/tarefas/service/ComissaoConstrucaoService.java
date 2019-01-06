package br.com.tarefas.service;

import java.util.List;

import br.com.tarefas.model.ComissaoConstrucao;

public interface ComissaoConstrucaoService {
	
	ComissaoConstrucao buscaPorId(Long id);

	List<ComissaoConstrucao> lista();

	void adiciona(ComissaoConstrucao t);

	void removeById(Long id);
	
	void atualiza(ComissaoConstrucao t);
	
}

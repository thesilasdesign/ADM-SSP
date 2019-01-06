package br.com.tarefas.service;

import java.util.List;

import br.com.tarefas.model.Pagamento;

public interface PagamentoService {
	
	Pagamento buscaPorId(Long id);

	List<Pagamento> lista();

	void adiciona(Pagamento t);

	void removeById(Long id);
	
	void atualiza(Pagamento t);
	
}

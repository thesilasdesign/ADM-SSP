package br.com.tarefas.service;

import java.util.List;

import br.com.tarefas.model.Compra;
import br.com.tarefas.model.CompraItem;

public interface CompraItemService {
	
	CompraItem buscaPorId(Long id);

	List<CompraItem> lista();

	void adiciona(CompraItem t);
	
	CompraItem adicionaId(CompraItem t);

	void removeById(Long id);
	
	void atualiza(CompraItem t);
	
	List<CompraItem> ListItens(Compra compra);
	
	List<CompraItem> ListItensTeste(Long compraId);
	
	List<CompraItem> ValorSoma(Compra compra);
	
	List<CompraItem> valores();
	
	List<Double> ValorSomaTotal(Compra compra);
	
}

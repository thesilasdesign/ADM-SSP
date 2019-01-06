package br.com.tarefas.dao;

import java.util.List;

import br.com.tarefas.model.Compra;
import br.com.tarefas.model.CompraItem;

public interface CompraItemDao extends GenericDao<CompraItem, Long> {
	
	public List<CompraItem> ListItens(Compra compra);
	public List<CompraItem> ListItensTeste(Long compraId);
	public List<CompraItem> ValorSoma(Compra compra);
	public List<Double> ValorSomaTotal(Compra compra);
	public List<CompraItem> valores();
}

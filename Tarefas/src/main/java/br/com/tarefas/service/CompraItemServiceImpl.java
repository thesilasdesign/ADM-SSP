package br.com.tarefas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.dao.CompraItemDao;
import br.com.tarefas.model.Compra;
import br.com.tarefas.model.CompraItem;

@Service("compraItemService")
@Transactional
public class CompraItemServiceImpl implements CompraItemService{
	
	@Autowired
	private CompraItemDao dao;

	@Override
	public CompraItem buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<CompraItem> lista() {
		return dao.findAll();
	}

	@Override
	public void adiciona(CompraItem t) {
		dao.save(t);
	}

	@Override
	public CompraItem adicionaId(CompraItem t) {
		return dao.save(t);
	}

	@Override
	public void removeById(Long id) {
		dao.deleteById(id);
	}

	@Override
	public List<CompraItem> ListItens(Compra compra) {
		return dao.ListItens(compra);
	}

	@Override
	public void atualiza(CompraItem t) {
		dao.update(t);
	}

	@Override
	public List<CompraItem> ListItensTeste(Long compraId) {
		return dao.ListItensTeste(compraId);
	}

	@Override
	public List<CompraItem> ValorSoma(Compra compra) {
		return dao.ValorSoma(compra);
	}

	@Override
	public List<CompraItem> valores() {
		return dao.valores();
	}

	@Override
	public List<Double> ValorSomaTotal(Compra compra) {
		return dao.ValorSomaTotal(compra);
	}

}

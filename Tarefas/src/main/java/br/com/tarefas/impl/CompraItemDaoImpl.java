package br.com.tarefas.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.tarefas.config.Conversoes;
import br.com.tarefas.dao.CompraItemDao;
import br.com.tarefas.model.Compra;
import br.com.tarefas.model.CompraItem;

@Repository
public class CompraItemDaoImpl extends GenericDaoImpl<CompraItem, Long> implements CompraItemDao {

	@PersistenceContext
	private EntityManager manager;

	Conversoes c = new Conversoes();

	@SuppressWarnings("unchecked")
	@Override
	public List<CompraItem> ListItens(Compra compra) {
		List<CompraItem> list = new ArrayList<>();
		try {
			list = manager.createNativeQuery("SELECT * FROM CompraItem where compraId = " + compra.getCompraId())
					.getResultList();

		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<CompraItem> ListItensTeste(Long compraId) {
		List<CompraItem> list = new ArrayList<>();
		Query query = manager.createQuery("FROM CompraItem u WHERE u.Compra.CompraId=:id");
		query.setParameter("id", compraId);
		list = query.getResultList();

		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CompraItem> ValorSoma(Compra compra) {
		List<CompraItem> list = new ArrayList<>();
		try {
			list = manager.createNativeQuery("SELECT SUM(ValorTotal) AS 'VALOR_TOTAL' FROM compraitem where CompraId = " + compra.getCompraId())
					.getResultList();

		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CompraItem> valores() {
		List<CompraItem> list = new ArrayList<>();
		try {
			list = manager.createNativeQuery("SELECT CompraId, SUM(ValorTotal) AS 'VALOR_TOTAL' FROM compraitem  GROUP BY CompraId;").getResultList();

		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Double> ValorSomaTotal(Compra compra) {
		List<Double> list = new ArrayList<>();
		try {
			list = manager.createNativeQuery("SELECT SUM(ValorTotal) AS 'VALOR_TOTAL' FROM CompraItem where CompraId = " + compra.getCompraId()).getResultList();

		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return list;
	}

}

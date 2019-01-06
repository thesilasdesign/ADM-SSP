package br.com.tarefas.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.tarefas.dao.CompraDao;
import br.com.tarefas.model.Compra;

@Repository
public class CompraDaoImpl extends GenericDaoImpl<Compra, Long> implements CompraDao {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Compra> Comprador(String compradorId) {

		List<Compra> list = new ArrayList<>();
		try {
			list = manager.createNativeQuery("SELECT * FROM Compra where compradorId = " + "'" + compradorId + "'"
					+ " and Status != '8-FINALIZADO' and Status != '11-TESOURARIA-OK' order by CompraId DESC").getResultList();

		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compra> CompraAbertas() {
		List<Compra> list = new ArrayList<>();
		try {
			// list = manager.createNativeQuery("SELECT * FROM Compra where
			// Status = '1-SOLICITADO'").getResultList();

			// HQL
			Query query = manager.createQuery("FROM Compra c WHERE c.Status=:status ");
			query.setParameter("status", "1-SOLICITADO");
			list = (List<Compra>) query.getResultList();

			if (list.size() > 0)
				return list;

		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compra> AprovacaoPresidente() {
		List<Compra> list = new ArrayList<>();
		try {
			// list = manager.createNativeQuery("SELECT * FROM Compra where
			// Status = '1-SOLICITADO'").getResultList();

			// HQL
			Query query = manager.createQuery("FROM Compra c WHERE c.AprovacaoPresidente=:valor ");
			query.setParameter("valor", "1|");
			list = (List<Compra>) query.getResultList();

			if (list.size() > 0)
				return list;

		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compra> AprovacaoTesoureiro() {
		List<Compra> list = new ArrayList<>();
		try {
			// list = manager.createNativeQuery("SELECT * FROM Compra where
			// Status = '1-SOLICITADO'").getResultList();

			// HQL
			Query query = manager.createQuery("FROM Compra c WHERE c.AprovacaoTesoureiro=:valor ");
			query.setParameter("valor", "1|");
			list = (List<Compra>) query.getResultList();

			if (list.size() > 0)
				return list;

		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compra> AprovacaoEngenheiro() {
		List<Compra> list = new ArrayList<>();
		try {
			// list = manager.createNativeQuery("SELECT * FROM Compra where
			// Status = '1-SOLICITADO'").getResultList();

			// HQL
			Query query = manager.createQuery("FROM Compra c WHERE c.AprovacaoEngenheiro=:valor ");
			query.setParameter("valor", "1|");
			list = (List<Compra>) query.getResultList();

			if (list.size() > 0)
				return list;

		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compra> CompraPorId(Compra compra) {
		List<Compra> list = new ArrayList<>();
		try {
			// list = manager.createNativeQuery("SELECT * FROM Compra where
			// Status = '1-SOLICITADO'").getResultList();

			// HQL
			Query query = manager.createQuery("FROM Compra c WHERE c.CompraId=:valor ");
			query.setParameter("valor", compra.getCompraId());
			list = (List<Compra>) query.getResultList();

			if (list.size() > 0)
				return list;

		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compra> ComprasUsuario(String compradorId) {
		List<Compra> list = new ArrayList<>();
		try {
			// list = manager.createNativeQuery("SELECT * FROM Compra where
			// Status = '1-SOLICITADO'").getResultList();

			// HQL
			Query query = manager.createQuery("FROM Compra c WHERE c.EmailSolicitante=:solicitante ");
			query.setParameter("solicitante", compradorId);
			list = (List<Compra>) query.getResultList();

			if (list.size() > 0)
				return list;

		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compra> AreaAprovacoes(String Usuario) {
		List<Compra> list = new ArrayList<>();
		try {

			Query query = manager.createQuery("FROM Compra ");
			list = (List<Compra>) query.getResultList();

			if (list.size() > 0)
				return list;

		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Compra BuscandoId(Long id) {
		Compra list;
		try {
			// HQL
			Query query = manager.createQuery("FROM Compra c WHERE c.CompraId=:id");
			query.setParameter("id", id);
			list = (Compra) query.getSingleResult();

			return list;

		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compra> PedidosFinalizados() {
		List<Compra> list = new ArrayList<>();
		try {

			Query query = manager.createQuery("FROM Compra c WHERE c.Status='8-FINALIZADO' ");
			list = (List<Compra>) query.getResultList();

			if (list.size() > 0)
				return list;

		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compra> Painel() {
		try {
			Query query = manager.createQuery("FROM Compra E  ORDER BY E.CompraId DESC"); //from Survey p order by p.price asc
			List<Compra> list = (List<Compra>) query.getResultList();

			if (list.size() > 0)
				return list;

		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return null;
	}
}

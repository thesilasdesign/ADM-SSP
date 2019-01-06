package br.com.tarefas.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.tarefas.dao.NotificacaoDao;
import br.com.tarefas.model.Notificacao;

@Repository
public class NotificacaoDaoImpl extends GenericDaoImpl<Notificacao, Long> implements NotificacaoDao  {

	@PersistenceContext
	private EntityManager manager;
	
	@SuppressWarnings("unchecked")
	public List<Notificacao> NotificacaoAbertas() {
		List<Notificacao> list = new ArrayList<>();
		try {

			// HQL
			Query query = manager.createQuery("FROM Notificacao c WHERE c.Campo4=:status ");
			query.setParameter("status", "1");
			list = (List<Notificacao>) query.getResultList();

			if (list.size() > 0)
				return list;

		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return null;
	}
}

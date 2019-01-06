package br.com.tarefas.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.tarefas.dao.InformaticaDao;
import br.com.tarefas.model.Informatica;
import br.com.tarefas.model.SistMovNF;

@Repository
public class InformaticaDaoImpl extends GenericDaoImpl<Informatica, Long> implements InformaticaDao {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Informatica> ChamadosDoUsuario(String email) {

		try {
			// HQL
			Query query = manager
					.createQuery("FROM Informatica u WHERE u.EmailSolicitante=:email AND u.Status=:status");
			query.setParameter("email", email);
			query.setParameter("status", "2-EM ATENDIMENTO");
			List<Informatica> inf = (List<Informatica>) query.getResultList();

			if (inf.size() > 0)
				return inf;
		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Informatica> ChamadosAbertos() {
		try {
			// HQL
			Query query = manager.createQuery("FROM Informatica u WHERE u.Status='1-ABERTO'");
			@SuppressWarnings("unchecked")
			List<Informatica> inf = (List<Informatica>) query.getResultList();

			if (inf.size() > 0)
				return inf;
		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Informatica> ChamadosEmAtendimento(String nomeAtendente) {
		try {
			// HQL
			Query query = manager.createQuery("FROM Informatica u WHERE u.Atendente=:nome");
			query.setParameter("nome", nomeAtendente);
			List<Informatica> inf = (List<Informatica>) query.getResultList();

			if (inf.size() > 0)
				return inf;
		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<SistMovNF> BuscaDados(String Search) {
		return null;
	}

}

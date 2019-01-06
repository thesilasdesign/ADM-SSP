package br.com.tarefas.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.tarefas.dao.SeguroDao;
import br.com.tarefas.model.Seguro;

@Repository
public class SeguroDaoImpl extends GenericDaoImpl<Seguro, Long> implements SeguroDao {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Seguro> findByPeriodo(Date inicio, Date fim) {
		StringBuilder sbQuery = new StringBuilder();

		sbQuery.append("FROM seguro SEGURO");
		sbQuery.append("WHERE data BETWEEN :inicio AND :fim");

		Map<String, Object> map = new HashMap<>();
		map.put("inicio", inicio);
		map.put("fim", fim);

		return findByParameter(sbQuery.toString(), map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> BuscaVoluntario(String comum) {
		String[] a = comum.split("|");
		try {
			Query query = manager
					.createNativeQuery("select SeguroId, Nome from Seguro where comum like " + "'%" + comum + "%'");

			List<String> lista = query.getResultList();

			return lista;

		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Seguro> ListaMinisterio() {
		try {
			List<Seguro> seguro = null;
			Query query = manager.createQuery(
					"FROM Seguro u WHERE u.Ministerio in ('Ancião','Diacono','Presidente Administração','Encarregado Regional','Cooperadores')");

			seguro = (List<Seguro>) query.getResultList();

			return seguro;

		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Seguro BuscaCpf(String cpf) {
		Seguro seguro = null;
		try {
			Query query = manager.createQuery("FROM Seguro u WHERE u.Cpf=:cpf");
			query.setParameter("cpf", cpf);
			seguro = (Seguro) query.getSingleResult();

		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return seguro;
	}

}

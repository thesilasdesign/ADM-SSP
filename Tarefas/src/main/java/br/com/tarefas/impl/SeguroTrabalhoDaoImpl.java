package br.com.tarefas.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import br.com.tarefas.dao.SeguroTrabalhoDao;
import br.com.tarefas.model.SeguroTrabalho;

@Repository
public class SeguroTrabalhoDaoImpl extends GenericDaoImpl<SeguroTrabalho, Long> implements SeguroTrabalhoDao {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<SeguroTrabalho> GeraRelatorio(String dataIni, String dataFim, String comum) {

		String a = dataIni.substring(6, 10) + "-" + dataIni.substring(3, 5) + "-" + dataIni.substring(0, 2);
		String b = dataFim.substring(6, 10) + "-" + dataFim.substring(3, 5) + "-" + dataFim.substring(0, 2);

		// 04 / 10 / 2016
		// 01 2 34 5 6789
		Query query = manager.createQuery("FROM SeguroTrabalho s WHERE s.Comum =:comum AND s.Data BETWEEN " + "'"
				+ a + "'" + " AND " + "'" + b + "'");
		query.setParameter("comum", comum);
		@SuppressWarnings("unchecked")
		List<SeguroTrabalho> list = query.getResultList();
		return list;

	}

}

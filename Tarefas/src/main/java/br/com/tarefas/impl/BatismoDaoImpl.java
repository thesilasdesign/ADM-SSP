package br.com.tarefas.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.tarefas.dao.BatismoDao;
import br.com.tarefas.model.Batismo;

@Repository
public class BatismoDaoImpl extends GenericDaoImpl<Batismo, Long> implements BatismoDao  {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public String Somatoria() {
		try {
			Query query = manager.createNativeQuery("SELECT SUM(QuantidadeTotal) FROM Batismo;");

			String Soma = query.getSingleResult().toString();

			return Soma;
	} catch (Exception e) {
		System.out.println("erro");
		e.printStackTrace();
	}
	return null;
	}

}

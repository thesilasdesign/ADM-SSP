package br.com.tarefas.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.tarefas.dao.SantaCeiaDao;
import br.com.tarefas.model.SantaCeia;

@Repository
public class SantaCeiaDaoImpl extends GenericDaoImpl<SantaCeia, Long> implements SantaCeiaDao  {
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public String Somatoria() {
		try {
			Query query = manager.createNativeQuery("SELECT SUM(Total) FROM SantaCeia;");

			String Soma = query.getSingleResult().toString();

			return Soma;
	} catch (Exception e) {
		System.out.println("erro");
		e.printStackTrace();
	}
	return null;
	}

}

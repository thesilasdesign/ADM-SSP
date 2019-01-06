package br.com.tarefas.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.tarefas.dao.ComentarioDao;
import br.com.tarefas.model.Comentario;
import br.com.tarefas.model.Compra;

@Repository
public class ComentarioDaoImpl extends GenericDaoImpl<Comentario, Long> implements ComentarioDao {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Comentario> CarregaComentarios(Compra compra) {
		@SuppressWarnings("rawtypes")
		List<Comentario> list = new ArrayList();
		try {
			Query query = manager.createNativeQuery("select * from Comentario where compraId=" + compra.getCompraId());

			list = query.getResultList();
			
			if (list.size()>0)
				return list;
		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return null;
	}
}

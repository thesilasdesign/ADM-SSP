package br.com.tarefas.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import br.com.tarefas.dao.GenericDao;

@Transactional(readOnly = true)
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

	@PersistenceContext
	private EntityManager manager;
	// private SessionFactory sessionFactory;

	protected Class<? extends T> daoType;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		daoType = (Class) pt.getActualTypeArguments()[0];
	}

	// protected Session currentSession() {
	// return sessionFactory.getCurrentSession();
	// }

	@Transactional(readOnly = false)
	@Override
	public T save(T entity) {
		try {
			entity = manager.merge(entity);
		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return entity;
	}

	@Override
	public T update(T entity) {
		try {
			entity = manager.merge(entity);
		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		List<T> list = new ArrayList<>();
		try {
			list = manager.createQuery("FROM " + daoType.getSimpleName()).getResultList();
		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public T findById(PK pk) {
		T t = null;
		try {
			t = manager.find(daoType, pk);
		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public void delete(T entity) {
		try {
			manager.remove(entity);
		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(PK pk) {
		try {
			String hql = "delete from " + daoType.getSimpleName() + " where id = :id";
			Query query = manager.createQuery(hql);
			query.setParameter("id", pk);
			int rowCount = query.executeUpdate();
			System.out.println("Rows affected: " + rowCount);

			// T t = findById(pk);
			// manager.remove(t);
		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
	}

	@Override
	public List<T> findByParameter(String queryString, Map<String, Object> object) {
		return findByParameter(queryString, object, null, null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByParameter(String queryString, Map<String, Object> object, Integer firstResult,
			Integer maxResults) {
		List<T> list = new ArrayList<>();
		try {
			Query query = manager.createQuery(queryString);
			for (Entry<String, Object> p : object.entrySet()) {
				query.setParameter(p.getKey(), p.getValue());
			}

			if (firstResult != null && maxResults != null) {
				query.setFirstResult(firstResult);
				query.setMaxResults(maxResults);
			}

			list = query.getResultList();
		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return list;
	}
}

package br.com.tarefas.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface GenericDao<T, PK extends Serializable> {

	public T save(T entity);

	public T update(T entity);

	public List<T> findAll();

	public List<T> findByParameter(String queryString, Map<String, Object> object);

	public List<T> findByParameter(String queryString, Map<String, Object> object, Integer firstResult, Integer maxResults);

	public T findById(PK pk);

	public void delete(T entity);

	public void deleteById(PK pk);

}

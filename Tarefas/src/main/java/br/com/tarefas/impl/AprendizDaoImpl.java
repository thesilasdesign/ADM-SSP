package br.com.tarefas.impl;

import org.springframework.stereotype.Repository;

import br.com.tarefas.dao.AprendizDao;
import br.com.tarefas.model.Aprendiz;

@Repository
public class AprendizDaoImpl extends GenericDaoImpl<Aprendiz, Long> implements AprendizDao  {


}

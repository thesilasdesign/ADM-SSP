package br.com.tarefas.impl;

import org.springframework.stereotype.Repository;

import br.com.tarefas.dao.InstrutorDao;
import br.com.tarefas.model.Instrutor;

@Repository
public class InstrutorDaoImpl extends GenericDaoImpl<Instrutor, Long> implements InstrutorDao  {


}

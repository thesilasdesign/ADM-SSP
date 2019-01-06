package br.com.tarefas.impl;

import org.springframework.stereotype.Repository;

import br.com.tarefas.dao.MinisterioDao;
import br.com.tarefas.model.Ministerio;

@Repository
public class MinisterioDaoImpl extends GenericDaoImpl<Ministerio, Long> implements MinisterioDao  {


}

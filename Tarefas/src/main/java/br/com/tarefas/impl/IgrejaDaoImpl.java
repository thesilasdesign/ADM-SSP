package br.com.tarefas.impl;

import org.springframework.stereotype.Repository;

import br.com.tarefas.dao.IgrejaDao;
import br.com.tarefas.model.Igreja;

@Repository
public class IgrejaDaoImpl extends GenericDaoImpl<Igreja, Long> implements IgrejaDao {

}

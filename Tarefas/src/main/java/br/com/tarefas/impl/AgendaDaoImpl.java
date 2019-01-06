package br.com.tarefas.impl;

import org.springframework.stereotype.Repository;

import br.com.tarefas.dao.AgendaDao;
import br.com.tarefas.model.Agenda;

@Repository
public class AgendaDaoImpl extends GenericDaoImpl<Agenda, Long> implements AgendaDao  {


}

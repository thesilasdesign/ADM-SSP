package br.com.tarefas.impl;

import org.springframework.stereotype.Repository;

import br.com.tarefas.dao.EventosDao;
import br.com.tarefas.model.Eventos;

@Repository
public class EventosDaoImpl extends GenericDaoImpl<Eventos, Long> implements EventosDao  {

}

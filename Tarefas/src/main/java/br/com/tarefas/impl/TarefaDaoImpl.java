package br.com.tarefas.impl;

import java.util.Calendar;

import org.springframework.stereotype.Repository;

import br.com.tarefas.dao.TarefaDao;
import br.com.tarefas.model.Tarefa;

@Repository
public class TarefaDaoImpl extends GenericDaoImpl<Tarefa, Long> implements TarefaDao {

	@Override
	public void finalizar(Long id) {
		Tarefa t = findById(id);

		t.setFinalizado(true);
		t.setDataFinalizacao(Calendar.getInstance());

		update(t);
	}

}

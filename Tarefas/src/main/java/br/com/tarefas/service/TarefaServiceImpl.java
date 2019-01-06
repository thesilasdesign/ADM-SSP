package br.com.tarefas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.dao.TarefaDao;
import br.com.tarefas.model.Tarefa;

@Service("tarefaService")
@Transactional
public class TarefaServiceImpl implements TarefaService {

	@Autowired
	private TarefaDao dao;

	@Override
	public Tarefa buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Tarefa> lista() {
		return dao.findAll();
	}

	@Override
	public void adiciona(Tarefa t) {
		dao.save(t);
	}

	@Override
	public void altera(Tarefa t) {
		dao.update(t);
	}

	@Override
	public void remove(Tarefa t) {
		dao.deleteById(t.getId());
	}

	@Override
	public void finaliza(Long id) {
		dao.finalizar(id);				
	}
}

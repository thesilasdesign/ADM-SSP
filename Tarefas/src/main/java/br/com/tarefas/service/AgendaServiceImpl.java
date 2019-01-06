package br.com.tarefas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.dao.AgendaDao;
import br.com.tarefas.model.Agenda;

@Service("agendaService")
@Transactional
public class AgendaServiceImpl implements AgendaService{

	@Autowired
	private AgendaDao dao;

	@Override
	public Agenda buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Agenda> lista() {
		return dao.findAll();
	}

	@Override
	public void adiciona(Agenda t) {
		dao.save(t);
	}

	@Override
	public void removeById(Long id) {
		dao.deleteById(id);
	}

	@Override
	public void atualiza(Agenda t) {
		dao.save(t);
	}
	
}

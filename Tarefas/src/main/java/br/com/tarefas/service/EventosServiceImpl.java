package br.com.tarefas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.dao.EventosDao;
import br.com.tarefas.model.Eventos;

@Service("eventosService")
@Transactional
public class EventosServiceImpl implements EventosService {

	@Autowired
	private EventosDao dao;
	
	@Override
	public Eventos buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Eventos> lista() {
		return dao.findAll();
	}

	@Override
	public void adiciona(Eventos t) {
		dao.save(t);
	}

	@Override
	public void removeById(Long id) {
		dao.deleteById(id);
		
	}


}

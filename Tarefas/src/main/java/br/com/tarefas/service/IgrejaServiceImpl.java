package br.com.tarefas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.dao.IgrejaDao;
import br.com.tarefas.model.Igreja;

@Service("igrejaService")
@Transactional
public class IgrejaServiceImpl implements IgrejaService{

	@Autowired
	private IgrejaDao dao;
	
	@Override
	public Igreja buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Igreja> lista() {
		return dao.findAll();
	}

	@Override
	public void adiciona(Igreja t) {
		dao.save(t);
	}

	@Override
	public void altera(Igreja t) {
		dao.save(t);
	}

	@Override
	public void remove(Long id) {
		dao.deleteById(id);
	}

}

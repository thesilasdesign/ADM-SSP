package br.com.tarefas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.dao.AprendizDao;
import br.com.tarefas.model.Aprendiz;

@Service("aprendizService")
@Transactional
public class AprendizServiceImpl implements AprendizService{

	@Autowired
	private AprendizDao dao;

	@Override
	public Aprendiz buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Aprendiz> lista() {
		return dao.findAll();
	}

	@Override
	public void adiciona(Aprendiz t) {
		dao.save(t);
	}

	@Override
	public void removeById(Long id) {
		dao.deleteById(id);
	}
	
}

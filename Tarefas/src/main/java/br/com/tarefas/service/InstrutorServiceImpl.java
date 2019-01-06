package br.com.tarefas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.dao.InstrutorDao;
import br.com.tarefas.model.Instrutor;

@Service("instrutorService")
@Transactional
public class InstrutorServiceImpl implements InstrutorService{

	@Autowired
	private InstrutorDao dao;

	@Override
	public Instrutor buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Instrutor> lista() {
		return dao.findAll();
	}

	@Override
	public void adiciona(Instrutor t) {
		dao.save(t);
	}

	@Override
	public void removeById(Long id) {
		dao.deleteById(id);
	}
	
}

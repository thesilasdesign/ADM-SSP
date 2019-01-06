package br.com.tarefas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.dao.MinisterioDao;
import br.com.tarefas.model.Ministerio;

@Service("ministerioService")
@Transactional
public class MinisterioServiceImpl implements MinisterioService{

	@Autowired
	MinisterioDao dao;
	@Override
	public Ministerio buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Ministerio> lista() {
		return dao.findAll();
	}

	@Override
	public void adiciona(Ministerio t) {
		dao.save(t);
	}

	@Override
	public void removeById(Long id) {
		dao.deleteById(id);
	}

}

package br.com.tarefas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.dao.SantaCeiaDao;
import br.com.tarefas.model.SantaCeia;

@Service("santaCeiaService")
@Transactional
public class SantaCeiaServiceImpl implements SantaCeiaService{

	@Autowired
	private SantaCeiaDao dao;

	@Override
	public SantaCeia buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<SantaCeia> lista() {
		return dao.findAll();
	}

	@Override
	public void adiciona(SantaCeia t) {
		dao.save(t);
	}

	@Override
	public void removeById(Long id) {
		dao.deleteById(id);
	}

	@Override
	public String Somatoria() {
		return dao.Somatoria();
	}
	
}

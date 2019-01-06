package br.com.tarefas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.dao.BatismoDao;
import br.com.tarefas.model.Batismo;

@Service("batismoService")
@Transactional
public class BatismoServiceImpl implements BatismoService{

	
	@Autowired
	private BatismoDao dao;
	
	@Override
	public Batismo buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Batismo> lista() {
		return dao.findAll();
	}

	@Override
	public void adiciona(Batismo t) {
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

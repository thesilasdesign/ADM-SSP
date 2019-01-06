package br.com.tarefas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.dao.EnsaioRegionalDao;
import br.com.tarefas.model.EnsaioRegional;;

@Service("ensaioRegionalService")
@Transactional
public class EnsaioRegionalServiceImpl implements EnsaioRegionalService{

	@Autowired
	private EnsaioRegionalDao dao;

	@Override
	public EnsaioRegional buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<EnsaioRegional> lista() {
		return dao.findAll();
	}

	@Override
	public void adiciona(EnsaioRegional t) {
		dao.save(t);
	}

	@Override
	public void removeById(Long id) {
		dao.deleteById(id);
	}
	
}

package br.com.tarefas.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.dao.SistMovNFDao;
import br.com.tarefas.model.SistMovNF;

@Service("sistMovNFService")
@Transactional
public class SistMovNFServiceImpl implements SistMovNFService{

	@Autowired
	SistMovNFDao dao;

	@Override
	public SistMovNF buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<SistMovNF> lista() {
		return dao.findAll();
	}

	@Override
	public void adiciona(SistMovNF t) {
		dao.save(t);
	}

	@Override
	public void removeById(Long id) {
		dao.deleteById(id);
	}

	@Override
	public void atualiza(SistMovNF t) {
		dao.update(t);
	}

}

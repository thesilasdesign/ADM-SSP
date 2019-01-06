package br.com.tarefas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.dao.ManutencaoDao;
import br.com.tarefas.model.CompraItem;
import br.com.tarefas.model.Manutencao;

@Service("manutencaoService")
@Transactional
public class ManutencaoServiceImpl implements ManutencaoService{

	@Autowired
	ManutencaoDao dao;

	@Override
	public Manutencao buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Manutencao> lista() {
		return dao.findAll();
	}

	@Override
	public void adiciona(Manutencao t) {
		dao.save(t);
	}

	@Override
	public void removeById(Long id) {
		dao.deleteById(id);
	}

	@Override
	public void atualiza(Manutencao t) {
		dao.save(t);
	}

	@Override
	public Manutencao adicionaId(Manutencao t) {
		return dao.save(t);
	}
	
	

}

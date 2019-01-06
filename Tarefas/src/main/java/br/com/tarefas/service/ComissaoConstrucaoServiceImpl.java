package br.com.tarefas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.dao.ComissaoConstrucaoDao;
import br.com.tarefas.model.ComissaoConstrucao;

@Service("comissaoConstrucaoService")
@Transactional
public class ComissaoConstrucaoServiceImpl implements ComissaoConstrucaoService{

	@Autowired
	private ComissaoConstrucaoDao dao;

	@Override
	public ComissaoConstrucao buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<ComissaoConstrucao> lista() {
		return dao.findAll();
	}

	@Override
	public void adiciona(ComissaoConstrucao t) {
		dao.save(t);
	}

	@Override
	public void removeById(Long id) {
		dao.deleteById(id);
	}

	@Override
	public void atualiza(ComissaoConstrucao t) {
		dao.save(t);
	}

		
	
}

package br.com.tarefas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.dao.PagamentoDao;
import br.com.tarefas.model.Pagamento;

@Service("pagamentoService")
@Transactional
public class PagamentoServiceImpl implements PagamentoService{

	@Autowired
	private PagamentoDao dao;

	@Override
	public Pagamento buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Pagamento> lista() {
		return dao.findAll();
	}

	@Override
	public void adiciona(Pagamento t) {
		dao.save(t);
	}

	@Override
	public void removeById(Long id) {
		dao.deleteById(id);
	}

	@Override
	public void atualiza(Pagamento t) {
		dao.save(t);
	}


	
}

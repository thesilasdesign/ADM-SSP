package br.com.tarefas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.dao.SeguroTrabalhoDao;
import br.com.tarefas.model.SeguroTrabalho;

@Service("seguroTrabalhoService")
@Transactional
public class SeguroTrabalhoServiceImpl implements SeguroTrabalhoService{

	@Autowired
	SeguroTrabalhoDao dao;

	@Override
	public SeguroTrabalho buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<SeguroTrabalho> lista() {
		return dao.findAll();
	}

	@Override
	public void adiciona(SeguroTrabalho t) {
		dao.save(t);
	}

	@Override
	public void removeById(Long id) {
		dao.deleteById(id);
	}

	@Override
	public List<SeguroTrabalho> GeraRelatorio(String dataIni, String dataFim, String comum) {
		return dao.GeraRelatorio(dataIni, dataFim, comum);
	}


}

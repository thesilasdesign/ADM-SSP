package br.com.tarefas.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.dao.SeguroDao;
import br.com.tarefas.model.Seguro;

@Service("seguroService")
@Transactional
public class SeguroServiceImpl implements SeguroService {

	@Autowired
	SeguroDao dao;

	@Override
	public Seguro buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Seguro> lista() {
		return dao.findAll();
	}

	@Override
	public void adiciona(Seguro t) {
		dao.save(t);
	}

	@Override
	public void removeById(Long id) {
		dao.deleteById(id);
	}

	@Override
	public List<Seguro> listaByPeriodo(Date inicio, Date fim) {
		return dao.findByPeriodo(inicio, fim);				
	}

	@Override
	public List<String> BuscaVoluntario(String comum) {
		return dao.BuscaVoluntario(comum);
	}

	@Override
	public List<Seguro> ListaMinisterio() {
		return dao.ListaMinisterio();
	}

	@Override
	public Seguro BuscaCpf(String cpf) {
		return dao.BuscaCpf(cpf);
	}

}

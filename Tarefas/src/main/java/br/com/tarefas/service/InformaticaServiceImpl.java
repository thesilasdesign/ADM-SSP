package br.com.tarefas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.dao.InformaticaDao;
import br.com.tarefas.model.Informatica;

@Service("informaticaService")
@Transactional
public class InformaticaServiceImpl implements InformaticaService{

	@Autowired
	private InformaticaDao dao;

	@Override
	public Informatica buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Informatica> lista() {
		return dao.findAll();
	}

	@Override
	public void adiciona(Informatica t) {
		dao.save(t);
	}

	@Override
	public void removeById(Long id) {
		dao.deleteById(id);
	}

	@Override
	public void atualiza(Informatica t) {
		dao.update(t);
	}

	@Override
	public List<Informatica> ChamadosDoUsuario(String email) {
		return dao.ChamadosDoUsuario(email);
	}

	@Override
	public List<Informatica> ChamadosAbertos() {
		return dao.ChamadosAbertos();
	}

	@Override
	public List<Informatica> ChamadosEmAtendimento(String nomeAtendente) {
		return dao.ChamadosEmAtendimento(nomeAtendente);
	}

	
}

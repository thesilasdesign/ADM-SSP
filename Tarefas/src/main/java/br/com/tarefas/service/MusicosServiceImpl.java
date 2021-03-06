package br.com.tarefas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.dao.MusicosDao;
import br.com.tarefas.model.Musicos;

@Service("musicosService")
@Transactional
public class MusicosServiceImpl implements MusicosService{

	@Autowired
	private MusicosDao dao;

	@Override
	public Musicos buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Musicos> lista() {
		return dao.findAll();
	}

	@Override
	public void adiciona(Musicos t) {
		dao.save(t);
	}

	@Override
	public void removeById(Long id) {
		dao.deleteById(id);
	}
	
}

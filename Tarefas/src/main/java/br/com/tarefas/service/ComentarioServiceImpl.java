package br.com.tarefas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.dao.ComentarioDao;
import br.com.tarefas.model.Comentario;
import br.com.tarefas.model.Compra;

@Service("comentarioService")
@Transactional
public class ComentarioServiceImpl implements ComentarioService{
	
	@Autowired
	private ComentarioDao dao;

	@Override
	public Comentario buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Comentario> lista() {
		return dao.findAll();
	}

	@Override
	public void adiciona(Comentario t) {
		dao.save(t);
	}

	@Override
	public void removeById(Long id) {
		dao.deleteById(id);
	}

	@Override
	public List<Comentario> CarregaComentarios(Compra compra) {
		return dao.CarregaComentarios(compra);
	}

	
}

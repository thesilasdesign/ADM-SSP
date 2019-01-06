package br.com.tarefas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.dao.NotificacaoDao;
import br.com.tarefas.model.Notificacao;

@Service("notificacaoService")
@Transactional
public class NotificacaoServiceImpl implements NotificacaoService{

	@Autowired
	private NotificacaoDao dao;

	@Override
	public Notificacao buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Notificacao> lista() {
		return dao.findAll();
	}

	@Override
	public void adiciona(Notificacao t) {
		dao.save(t);
	}

	@Override
	public void removeById(Long id) {
		dao.deleteById(id);
	}

	@Override
	public void atualiza(Notificacao t) {
		dao.update(t);
	}

	@Override
	public List<Notificacao> NotificacaoAbertas() {
		return dao.NotificacaoAbertas();
	}
}

	
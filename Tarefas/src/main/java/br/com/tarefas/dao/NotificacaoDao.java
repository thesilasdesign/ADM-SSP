package br.com.tarefas.dao;

import java.util.List;

import br.com.tarefas.model.Notificacao;

public interface NotificacaoDao extends GenericDao<Notificacao, Long> {
	
	public List<Notificacao> NotificacaoAbertas();

}

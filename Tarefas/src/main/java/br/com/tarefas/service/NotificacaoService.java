package br.com.tarefas.service;

import java.util.List;

import br.com.tarefas.model.Notificacao;

public interface NotificacaoService {
	
	Notificacao buscaPorId(Long id);

	List<Notificacao> lista();

	void adiciona(Notificacao t);

	void removeById(Long id);
	
	void atualiza(Notificacao t);
	
	List<Notificacao> NotificacaoAbertas();
	
}

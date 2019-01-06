package br.com.tarefas.service;

import java.util.List;

import br.com.tarefas.model.Informatica;

public interface InformaticaService {
	
	Informatica buscaPorId(Long id);

	List<Informatica> lista();

	void adiciona(Informatica t);

	void removeById(Long id);
	
	void atualiza(Informatica t);
	
	List<Informatica> ChamadosDoUsuario(String email);
	
	List<Informatica> ChamadosAbertos();
	
	List<Informatica> ChamadosEmAtendimento(String nomeAtendente);
	
}

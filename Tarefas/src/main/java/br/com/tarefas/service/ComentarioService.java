package br.com.tarefas.service;

import java.util.List;

import br.com.tarefas.model.Comentario;
import br.com.tarefas.model.Compra;

public interface ComentarioService {
	
	Comentario buscaPorId(Long id);

	List<Comentario> lista();

	void adiciona(Comentario t);

	void removeById(Long id);
	
	List<Comentario> CarregaComentarios(Compra compra);
}

package br.com.tarefas.dao;


import java.util.List;

import br.com.tarefas.model.Comentario;
import br.com.tarefas.model.Compra;

public interface ComentarioDao extends GenericDao<Comentario, Long> {
	
	public List<Comentario> CarregaComentarios(Compra compra);
}

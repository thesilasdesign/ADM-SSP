package br.com.tarefas.service;

import java.util.Date;
import java.util.List;

import br.com.tarefas.model.Seguro;

public interface SeguroService {
	
	Seguro buscaPorId(Long id);

	List<Seguro> lista();

	void adiciona(Seguro t);

	void removeById(Long id);

	List<Seguro> listaByPeriodo(Date inicio, Date fim);
	
	List<String> BuscaVoluntario(String comum);
	
	List<Seguro> ListaMinisterio();
	
	Seguro BuscaCpf(String cpf); 
	
	
}

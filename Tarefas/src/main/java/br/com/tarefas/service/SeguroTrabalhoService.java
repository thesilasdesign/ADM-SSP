package br.com.tarefas.service;

import java.util.List;

import br.com.tarefas.model.SeguroTrabalho;

public interface SeguroTrabalhoService {
	
	SeguroTrabalho buscaPorId(Long id);

	List<SeguroTrabalho> lista();

	void adiciona(SeguroTrabalho t);

	void removeById(Long id);

	List<SeguroTrabalho> GeraRelatorio(String dataIni, String dataFim, String comum);
}

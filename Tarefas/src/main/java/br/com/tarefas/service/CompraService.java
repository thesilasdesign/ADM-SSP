package br.com.tarefas.service;

import java.util.List;

import br.com.tarefas.model.Compra;

public interface CompraService {
	
	Compra buscaPorId(Long id);

	List<Compra> lista();

	void adiciona(Compra t);
	
	void atualiza(Compra t);
	
	Compra adicionaId(Compra t);

	void removeById(Long id);
	
	List<Compra> Comprador(String compradorId);
	
	List<Compra> CompraAbertas();
	
	List<Compra> AprovacaoPresidente();
	
	List<Compra> AprovacaoTesoureiro();
	
	List<Compra> AprovacaoEngenheiro();
	
	List<Compra> CompraPorId(Compra compra);
	
	List<Compra> ComprasUsuario(String compradorId);
	
	List<Compra> AreaAprovacoes(String Usuario);
	
	List<Compra> PedidosFinalizados();
	
	Compra BuscandoId(Long id);
	List<Compra> Painel();
	
}

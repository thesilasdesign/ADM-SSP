package br.com.tarefas.dao;

import java.util.List;

import br.com.tarefas.model.Compra;

public interface CompraDao extends GenericDao<Compra, Long> {
	
	public List<Compra> Comprador(String compradorId);
	public Compra BuscandoId(Long id);
	public List<Compra> ComprasUsuario(String compradorId);
	public List<Compra> CompraPorId(Compra compra);
	public List<Compra> CompraAbertas();
	public List<Compra> AprovacaoPresidente();
	public List<Compra> AprovacaoTesoureiro();
	public List<Compra> AprovacaoEngenheiro();
	public List<Compra> PedidosFinalizados();
	public List<Compra> AreaAprovacoes(String Usuario);
	public List<Compra> Painel();
}

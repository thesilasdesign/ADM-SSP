package br.com.tarefas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.dao.CompraDao;
import br.com.tarefas.model.Compra;

@Service("compraService")
@Transactional
public class CompraServiceImpl implements CompraService{

	
	@Autowired
	private CompraDao dao;

	@Override
	public Compra buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Compra> lista() {
		return dao.findAll();
	}

	@Override
	public void adiciona(Compra t) {
		dao.save(t);
	}

	@Override
	public void removeById(Long id) {
		dao.deleteById(id);
	}

	@Override
	public Compra adicionaId(Compra t) {
		return dao.save(t);
	}

	@Override
	public void atualiza(Compra t) {
		dao.save(t);
	}

	@Override
	public List<Compra> Comprador(String compradorId) {
		return dao.Comprador(compradorId);
	}

	@Override
	public List<Compra> CompraAbertas() {
		return dao.CompraAbertas();
	}

	@Override
	public List<Compra> AprovacaoPresidente() {
		return dao.AprovacaoPresidente();
	}

	@Override
	public List<Compra> AprovacaoTesoureiro() {
		return dao.AprovacaoTesoureiro();
	}

	@Override
	public List<Compra> AprovacaoEngenheiro() {
		return dao.AprovacaoEngenheiro();
	}

	@Override
	public List<Compra> CompraPorId(Compra compra) {
		return dao.CompraPorId(compra);
	}

	@Override
	public List<Compra> ComprasUsuario(String compradorId) {
		return dao.ComprasUsuario(compradorId);
	}

	@Override
	public List<Compra> AreaAprovacoes(String Usuario) {
		return dao.AreaAprovacoes(Usuario);
	}

	@Override
	public Compra BuscandoId(Long id) {
		return dao.BuscandoId(id);
	}

	@Override
	public List<Compra> PedidosFinalizados() {
		return dao.PedidosFinalizados();
	}

	@Override
	public List<Compra> Painel() {
		return dao.Painel();
	}
	
	
}

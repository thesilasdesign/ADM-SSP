package br.com.tarefas.impl;

import org.springframework.stereotype.Repository;

import br.com.tarefas.dao.PagamentoDao;
import br.com.tarefas.model.Pagamento;

@Repository
public class PagamentoDaoImpl extends GenericDaoImpl<Pagamento, Long> implements PagamentoDao  {


}

package br.com.tarefas.impl;

import org.springframework.stereotype.Repository;

import br.com.tarefas.dao.SistMovNFDao;
import br.com.tarefas.model.SistMovNF;

@Repository
public class SistMovNFDaoImpl extends GenericDaoImpl<SistMovNF, Long> implements SistMovNFDao {

}

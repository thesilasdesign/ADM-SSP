package br.com.tarefas.impl;

import org.springframework.stereotype.Repository;

import br.com.tarefas.dao.ManutencaoDao;
import br.com.tarefas.model.Manutencao;

@Repository
public class ManutencaoDaoImpl extends GenericDaoImpl<Manutencao, Long> implements ManutencaoDao  {


}

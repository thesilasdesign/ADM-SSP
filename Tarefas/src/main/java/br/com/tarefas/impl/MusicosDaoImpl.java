package br.com.tarefas.impl;

import org.springframework.stereotype.Repository;

import br.com.tarefas.dao.MusicosDao;
import br.com.tarefas.model.Musicos;

@Repository
public class MusicosDaoImpl extends GenericDaoImpl<Musicos, Long> implements MusicosDao  {


}

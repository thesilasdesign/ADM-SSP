package br.com.tarefas.dao;

import java.util.List;
import java.util.Map;

import br.com.tarefas.model.Usuario;

public interface UsuarioDao extends GenericDao<Usuario, Long>{
	public Usuario ValidaUsuario(Usuario usuario);
	
	public Usuario ValidaEmail(String email);
	
	public List<String> Menu(String Perfil);
	
	public Map<String,List<String>> SubMenu(String Menu);
	
	public List<Usuario> CarrefaUsuarioPerfil(String Perfil); 
	
	public List<String> CarrefaEmailUsuarioPerfil(String Perfil); 
}

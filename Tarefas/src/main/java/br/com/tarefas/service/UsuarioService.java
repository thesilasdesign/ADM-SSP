package br.com.tarefas.service;

import java.util.List;
import java.util.Map;

import br.com.tarefas.model.Usuario;

public interface UsuarioService {
	
	Map<String,List<String>> SubMenu(String Menu);
	
	List<String> Menu(String Perfil);
	
	Usuario ValidaUsuario(Usuario usuario);
	
	Usuario buscaPorId(Long id);

	List<Usuario> lista();

	void adiciona(Usuario t);

	void altera(Usuario t);

	void remove(Long id);
	
	Usuario ValidaEmail(String email);
	
	List<Usuario> CarrefaUsuarioPerfil(String Perfil);
	
	List<String> CarrefaEmailUsuarioPerfil(String Perfil);
}

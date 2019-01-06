package br.com.tarefas.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.dao.UsuarioDao;
import br.com.tarefas.model.Usuario;

@Service("usuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao dao;

	@Override
	public Usuario ValidaUsuario(Usuario usuario) {
		return dao.ValidaUsuario(usuario);
	}

	@Override
	public Usuario buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Usuario> lista() {
		return dao.findAll();
	}

	@Override
	public void adiciona(Usuario t) {
		try {
			MessageDigest mD = MessageDigest.getInstance("MD5");
			BigInteger hash = new BigInteger(1, mD.digest(t.getSenha().getBytes()));
			String cript = hash.toString(16);
			t.setSenha(cript);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		dao.save(t);

	}

	@Override
	public void altera(Usuario t) {
		dao.update(t);
	}

	@Override
	public void remove(Long id) {
		dao.deleteById(id);

	}

	@Override
	public List<String> Menu(String Perfil) {
		return dao.Menu(Perfil);
	}

	@Override
	public Map<String, List<String>> SubMenu(String Menu) {
		return dao.SubMenu(Menu);
	}

	@Override
	public Usuario ValidaEmail(String email) {
		return dao.ValidaEmail(email);
	}

	@Override
	public List<Usuario> CarrefaUsuarioPerfil(String Perfil) {
		return dao.CarrefaUsuarioPerfil(Perfil);
	}

	@Override
	public List<String> CarrefaEmailUsuarioPerfil(String Perfil) {
		return dao.CarrefaEmailUsuarioPerfil(Perfil);
	}


}

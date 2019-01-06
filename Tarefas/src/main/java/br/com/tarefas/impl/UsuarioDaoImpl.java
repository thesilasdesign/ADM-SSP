package br.com.tarefas.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.tarefas.dao.UsuarioDao;
import br.com.tarefas.model.Usuario;

@Repository
public class UsuarioDaoImpl<T> extends GenericDaoImpl<Usuario, Long> implements UsuarioDao {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Usuario ValidaUsuario(Usuario usuario) {
		try {

			// Native
			// Query query = manager
			// .createNativeQuery("select * from usuario where email = " + "'" +
			// usuario.getLogin() + "'");
			// Object o = query.getSingleResult();

			// Criteria
			// CriteriaBuilder builder = manager.getCriteriaBuilder();
			// CriteriaQuery<Usuario> criteria =
			// builder.createQuery(Usuario.class);
			// Root<Usuario> rootUser = criteria.from(Usuario.class);
			// criteria.select(rootUser);
			// criteria.where(builder.equal(rootUser.get("Email"),
			// usuario.getLogin()));
			// List<Usuario> usuarios =
			// manager.createQuery(criteria).getResultList();

			// HQL
			Query query = manager.createQuery("FROM Usuario u WHERE u.Email=:login AND u.Status = 1");
			query.setParameter("login", usuario.getLogin());
			Usuario usuariosHql = (Usuario) query.getSingleResult();

			MessageDigest mD = MessageDigest.getInstance("MD5");
			BigInteger hash = new BigInteger(1, mD.digest(usuario.getSenha().getBytes()));
			String cript = hash.toString(16);

			if (usuariosHql.getSenha().equals(cript)) {
				// uDB.setSenha(null);
				return usuariosHql;
			}
		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> Menu(String Perfil) {
		try {
			Query query = manager.createNativeQuery("select DISTINCT " + " CONCAT (m.Ordernacao, '-', m.Nome) "
					+ " from UsuarioRole u, MenuPrincipal m, Perfil p, MenuAuxiliar a " + " where u.PerfilId =  "
					+ Perfil + " and m.MenuPrincipalId = u.MenuPrincipalId;");

			List<String> lista = query.getResultList();

			return lista;

		} catch (Exception e) {
			System.out.println("erro");
			e.printStackTrace();
		}
		return null;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, List<String>> SubMenu(String Menu) {
		Map<String, List<String>> mapOfList = new HashMap<String, List<String>>();

		Query query = manager
				.createNativeQuery("select Nome, Link from MenuAuxiliar where MenuPrincipalId = " + "'" + Menu + "'");

		List<String> listaa = query.getResultList();

		mapOfList.put(Menu, listaa);

		if (mapOfList.size() > 0)
			return mapOfList;

		return null;
	}

	@Override
	public Usuario ValidaEmail(String email) {
		Usuario usuariosHql = null;
		Query query = manager.createQuery("FROM Usuario u WHERE u.Email=:login");
		query.setParameter("login", email);
		try {
			usuariosHql = (Usuario) query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		

		return usuariosHql;
	}

	@Override
	public List<Usuario> CarrefaUsuarioPerfil(String Perfil) {
		Query query = manager.createQuery("FROM Usuario u WHERE u.Perfil=" + Perfil);
		@SuppressWarnings("unchecked")
		List<Usuario> lista = query.getResultList();

		return lista;

	}

	@Override
	public List<String> CarrefaEmailUsuarioPerfil(String Perfil) {
		Query query = manager
				.createNativeQuery("select Email from Usuario where Perfil = " + "'" + Perfil + "'");
		@SuppressWarnings("unchecked")
		List<String> lista = query.getResultList();

		return lista;
	}

}

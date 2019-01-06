package br.com.tarefas.controller;

import java.io.PrintWriter;
import java.io.Serializable;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.apache.commons.mail.EmailException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.tarefas.config.Conversoes;
import br.com.tarefas.config.EnviaEmail;
import br.com.tarefas.config.Mail;
import br.com.tarefas.model.Email;
import br.com.tarefas.model.Usuario;
import br.com.tarefas.service.EventosService;
import br.com.tarefas.service.IgrejaService;
import br.com.tarefas.service.UsuarioService;

@Transactional
@Controller
@SessionAttributes("MENU")
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;
	@Autowired
	UsuarioService dao; // usa apenas a interface!
	@Autowired
	IgrejaService igrejaDao; // usa apenas a interface!
	@Autowired
	EventosService eventosDao; // usa apenas a interface!

	// variaveis array
	public List<String> menu1 = new ArrayList<String>();
	public SortedMap<String, List<String>> SubMenu1 = new TreeMap<String, List<String>>();

	public List<String> menu2 = new ArrayList<String>();
	public SortedMap<String, List<String>> SubMenu2 = new TreeMap<String, List<String>>();

	public List<String> menu3 = new ArrayList<String>();
	public SortedMap<String, List<String>> SubMenu3 = new TreeMap<String, List<String>>();

	public List<String> menu4 = new ArrayList<String>();
	public SortedMap<String, List<String>> SubMenu4 = new TreeMap<String, List<String>>();

	public List<String> menu5 = new ArrayList<String>();
	public SortedMap<String, List<String>> SubMenu5 = new TreeMap<String, List<String>>();

	public List<String> menu6 = new ArrayList<String>();
	public SortedMap<String, List<String>> SubMenu6 = new TreeMap<String, List<String>>();

	public List<String> menu7 = new ArrayList<String>();
	public SortedMap<String, List<String>> SubMenu7 = new TreeMap<String, List<String>>();

	public List<String> menu8 = new ArrayList<String>();
	public SortedMap<String, List<String>> SubMenu8 = new TreeMap<String, List<String>>();

	public List<String> menu9 = new ArrayList<String>();
	public SortedMap<String, List<String>> SubMenu9 = new TreeMap<String, List<String>>();

	public List<String> menu10 = new ArrayList<String>();
	public SortedMap<String, List<String>> SubMenu10 = new TreeMap<String, List<String>>();

	public List<String> menu11 = new ArrayList<String>();
	public SortedMap<String, List<String>> SubMenu11 = new TreeMap<String, List<String>>();

	public List<String> menu12 = new ArrayList<String>();
	public SortedMap<String, List<String>> SubMenu12 = new TreeMap<String, List<String>>();
	Mail e = new Mail();

	// paginas
	@RequestMapping("loginForm")
	public String loginForm() {
		return "/login";
	}

	@RequestMapping("cadastro")
	public String cadastro() {
		return "cadastro";
	}

	@RequestMapping("/senhaTeste")
	public String Senha() throws MalformedURLException, EmailException {
		return "RecuperaSenha";
	}

	@RequestMapping("EnviaSenhaNova")
	public String EnviaSenhaNova(String email) throws MalformedURLException, EmailException, NoSuchAlgorithmException {
		Conversoes c = new Conversoes();

		String NovaSenha = "123qwe!@#";

		Usuario u = dao.ValidaEmail(email);

		if (u != null) {
			MessageDigest mD = MessageDigest.getInstance("MD5");
			BigInteger hash = new BigInteger(1, mD.digest(NovaSenha.getBytes()));
			String cript = hash.toString(16);

			u.setSenha(cript);
			dao.altera(u);
			try {
				e.sendEmailSenhaNova(u.getNome(), u.getEmail(), "Recuperação de Senha", "",
						"Sua nova Senha é: " + NovaSenha,
						"Favor entrar no sistema usando está senha e alterar no Perfil uma nova.");
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		return "redirect:MessageSenha";
	}
	

	@SuppressWarnings("unused")
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session, Model model) {
		Usuario u = (Usuario) dao.ValidaUsuario(usuario);

		if (u == null)
			return "redirect:loginForm";

		if (u.getPerfil().equals("1")) {
			menu1 = dao.Menu(u.getPerfil());
			SubMenu1.clear();

			for (int i = 0; i < menu1.size(); i++) {
				SubMenu1.putAll(dao.SubMenu(menu1.get(i)));
			}

			if (u != null) {
				session.setAttribute("usuarioLogado", u);
				session.setAttribute("MENU1", SubMenu1);
				return "redirect:Home";
			}
		}
		if (u.getPerfil().equals("2")) {
			menu2 = dao.Menu(u.getPerfil());
			SubMenu2.clear();

			for (int i = 0; i < menu2.size(); i++) {
				SubMenu2.putAll(dao.SubMenu(menu2.get(i)));
			}

			if (u != null) {
				session.setAttribute("usuarioLogado", u);
				session.setAttribute("MENU2", SubMenu2);
				return "redirect:Home";
			}
		}
		if (u.getPerfil().equals("3")) {
			menu3 = dao.Menu(u.getPerfil());
			SubMenu3.clear();

			for (int i = 0; i < menu3.size(); i++) {
				SubMenu3.putAll(dao.SubMenu(menu3.get(i)));
			}

			if (u != null) {
				session.setAttribute("usuarioLogado", u);
				session.setAttribute("MENU3", SubMenu3);
				return "redirect:Home";
			}
		}
		if (u.getPerfil().equals("4")) {
			menu4 = dao.Menu(u.getPerfil());
			SubMenu4.clear();

			for (int i = 0; i < menu4.size(); i++) {
				SubMenu4.putAll(dao.SubMenu(menu4.get(i)));
			}

			if (u != null) {
				session.setAttribute("usuarioLogado", u);
				session.setAttribute("MENU4", SubMenu4);
				return "redirect:Home";
			}
		}
		if (u.getPerfil().equals("5")) {
			menu5 = dao.Menu(u.getPerfil());
			SubMenu5.clear();

			for (int i = 0; i < menu5.size(); i++) {
				SubMenu5.putAll(dao.SubMenu(menu5.get(i)));
			}

			if (u != null) {
				session.setAttribute("usuarioLogado", u);
				session.setAttribute("MENU5", SubMenu5);
				return "redirect:Home";
			}
		}
		if (u.getPerfil().equals("6")) {
			menu6 = dao.Menu(u.getPerfil());
			SubMenu6.clear();

			for (int i = 0; i < menu6.size(); i++) {
				SubMenu6.putAll(dao.SubMenu(menu6.get(i)));
			}

			if (u != null) {
				session.setAttribute("usuarioLogado", u);
				session.setAttribute("MENU6", SubMenu6);
				return "redirect:Home";
			}
		}

		if (u.getPerfil().equals("7")) {
			menu7 = dao.Menu(u.getPerfil());
			SubMenu7.clear();

			for (int i = 0; i < menu7.size(); i++) {
				SubMenu7.putAll(dao.SubMenu(menu7.get(i)));
			}

			if (u != null) {
				session.setAttribute("usuarioLogado", u);
				session.setAttribute("MENU7", SubMenu7);
				return "redirect:Home";
			}
		}

		if (u.getPerfil().equals("8")) {
			menu8 = dao.Menu(u.getPerfil());
			SubMenu8.clear();

			for (int i = 0; i < menu8.size(); i++) {
				SubMenu8.putAll(dao.SubMenu(menu8.get(i)));
			}

			if (u != null) {
				session.setAttribute("usuarioLogado", u);
				session.setAttribute("MENU8", SubMenu8);
				return "redirect:Home";
			}
		}
		if (u.getPerfil().equals("9")) {
			menu9 = dao.Menu(u.getPerfil());
			SubMenu9.clear();

			for (int i = 0; i < menu9.size(); i++) {
				SubMenu9.putAll(dao.SubMenu(menu9.get(i)));
			}

			if (u != null) {
				session.setAttribute("usuarioLogado", u);
				session.setAttribute("MENU9", SubMenu9);
				return "redirect:Home";
			}
		}
		if (u.getPerfil().equals("10")) {
			menu10 = dao.Menu(u.getPerfil());
			SubMenu10.clear();

			for (int i = 0; i < menu10.size(); i++) {
				SubMenu10.putAll(dao.SubMenu(menu10.get(i)));
			}

			if (u != null) {
				session.setAttribute("usuarioLogado", u);
				session.setAttribute("MENU10", SubMenu10);
				return "redirect:Home";
			}
		}
		if (u.getPerfil().equals("11")) {
			menu11 = dao.Menu(u.getPerfil());
			SubMenu11.clear();

			for (int i = 0; i < menu11.size(); i++) {
				SubMenu11.putAll(dao.SubMenu(menu11.get(i)));
			}

			if (u != null) {
				session.setAttribute("usuarioLogado", u);
				session.setAttribute("MENU11", SubMenu11);
				return "redirect:Home";
			}
		}
		if (u.getPerfil().equals("12")) {
			menu12 = dao.Menu(u.getPerfil());
			SubMenu12.clear();

			for (int i = 0; i < menu12.size(); i++) {
				SubMenu12.putAll(dao.SubMenu(menu12.get(i)));
			}

			if (u != null) {
				session.setAttribute("usuarioLogado", u);
				session.setAttribute("MENU12", SubMenu12);
				return "redirect:Home";
			}
		}

		return "redirect:loginForm";
	}

	@RequestMapping("addCadastro")
	public String adiciona(Usuario usuario, BindingResult result, final RedirectAttributes redirectAttributes)
			throws MalformedURLException, EmailException {
		if (result.hasFieldErrors("email") || result.hasFieldErrors("nome") || result.hasFieldErrors("senha")) {
			return "tarefa/erro";
		}

		if (dao.ValidaEmail(usuario.getEmail()) != null)
			return "redirect:JaCadastrado";
		else {
			
			Calendar c = Calendar.getInstance();
			SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
			String a = s.format(c.getTime());
			System.out.println("data = "+a);
			
			usuario.setDataCadastro(a);
			usuario.setStatus("0");
			dao.adiciona(usuario);

			 e.sendEmailNovoUsuario(usuario.getNome(), usuario.getEmail());
		}
		return "redirect:Cadastrado";
	}

	@RequestMapping("alteraUsuario")
	public String alteraUsuario(Usuario usuario) {
		Usuario u = dao.buscaPorId(usuario.getUsuarioId());

		if (u.getUsuarioId().equals("")) {
			return "Home";
		}
		usuario.setStatus("1");
		dao.altera(usuario);
		return "redirect:perfil";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginForm";
	}

	@RequestMapping("StatusUsuario")
	public String StatusUsuario(Long id) {
		Usuario usuario = dao.buscaPorId(id);
		if (usuario != null)
			if (usuario.getStatus().equals("1")) {
				usuario.setStatus("0");
				dao.altera(usuario);
			} else {
				usuario.setStatus("1");
				dao.altera(usuario);
			}

		return "redirect:AreaInformatica";
	}

	@RequestMapping("EditaPerfil")
	public String EditaPerfil(Long id, Model model) {
		Usuario usuario = dao.buscaPorId(id);
		model.addAttribute("usuario", usuario);
		return "Informatica/EditaPerfil";
	}
	
	@RequestMapping("AtualizaSenha")
	public String AtualizaSenha(String senha, String repitaSenha, HttpSession session) throws NoSuchAlgorithmException {
		
		if (senha.equals(repitaSenha)){
			Usuario u = (Usuario) session.getAttribute("usuarioLogado");
				MessageDigest mD = MessageDigest.getInstance("MD5");
				BigInteger hash = new BigInteger(1, mD.digest(senha.getBytes()));
				String cript = hash.toString(16);

				u.setSenha(cript);
				dao.altera(u);
			return "redirect:MessageNovaSenha";
		} else
		return "redirect:MessageSenhaInvalida";
	}

	@RequestMapping("DefinePerfil")
	public String DefinePerfil(Usuario usuario) {
		Usuario u = dao.buscaPorId(usuario.getUsuarioId());
		u.setPerfil(usuario.getPerfil());
		u.setSetor(usuario.getSetor());
		dao.altera(u);
		return "redirect:AreaInformatica";
	}

	@RequestMapping("DeletarUsuario")
	public String DeletarUsuario(Long id) {
		Usuario usuario = dao.buscaPorId(id);
		if (usuario != null)
			dao.remove(usuario.getUsuarioId());
		return "redirect:AreaInformatica";
	}

}

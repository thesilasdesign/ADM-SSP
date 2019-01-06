package br.com.tarefas.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tarefas.model.Igreja;
import br.com.tarefas.model.Usuario;
import br.com.tarefas.service.CompraService;
import br.com.tarefas.service.EventosService;
import br.com.tarefas.service.IgrejaService;
import br.com.tarefas.service.InformaticaService;
import br.com.tarefas.service.NotificacaoService;
import br.com.tarefas.service.UsuarioService;

@Transactional
@Controller
public class HomeController {

	@Autowired
	IgrejaService igrejaDao; // usa apenas a interface!
	@Autowired
	EventosService eventosDao; // usa apenas a interface!
	@Autowired
	UsuarioService usuarioDao; // usa apenas a interface!
	@Autowired
	CompraService compraDao; // usa apenas a interface!
	@Autowired
	InformaticaService informaticaDao; // usa apenas a interface!
	@Autowired
	NotificacaoService notificacaoDao;

	@RequestMapping("Home")
	public String Home(Model model, HttpSession session) {
		
		if (notificacaoDao.NotificacaoAbertas() != null){
			session.setAttribute("qtdeNotificacao", notificacaoDao.NotificacaoAbertas().size());
			session.setAttribute("NotificacaoAbertas", notificacaoDao.NotificacaoAbertas());
		} else {
			session.setAttribute("qtdeNotificacao", 0);
		}
		
		if (compraDao.CompraAbertas()!= null){
			session.setAttribute("qtdeCompras", compraDao.CompraAbertas().size());
			session.setAttribute("ComprasAbertas", compraDao.CompraAbertas());
		} else {
			session.setAttribute("qtdeCompras", 0);
		}
		
		if (informaticaDao.ChamadosAbertos()!=null){
			session.setAttribute("qtdeInformatica", informaticaDao.ChamadosAbertos().size());
			session.setAttribute("informaticaAberto", informaticaDao.ChamadosAbertos());
		} else {
			session.setAttribute("qtdeInformatica", 0);
		}

		if (compraDao.AprovacaoPresidente()== null)
			session.setAttribute("qtdePresidente", 0);
		else
			session.setAttribute("qtdePresidente", compraDao.AprovacaoPresidente().size());

		if (compraDao.AprovacaoTesoureiro() == null)
			session.setAttribute("qtdeTesoureiro", 0);
		else
			session.setAttribute("qtdeTesoureiro", compraDao.AprovacaoTesoureiro().size());

		if (compraDao.AprovacaoEngenheiro() == null)
			session.setAttribute("qtdeEngenheiro", 0);
		else
			session.setAttribute("qtdeEngenheiro", compraDao.AprovacaoEngenheiro().size());

		if (compraDao.AprovacaoPresidente() != null) {
			session.setAttribute("aprovacaoPresidente", compraDao.AprovacaoPresidente());
		}
		if (compraDao.AprovacaoTesoureiro() != null) {
			session.setAttribute("aprovacaoTesoureiro", compraDao.AprovacaoTesoureiro());
		}
		if (compraDao.AprovacaoEngenheiro() != null) {
			session.setAttribute("aprovacaoEngenheiro", compraDao.AprovacaoEngenheiro());
		}
		model.addAttribute("eventos", eventosDao.lista());
		return "Home";
	}
	
	@RequestMapping("perfil")
	public String Perfil(Model model, HttpSession session) {
		Usuario u = (Usuario) session.getAttribute("usuarioLogado");
		List<Igreja> i = igrejaDao.lista();
		model.addAttribute("perfil", u);
		model.addAttribute("igreja", i);
		return "Perfil";
	}
	
	@RequestMapping("Links")
	public String Links() {
		
		return "Diversos/Links";
	}
	
	@RequestMapping("Distribuidora")
	public String Distribuidora() {
		
		return "Diversos/Distribuidora";
	}
	
	@RequestMapping("/alterarSenha")
	public String alterarSenha(Model model, HttpSession session) {
		Usuario u = (Usuario) session.getAttribute("usuarioLogado");
		model.addAttribute(u);
		return "alterarSenha2";
	}
}

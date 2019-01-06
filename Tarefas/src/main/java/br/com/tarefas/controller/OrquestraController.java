package br.com.tarefas.controller;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tarefas.model.Musicos;
import br.com.tarefas.model.Aprendiz;
import br.com.tarefas.model.EnsaioRegional;
import br.com.tarefas.model.Usuario;
import br.com.tarefas.model.Instrutor;
import br.com.tarefas.service.AprendizService;
import br.com.tarefas.service.EnsaioRegionalService;
import br.com.tarefas.service.IgrejaService;
import br.com.tarefas.service.InstrutorService;
import br.com.tarefas.service.MusicosService;


@Transactional
@Controller
public class OrquestraController {

	@Autowired
	IgrejaService igrejaDao;
	
	@Autowired
	MusicosService musicosDao;
	
	@Autowired
	AprendizService aprendizDao;
	
	@Autowired
	InstrutorService instrutorDao;
	
	@Autowired
	EnsaioRegionalService ensaioDao;
	
	@RequestMapping("Musico")
	public String Musico(Model model, HttpSession session) {
		Usuario u = (Usuario) session.getAttribute("usuarioLogado");
		model.addAttribute("musicos", musicosDao.lista());
		model.addAttribute("igreja", u.getComum());
		return "/Orquestra/Musicos";
	}

	@RequestMapping("CadastroMusicos")
	public String Cadastro(Musicos musicos, Model model,BindingResult result,HttpSession session) {
		Usuario u = (Usuario) session.getAttribute("usuarioLogado");
		musicos.setComum(u.getComum());
		musicosDao.adiciona(musicos);
		return "redirect:Musico";
	}
	
	@RequestMapping("RemoverMusicos")
	public String Remover(Long id) {
		musicosDao.removeById(id);
		return "redirect:Musico";
	}
	
	
	@RequestMapping("Aprendiz")
	public String Aprendiz(Model model, HttpSession session) {
		Usuario u = (Usuario) session.getAttribute("usuarioLogado");
		model.addAttribute("aprendiz", aprendizDao.lista());
		model.addAttribute("igreja", u.getComum());
		return "/Orquestra/Aprendiz";
	}

	@RequestMapping("CadastroAprendiz")
	public String CadastroAprendiz(Aprendiz aprendiz, Model model,BindingResult result,HttpSession session) {
		Usuario u = (Usuario) session.getAttribute("usuarioLogado");
		aprendiz.setComum(u.getComum());
		aprendizDao.adiciona(aprendiz);
		return "redirect:Aprendiz";
	}
	
	@RequestMapping("RemoverAprendiz")
	public String RemoverAprendiz(Long id) {
		aprendizDao.removeById(id);
		return "redirect:Aprendiz";
	}
	
	
	@RequestMapping("Instrutores")
	public String Instrutor(Model model, HttpSession session) {
		Usuario u = (Usuario) session.getAttribute("usuarioLogado");
		model.addAttribute("instrutor", instrutorDao.lista());
		model.addAttribute("igreja", u.getComum());
		return "/Orquestra/Instrutor";
	}

	@RequestMapping("CadastroInstrutor")
	public String CadastroAprendiz(Instrutor instrutor, Model model,BindingResult result,HttpSession session) {
		Usuario u = (Usuario) session.getAttribute("usuarioLogado");
		instrutor.setComum(u.getComum());
		instrutorDao.adiciona(instrutor);
		return "redirect:Instrutores";
	}
	
	@RequestMapping("RemoverInstrutor")
	public String RemoverInstrutor(Long id) {
		instrutorDao.removeById(id);
		return "redirect:Instrutores";
	}
	
	@RequestMapping("EnsaioRegional")
	public String Instrutor(Model model) {
		model.addAttribute("ensaio", ensaioDao.lista());
		model.addAttribute("igreja", igrejaDao.lista());
		return "/Orquestra/EnsaioRegional";
	}

	@RequestMapping("CadastrarEnsaio")
	public String CadastrarEnsaio(EnsaioRegional ensaio, Model model,BindingResult result,HttpSession session) {
		
		Long Soma = Long.parseLong(ensaio.getMusicos())+
	             Long.parseLong(ensaio.getOrganistas())+
	             Long.parseLong(ensaio.getIrmandade());
		
		ensaio.setTotalGeral(Soma.toString());
		ensaioDao.adiciona(ensaio);
		return "redirect:EnsaioRegional";
	}
}

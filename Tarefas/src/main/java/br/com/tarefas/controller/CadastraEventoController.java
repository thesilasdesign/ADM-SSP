package br.com.tarefas.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tarefas.model.Eventos;
import br.com.tarefas.service.EventosService;

@Transactional
@Controller
public class CadastraEventoController {

	@Autowired
	EventosService dao; // usa apenas a interface!
	
	@RequestMapping("CadastroEvento")
	public String Novo(Model model) {
		model.addAttribute("eventos", dao.lista());
		return "/Secretaria/CadastroEvento";
	}
	
	@RequestMapping("Cadastro")
	public String Cadastra(Eventos eventos, BindingResult result, Model model) {
		if (result.hasFieldErrors("titulo") || result.hasFieldErrors("texto") || result.hasFieldErrors("data")) {
			return "404";
		}
		dao.adiciona(eventos);
		model.addAttribute("eventos", dao.lista());
		return "/Secretaria/CadastroEvento";
	}
	
	@RequestMapping("removeEvento")
	public String remove(Long id, Model model) {
		dao.removeById(id);
		model.addAllAttributes(dao.lista());
		return "redirect:CadastroEvento";
	}
}

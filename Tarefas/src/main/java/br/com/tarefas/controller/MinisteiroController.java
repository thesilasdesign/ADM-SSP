package br.com.tarefas.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tarefas.model.Ministerio;
import br.com.tarefas.service.IgrejaService;
import br.com.tarefas.service.MinisterioService;

@Transactional
@Controller
public class MinisteiroController {
	
	@Autowired
	MinisterioService serviceDao; // usa apenas a interface!
	@Autowired
	IgrejaService igrejaDao; // usa apenas a interface!
	
	@RequestMapping("Ministerio")
	public String Atual(Model model) {
		model.addAttribute("ministerios", serviceDao.lista());
		model.addAttribute("igrejas", igrejaDao.lista());
		return "/Secretaria/Ministerio";
	}

	@RequestMapping("CadastroMinisterio")
	public String Cadastro(Ministerio ministerio, Model model,BindingResult result) {
		serviceDao.adiciona(ministerio);
		return "redirect:Ministerio";
	}
	
	@RequestMapping("RemoverMinisterio")
	public String Remover(Long id) {
		serviceDao.removeById(id);
		return "redirect:Ministerio";
	}
}

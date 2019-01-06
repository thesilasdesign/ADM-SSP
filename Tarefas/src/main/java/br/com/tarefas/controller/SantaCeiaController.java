package br.com.tarefas.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tarefas.model.SantaCeia;
import br.com.tarefas.service.IgrejaService;
import br.com.tarefas.service.SantaCeiaService;

@Transactional
@Controller
public class SantaCeiaController {
	
	@Autowired
	SantaCeiaService serviceDao; // usa apenas a interface!
	@Autowired
	IgrejaService igrejaDao; // usa apenas a interface!
	
	@RequestMapping("SantaCeia")
	public String Atual(Model model) {
		model.addAttribute("total", serviceDao.Somatoria());
		model.addAttribute("santaCeias", serviceDao.lista());
		model.addAttribute("igrejas", igrejaDao.lista());
		return "/Secretaria/SantaCeia";
	}

	@RequestMapping("CadastroSantaCeia")
	public String Cadastro(SantaCeia santaCeia, Model model,BindingResult result) {
		santaCeia.setTotal(santaCeia.getHomens()+santaCeia.getMulheres());
		serviceDao.adiciona(santaCeia);
		return "redirect:SantaCeia";
	}
	
	@RequestMapping("RemoverSantaCeia")
	public String Remover(Long id) {
		serviceDao.removeById(id);
		return "redirect:SantaCeia";
	}
}

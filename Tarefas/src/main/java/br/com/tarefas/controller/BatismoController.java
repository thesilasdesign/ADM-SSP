package br.com.tarefas.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tarefas.model.Batismo;
import br.com.tarefas.service.BatismoService;
import br.com.tarefas.service.IgrejaService;


@Transactional
@Controller
public class BatismoController {
	
	@Autowired
	BatismoService serviceDao; // usa apenas a interface!
	@Autowired
	IgrejaService igrejaDao; // usa apenas a interface!
	
	@RequestMapping("Batismo")
	public String Atual(Model model) {
		model.addAttribute("total", serviceDao.Somatoria());
		model.addAttribute("batismos", serviceDao.lista());
		model.addAttribute("igreja", igrejaDao.lista());
		return "/Secretaria/Batismo";
	}

	@RequestMapping("CadastroBatismo")
	public String Cadastro(Batismo batismo, Model model,BindingResult result) {
		batismo.setQuantidadeTotal(batismo.getQuantidadeHomem()+batismo.getQuantidadeMulher());
		serviceDao.adiciona(batismo);
		return "redirect:Batismo";
	}
	
	@RequestMapping("RemoverBatismo")
	public String Remover(Long id) {
		serviceDao.removeById(id);
		return "redirect:Batismo";
	}
}

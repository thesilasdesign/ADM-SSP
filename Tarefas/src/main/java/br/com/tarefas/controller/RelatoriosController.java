package br.com.tarefas.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tarefas.model.Agenda;
import br.com.tarefas.service.AgendaService;
import br.com.tarefas.service.IgrejaService;


@Transactional
@Controller
public class RelatoriosController {
	
	@Autowired
	IgrejaService igrejaDao; // usa apenas a interface!
	@Autowired
	AgendaService agendaDao; // usa apenas a interface!
	
	
	@RequestMapping("RelatorioIgrejas")
	public String RelatorioIgrejas(Model model) {
		model.addAttribute("igrejas", igrejaDao.lista());
		return "/Relatorios/RelatorioIgrejas";
	}
	
	@RequestMapping("AgendaContatos")
	public String AgendaContatos(Model model) {
		model.addAttribute("contatos", agendaDao.lista());
		return "/Relatorios/AgendaContatos";
	}
	
	@RequestMapping("CadastrarAgenda")
	public String CadastrarAgenda(Agenda agenda) {
		agendaDao.adiciona(agenda);
		return "redirect:AgendaContatos";
	}
	
	@RequestMapping("AgendaRemove")
	public String AgendaRemove(Long id) {
		agendaDao.removeById(id);
		return "redirect:AgendaContatos";
	}
	
	@RequestMapping("AgendaEdita")
	public String AgendaEdita(Long id, Model model) {
		model.addAttribute("contatos", agendaDao.buscaPorId(id));
		return "/Relatorios/EditaAgenda";
	}
	
	@RequestMapping("AtualizaAgenda")
	public String AtualizaAgenda(Agenda agenda) {
		Agenda a = agendaDao.buscaPorId(agenda.getAgendaId());
		
		if (a.getAgendaId().toString() != "") {
			agendaDao.atualiza(agenda);
		}
		
		return "redirect:AgendaContatos";
	}
	
	

}

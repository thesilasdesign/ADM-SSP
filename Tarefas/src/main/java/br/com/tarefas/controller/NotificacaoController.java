package br.com.tarefas.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tarefas.model.Notificacao;
import br.com.tarefas.service.NotificacaoService;

@Transactional
@Controller
public class NotificacaoController {
	
	@Autowired
	NotificacaoService notificacaoDao; // usa apenas a interface!
	
	@RequestMapping("PainelNotificacao")
	public String Atual(Model model) {
		model.addAttribute("notif", notificacaoDao.NotificacaoAbertas());
		return "Notificacao/ListaNotificacao";
	}

	@RequestMapping("FinalizarNotificacao")
	public String Cadastro(Long id) {
		Notificacao n = notificacaoDao.buscaPorId(id);
		n.setCampo4("2");
		notificacaoDao.atualiza(n);
		return "redirect:PainelNotificacao";
	}
//	
//	@RequestMapping("RemoverBatismo")
//	public String Remover(Long id) {
//		serviceDao.removeById(id);
//		return "redirect:Batismo";
//	}
}

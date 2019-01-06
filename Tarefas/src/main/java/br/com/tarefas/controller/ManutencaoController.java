package br.com.tarefas.controller;

import java.net.MalformedURLException;

import javax.transaction.Transactional;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tarefas.model.Manutencao;
import br.com.tarefas.service.ManutencaoService;
import br.com.tarefas.service.CompraItemService;
import br.com.tarefas.service.IgrejaService;


@Transactional
@Controller
public class ManutencaoController {
	
	public static Manutencao manutencaoStatic;
	@Autowired
	ManutencaoService ManutencaoDao; // usa apenas a interface!
	@Autowired
	IgrejaService igrejaDao; // usa apenas a interface!
	@Autowired
	CompraItemService compraItemDao; // usa apenas a interface!
	
	@RequestMapping("PainelManutencao")
	public String Painel(Model model) throws EmailException, MalformedURLException {
		model.addAttribute("manutencao", ManutencaoDao.lista());
		return "Manutencao/PainelManutencao";
	}
	
	@RequestMapping("SolicitaManutencao")
	public String Atual(Model model) {
		model.addAttribute("comum", igrejaDao.lista());
		return "Manutencao/SolicitaManutencao";
	}

	@RequestMapping("CadastroManutencao")
	public String Cadastro(Manutencao manutencao, Model model,BindingResult result) {
		Manutencao m = ManutencaoDao.adicionaId(manutencao);
		model.addAttribute("manutencao", m);
		return "redirect:SolicitaManutencao";
	}
	
	@RequestMapping("ManutencaoBloqueado")
	public String ManutencaoBloqueado(Long id, Model model) {
		Manutencao m = ManutencaoDao.buscaPorId(id);
		model.addAttribute("manutencao", m);
		return "Manutencao/ManutencaoBloqueado";
	}
	
	@RequestMapping("AtualizaManutencao")
	public String AtualizaManutencao(Manutencao manutencao, Model model) {
		Manutencao m = ManutencaoDao.buscaPorId(manutencao.getManutencaoId());
		if (m != null) {
			ManutencaoDao.atualiza(manutencao);
		}
		model.addAttribute("manutencao", m);
		return "redirect:PainelManutencao";
	}
	
}

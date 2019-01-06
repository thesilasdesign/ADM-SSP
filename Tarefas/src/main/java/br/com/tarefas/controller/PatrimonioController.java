package br.com.tarefas.controller;

import java.io.IOException;
import java.net.SocketException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tarefas.config.Conversoes;
import br.com.tarefas.service.ComissaoConstrucaoService;
import br.com.tarefas.model.ComissaoConstrucao;

@Controller
public class PatrimonioController {
	@Autowired
	ComissaoConstrucaoService comissaoDao; // usa apenas a interface!
	
	Conversoes c = new Conversoes();
	@RequestMapping("Projetos")
	public String Projetos(Model model) throws SocketException, IOException{
		String[] arq = null;
		
		arq=c.ListaFTP("Projetos");
		
		model.addAttribute("files", arq);
		return "Patrimonio Projetos/Projetos";
	}
	
	@RequestMapping("ComissaoConstrucao")
	public String ComissaoConstrucao(Model model) {
		
		model.addAttribute("Comissao", comissaoDao.lista());
		return "Patrimonio Projetos/ComissaoConstrucao";
	}
	
	@RequestMapping("CadastrarComissao")
	public String CadastrarComissao(ComissaoConstrucao comissao) {
		comissaoDao.adiciona(comissao);
		return "redirect:ComissaoConstrucao";
	}
	
	@RequestMapping("ComissaoRemove")
	public String ComissaoRemove(Long id) {
		comissaoDao.removeById(id);
		return "redirect:ComissaoConstrucao";
	}
	
	@RequestMapping("ComissaoEdita")
	public String ComissaoEdita(Long id, Model model) {
		ComissaoConstrucao c = comissaoDao.buscaPorId(id);
		model.addAttribute("Comissao", c);
		return "Patrimonio Projetos/ComissaoConstrucaoEdita";
	}
	
	@RequestMapping("AtualizaComissao")
	public String AtualizaComissao(ComissaoConstrucao comissao) {
		comissaoDao.atualiza(comissao);
		return "redirect:ComissaoEdita?id="+comissao.getComissaoConstrucaoId();
	}
	
	
	

}

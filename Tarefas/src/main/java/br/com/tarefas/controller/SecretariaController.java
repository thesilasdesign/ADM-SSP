package br.com.tarefas.controller;

import java.io.IOException;
import java.net.SocketException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tarefas.config.Conversoes;
import br.com.tarefas.service.BatismoService;
import br.com.tarefas.service.IgrejaService;


@Transactional
@Controller
public class SecretariaController {
	
	@Autowired
	BatismoService serviceDao; // usa apenas a interface!
	@Autowired
	IgrejaService igrejaDao; // usa apenas a interface!
	
	Conversoes c = new Conversoes();
	@RequestMapping("ArquivoSecretaria")
	public String Projetos(Model model) throws SocketException, IOException{
		String[] arq = null;
		
		arq=c.ListaFTP("ArquivosSecretaria");
		
		model.addAttribute("files", arq);
		return "Secretaria/ArquivoSecretaria";
	}
}

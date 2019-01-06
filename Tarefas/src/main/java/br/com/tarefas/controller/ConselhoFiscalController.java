package br.com.tarefas.controller;

import java.io.IOException;
import java.net.SocketException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tarefas.config.Conversoes;

@Controller
public class ConselhoFiscalController {
	
	Conversoes c = new Conversoes();
	@RequestMapping("DocsConselho")
	public String DocsConselho(Model model) throws SocketException, IOException{
		String[] arq = null;
		
		arq=c.ListaFTP("DocsConselho");
		
		model.addAttribute("files", arq);
		return "Conselho Fiscal/DocsConselho";
	}

}

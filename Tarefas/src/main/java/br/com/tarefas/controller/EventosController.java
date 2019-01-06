package br.com.tarefas.controller;

import java.io.IOException;
import java.net.SocketException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tarefas.config.Conversoes;

@Controller
public class EventosController {
	
	Conversoes c = new Conversoes();
	@RequestMapping("Batismos")
	public String viewUpload(Model model) throws SocketException, IOException{
		String[] arq = null;
		
		arq=c.ListaFTP("Lista");
		
		model.addAttribute("files", arq);
		return "Eventos/Batismos";
	}
	
	@RequestMapping("Reunioes")
	public String Reunioes(Model model) throws SocketException, IOException{
		String[] arq = null;
		
		arq=c.ListaFTP("Reunioes");
		
		model.addAttribute("files", arq);
		return "Eventos/Reunioes";
	}
	
	@RequestMapping("Cursos")
	public String Cursos(Model model) throws SocketException, IOException{
		String[] arq = null;
		
		arq=c.ListaFTP("Cursos");
		
		model.addAttribute("files", arq);
		return "Eventos/Cursos";
	}

}

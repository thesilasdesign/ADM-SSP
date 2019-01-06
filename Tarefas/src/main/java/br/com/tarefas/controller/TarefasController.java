package br.com.tarefas.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.tarefas.model.Tarefa;
import br.com.tarefas.service.TarefaService;

@Transactional
@Controller
public class TarefasController {

	@Autowired
	TarefaService dao; // usa apenas a interface!

	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefa/Seguros";
	}

	@RequestMapping("DocsSecretaria")
	public String DocsSecretaria() {
		return "Secretaria/DocsSecretaria";
	}

	@RequestMapping(value = "upload", method = RequestMethod.GET)
	public String upload(HttpServletRequest request, @RequestParam("file") final MultipartFile file) {
		if (!file.isEmpty()) {
			try {

				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("C:\\Users\\teste\\Downloads");

				File dir = new File(rootPath + File.separator + "tmpFiles");

				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				return "";

			}

			catch (Exception e) {
				return "You failed to upload => " + e.getMessage();
			}
		} else {
			return "You failed to upload because the file was empty.";
		}
	}

	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
		if (result.hasFieldErrors("descricao")) {
			return "tarefa/formulario";
		}
		dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}

	@RequestMapping("listaTarefas")
	public String lista(Model model) {
		model.addAttribute("tarefas", dao.lista());
		return "tarefa/lista";
	}

	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {
		dao.remove(tarefa);
		return "redirect:listaTarefas";
	}

	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) {
		model.addAttribute("tarefa", dao.buscaPorId(id));
		return "tarefa/mostra";
	}

	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {
		System.out.println("data em tarefascontroller alteratarefa == " + tarefa.getDataFinalizacao());
		dao.altera(tarefa);
		return "redirect:listaTarefas";
	}

	@RequestMapping("finalizaTarefa")
	public String finaliza(Long id, Model model) {
		dao.finaliza(id);
		model.addAttribute("tarefa", dao.buscaPorId(id));
		return "tarefa/finalizada";
	}
}

package br.com.tarefas.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

	@RequestMapping("404")
	public String pageNotFound(Model model) {
		return "base.admin.error.404";
	}

	@RequestMapping(value = "/500")
	public String internalServerError(Model model) {
		return "base.admin.error.500";
	}

	@RequestMapping("MessageSenha")
	public ModelAndView abcHandler(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView model = new ModelAndView();
		model.addObject("ERROR_CODE", "Error Occurred");
		model.setViewName("Message/Senha");

		return model;

	}
	
	@RequestMapping("MessageNovaSenha")
	public ModelAndView MessageNovaSenha(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView model = new ModelAndView();
		model.addObject("ERROR_CODE", "Error Occurred");
		model.setViewName("Message/NovaSenha");

		return model;

	}
	
	@RequestMapping("MessageSenhaInvalida")
	public ModelAndView MessageSenhaInvalida(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView model = new ModelAndView();
		model.addObject("ERROR_CODE", "Error Occurred");
		model.setViewName("Message/MessageSenhaInvalida");

		return model;

	}
	
	@RequestMapping("Cadastrado")
	public ModelAndView abcdHandler(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView model = new ModelAndView();
		model.addObject("ERROR_CODE", "Error Occurred");
		model.setViewName("Message/Cadastrado");

		return model;

	}
	
	@RequestMapping("JaCadastrado")
	public ModelAndView abcdeHandler(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView model = new ModelAndView();
		model.addObject("ERROR_CODE", "Error Occurred");
		model.setViewName("Message/JaCadastrado");

		return model;

	}
	
	@RequestMapping("CpfJaCadastrado")
	public ModelAndView CpfJaCadastrado(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView model = new ModelAndView();
		model.addObject("ERROR_CODE", "Error Occurred");
		model.setViewName("Message/CpfJaCadastrado");

		return model;

	}
}

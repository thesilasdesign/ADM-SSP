package br.com.tarefas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.tarefas.model.Igreja;
import br.com.tarefas.model.Seguro;
import br.com.tarefas.model.SeguroTrabalho;
import br.com.tarefas.service.IgrejaService;
import br.com.tarefas.service.SeguroService;
import br.com.tarefas.service.SeguroTrabalhoService;

@Transactional
@Controller
public class SeguroController {

	@Autowired
	SeguroService serviceDao;
	@Autowired
	IgrejaService igrejaDao;
	@Autowired
	SeguroTrabalhoService trabalhoDao;

	public static Map<String, List<String>> mapOfList = new HashMap<String, List<String>>();

	@RequestMapping("Adesao")
	public String Atual(Model model) {
		model.addAttribute("adesao", serviceDao.lista());
		List<Igreja> i = igrejaDao.lista();
		model.addAttribute("igreja", i);
		return "Secretaria/Adesao";
	}

	@RequestMapping("CadastroAdesao")
	public String adiciona(Seguro seguro, BindingResult result, final RedirectAttributes redirectAttributes) {
		
		Seguro s = null;
		s = serviceDao.BuscaCpf(seguro.getCpf());
		if (s != null) {
			return "redirect:CpfJaCadastrado";
		}
				
		
		serviceDao.adiciona(seguro);
		return "redirect:Adesao";
	}

	@RequestMapping("DeletaAdesao")
	public String Deleta(Long id) {
		serviceDao.removeById(id);
		return "redirect:Adesao";
	}

	@RequestMapping("Presenca")
	public String Presenca(Model model) {
		List<Igreja> i = igrejaDao.lista();
		model.addAttribute("igreja", i);
		return "Secretaria/Presenca";
	}

	@RequestMapping("busca")
	public String buscaVoluntario(String tipo_solicitacao, Model model) {
		List<String> a = serviceDao.BuscaVoluntario(tipo_solicitacao);

		model.addAttribute("segurado", a);
		return "Secretaria/PresencaAjax";
	}

	@RequestMapping("CadastroSeguroTrabalho")
	public String CadastroSeguroTrabalho(SeguroTrabalho seguroTrabalho, Seguro seguro, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		Seguro s = new Seguro();
		// Seguro s = serviceDao.buscaPorId(seguro.getSeguroId());

		seguroTrabalho.setSeguro(s);
		seguroTrabalho.setComum(seguro.getComum());
		seguroTrabalho.setSeguro(seguro);
		trabalhoDao.adiciona(seguroTrabalho);
		return "redirect:Presenca";

	}

	@RequestMapping("EmitirRelatorio")
	public String Relatorio(Model model) {
		List<Igreja> i = igrejaDao.lista();
		model.addAttribute("igreja", i);
		return "Secretaria/EmitirRelatorio";
	}

	@RequestMapping(value = "/RelatorioSeguro.pdf", method = RequestMethod.GET)
	public ModelAndView downloadPDF(String comum, String tipo, String dataInicial, String dataFinal, Model model) {
		String[] c = comum.split("\\|");
		List<SeguroTrabalho> s = trabalhoDao.GeraRelatorio(dataInicial, dataFinal, c[1]);
		List<Seguro> se = serviceDao.ListaMinisterio();
		model.addAttribute("tipo", tipo);

		if (tipo.equals("2")) {
			return new ModelAndView("pdfView", "listSeguroTrab", s);
		}
		return new ModelAndView("pdfView", "listSeguro", se);

	}

}

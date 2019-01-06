package br.com.tarefas.controller;

import java.util.Calendar;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tarefas.config.Conversoes;
import br.com.tarefas.model.Informatica;
import br.com.tarefas.model.SistMovNF;
import br.com.tarefas.model.Usuario;
import br.com.tarefas.service.IgrejaService;
import br.com.tarefas.service.InformaticaService;
import br.com.tarefas.service.SistMovNFService;
import br.com.tarefas.service.UsuarioService;

@Transactional
@Controller
public class InformaticaController {

	@Autowired
	IgrejaService igrejaDao; // usa apenas a interface!
	@Autowired
	SistMovNFService sistDao; // usa apenas a interface!
	@Autowired
	InformaticaService informaticaDao; // usa apenas a interface!
	@Autowired
	UsuarioService usuarioDao;
	
	Conversoes c = new Conversoes();

	@RequestMapping("SistMovNF")
	public String SistMovNF(Model model) {
		model.addAttribute("igreja", igrejaDao.lista());
		model.addAttribute("SistMovs", sistDao.lista());
		return "Informatica/SistMovNF";
	}

	@RequestMapping("CadastroSistMovNF")
	public String CadastroSistMovNF(SistMovNF sistMovNF) {
		
		sistMovNF.setDataCadastro(Calendar.getInstance());
		sistDao.adiciona(sistMovNF);

		return "redirect:SistMovNF";
	}

	@RequestMapping("SistMovNFEdita")
	public String SistMovNFEdita(Long id, Model model) {
		model.addAttribute("Sistmov", sistDao.buscaPorId(id));
		return "Informatica/SistMovNFEdita";
	}
	
	@RequestMapping("SistMovNFRemove")
	public String SistMovNFRemove(Long id) {
		
		if (sistDao.buscaPorId(id) != null) {
			sistDao.removeById(id);
		}
		
		return "Informatica/SistMovNF";
	}
	
	@RequestMapping("AtualizaSistMovNF")
	public String AtualizaSistMovNF(SistMovNF s) {
		SistMovNF sist = sistDao.buscaPorId(s.getSistMovNFId());
		if (sist!= null) {
			sistDao.atualiza(s);
		}
		return "redirect:SistMovNF";
	}
	
	@RequestMapping("SolicitaInformatica")
	public String SolicitaInformatica(Model model, HttpSession session) {
		Usuario u = (Usuario) session.getAttribute("usuarioLogado");
		model.addAttribute("igreja", igrejaDao.lista());

		model.addAttribute("informatica", informaticaDao.ChamadosDoUsuario(u.getEmail()));
		return "Informatica/SolicitaInformatica";
	}

	@RequestMapping("PainelInformatica")
	public String PainelInformatica(Model model, HttpSession sessio) {
		model.addAttribute("igreja", igrejaDao.lista());
		model.addAttribute("informaticaPainel", informaticaDao.lista());
		return "Informatica/PainelInformatica";
	}

	@RequestMapping("TelaCadastroSolicitacao")
	public String TelaCadastroSolicitacao(Model model) {
		model.addAttribute("igreja", igrejaDao.lista());
		return "Informatica/TelaCadastroSolicitacao";
	}

	@RequestMapping("InserirSolicitacaoInformatica")
	public String InserirSolicitacaoInformatica(Informatica informatica) {
		informatica.setDataAbertura(Calendar.getInstance());
		informatica.setStatus("1-ABERTO");
		informaticaDao.adiciona(informatica);
		return "redirect:Home";
	}

	@RequestMapping("Chamado")
	public String Chamado(Long id, Model model) {
		informaticaDao.buscaPorId(id);
		model.addAttribute("informatica", informaticaDao.buscaPorId(id));
		return "Informatica/Chamado";
	}

	@RequestMapping("AtualizaInformatica")
	public String AtualizaInformatica(Informatica informatica) {
		String atendente = informatica.getAtendente();
		if (informatica.getAtendente() != "--Selecione--") {
			informatica = informaticaDao.buscaPorId(informatica.getInformaticaId());
			informatica.setAtendente(atendente);
			informatica.setStatus("2-EM ATENDIMENTO");
			informaticaDao.atualiza(informatica);
		}

		return "redirect:SolicitaInformatica";
	}

	@RequestMapping("AtribuiChamado")
	public String AtribuiChamado(Long id, String nomeAtendente) {
		Informatica informatica = informaticaDao.buscaPorId(id);
		String atendente = nomeAtendente;
		informatica.setAtendente(atendente);
		informatica.setStatus("2-EM ATENDIMENTO");
		informaticaDao.atualiza(informatica);
		return "redirect:Home";
	}

	// 1-ABERTO
	// 2-EM ATENDIMENTO
	// 3-PENDENTE
	// 4-CANCELADO
	// 5-CONCUIDO

	@RequestMapping("FinalizarChamado")
	public String FinalizaChamado(Long id, Model model) {
		model.addAttribute("atendendoChamdo", informaticaDao.buscaPorId(id));
		return "Informatica/FinalizaChamado";
	}
	
	@RequestMapping("ResolucaoChamado")
	public String SesolucaoChamado(Informatica informatica) {
		Informatica inf = informaticaDao.buscaPorId(informatica.getInformaticaId());
		if (inf != null) {
			inf.setObservacaoAtendente(informatica.getObservacaoAtendente());
			inf.setStatus(informatica.getStatus());
			inf.setDataFechamento(Calendar.getInstance());
			informaticaDao.atualiza(inf);
		}
		return "redirect:AreaInformatica";
	}

	@RequestMapping("AreaInformatica")
	public String AreaInformatica(Model model, HttpSession session) {
		Usuario u = (Usuario) session.getAttribute("usuarioLogado");
		model.addAttribute("MeusChamados", informaticaDao.ChamadosEmAtendimento(u.getNome()));
		model.addAttribute("usuario", usuarioDao.lista());
		return "Informatica/AreaInformatica";
	}
	
}

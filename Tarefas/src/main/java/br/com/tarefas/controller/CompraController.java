package br.com.tarefas.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.tarefas.config.Conversoes;
import br.com.tarefas.config.Mail;
import br.com.tarefas.model.Comentario;
import br.com.tarefas.model.Compra;
import br.com.tarefas.model.CompraItem;
import br.com.tarefas.model.Notificacao;
import br.com.tarefas.model.Pagamento;
import br.com.tarefas.model.Usuario;
import br.com.tarefas.service.ComentarioService;
import br.com.tarefas.service.CompraItemService;
import br.com.tarefas.service.CompraService;
import br.com.tarefas.service.IgrejaService;
import br.com.tarefas.service.NotificacaoService;
import br.com.tarefas.service.PagamentoService;
import br.com.tarefas.service.UsuarioService;

@Transactional
@Controller
public class CompraController {

	public static Compra compraStatic;
	public static Compra compraStatic2;
	public static double valor;

	@Autowired
	IgrejaService igrejaDao; // usa apenas a interface!
	@Autowired
	CompraService compraDao; // usa apenas a interface!
	@Autowired
	CompraItemService compraItemDao; // usa apenas a interface!
	@Autowired
	ComentarioService comentarioDao;
	@Autowired
	PagamentoService pagamentoDao;
	@Autowired
	NotificacaoService notificacaoDao;
	@Autowired
	UsuarioService usuarioDao; // usa apenas a interface!

	// acessa painel
	@RequestMapping("PainelCompras")
	public String Painel(Model model) throws EmailException, MalformedURLException {
		// model.addAttribute("Compras", compraDao.lista());
		model.addAttribute("Compras", compraDao.Painel());
		return "Compras/PainelCompras";
	}

	@RequestMapping("Fornecedores")
	public String Fornecedores() {
		return "Compras/Fornecedores";
	}

	Conversoes x = new Conversoes();

	@RequestMapping("Convenios")
	public String Projetos(Model model) throws SocketException, IOException {
		String[] arq = null;

		arq = x.ListaFTP("Convenios");

		model.addAttribute("files", arq);
		return "Compras/Convenios";
	}

	// Novo Pedido
	@RequestMapping("NovaCompra")
	public String Nova(Model model) {
		model.addAttribute("Compras", compraDao.lista());
		model.addAttribute("igrejas", igrejaDao.lista());
		return "Compras/NovaCompra";
	}

	@RequestMapping("SolicitaCompras")
	public String SolicitaCompras(HttpSession session, Model model) {
		Usuario u = (Usuario) session.getAttribute("usuarioLogado");
		model.addAttribute("Compras", compraDao.ComprasUsuario(u.getEmail()));
		model.addAttribute("igrejas", igrejaDao.lista());
		return "Compras/SolicitaCompras";
	}

	// grava Compra
	@RequestMapping("CadastraCompra")
	public String CadastraCompra(Compra compra, Model model) throws MalformedURLException, EmailException {
		compra.setDataAbertura(Calendar.getInstance());
		compra.setStatus("1-SOLICITADO");
		Compra c = compraDao.adicionaId(compra);
		model.addAttribute("Compras", c);

	    List<String> enviatodos =  null;
	    
	
	    @SuppressWarnings("unused")
		List<String> Comprador = usuarioDao.CarrefaEmailUsuarioPerfil("4"); 
		List<String> Presidente = usuarioDao.CarrefaEmailUsuarioPerfil("9");
		List<String> Tesoureiro = usuarioDao.CarrefaEmailUsuarioPerfil("2");
		List<String> Engenheiro = usuarioDao.CarrefaEmailUsuarioPerfil("10");

		Mail e = new Mail();

		e.sendEmailEquipeCompras(Comprador, Presidente, Tesoureiro, Engenheiro, c.getSolicitante(), c.getEmailSolicitante(),
				"PEDIDO " + c.getCompraId().toString() + " CADASTRADO ", c.getCompraId().toString(),
				"Confimação de Pedido novo", "Favor dar sequência na compra.");
		return "Compras/ItemPedido";
	}

	// adiciona itens
	@RequestMapping("AdicionarItens")
	public String ItemCompra(CompraItem item, Compra compra, Model model, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		Compra c = compraDao.buscaPorId(compra.getCompraId());

		item.setCompra(c);
		item.setValorTotal(item.getValorUnidade() * item.getQuantidade());

		compraItemDao.adiciona(item);

		model.addAttribute("Compras", c);
		if (c.getValorTotal() == null)
			c.setValorTotal(0.0);
		valor = c.getValorTotal();
		valor = valor + (item.getValorUnidade() * item.getQuantidade());
		c.setValorTotal(valor);
		compraDao.atualiza(c);
		compraStatic = c;
		return "redirect:ItemPedido";
	}

	@RequestMapping("ItemPedido")
	public String ItemPedido(Compra compra, Model model) {
		compra = compraStatic;
		List<CompraItem> item = compraItemDao.ListItens(compra);

		model.addAttribute("Itens", item);
		model.addAttribute("Compras", compra);
		return "Compras/ItemPedido";
	}

	@RequestMapping("DeletaItem")
	public String DeletaItem(Long id, Long idCompra, Double valorRetira, Model model) {
		Compra c = compraDao.BuscandoId(idCompra);
		compraItemDao.removeById(id);
		List<Double> v = compraItemDao.ValorSomaTotal(compraStatic);
		String ValorSinal = v.get(0).toString();
		Double valorDouble = Double.parseDouble(ValorSinal);
		c.setValorTotal(valorDouble);
		compraDao.atualiza(c);
		List<CompraItem> item = compraItemDao.ListItens(c);
		model.addAttribute("Itens", item);
		model.addAttribute("Compras", c);
		return "Compras/ItemPedido";
	}

	@RequestMapping("AlterarItem")
	public String AlterarItem(Long id, Model model, Long idCompra, Double valorAltera) {
		CompraItem compraItem = compraItemDao.buscaPorId(id);
		// compraStatic = compraDao.BuscandoId(idCompra);
		valor = valorAltera;
		// compraStatic.setValorTotal(valor);
		// compraDao.atualiza(compraStatic);
		model.addAttribute("itens", compraItem);
		model.addAttribute("Compras", compraStatic);

		return "Compras/mostraItem";
	}

	@RequestMapping("Pedido")
	public String Pedido(Long id, Model model) {
		model.addAttribute("compras", compraDao.buscaPorId(id));
		model.addAttribute("igrejas", igrejaDao.lista());
		compraStatic = compraDao.buscaPorId(id);
		return "Compras/Pedido";
	}

	@RequestMapping("PedidoBloqueado")
	public String PedidoBloqueado(Long id, Model model) {
		model.addAttribute("compras", compraDao.BuscandoId(id));
		compraStatic = compraDao.buscaPorId(id);
		model.addAttribute("compradores", usuarioDao.CarrefaUsuarioPerfil("4"));
		model.addAttribute("Itens", compraItemDao.ListItens(compraStatic));

		return "Compras/PedidoBloqueado";
	}

	@RequestMapping("AtualizaCompra")
	public String AtualizaCompra(Compra compra, Model model) {
		compraStatic = compraDao.BuscandoId(compra.getCompraId());
		String[] comprador = compra.getComprador().split("\\|", 2);
		if (comprador[0] != "")
			compraStatic.setStatus(compra.getStatus());
		compraStatic.setCompradorId(comprador[0]);
		compraStatic.setComprador(comprador[1]);
		compraStatic.setComum(compra.getComum());
		compraStatic.setCentroCusto(compra.getCentroCusto());
		compraDao.atualiza(compraStatic);

		return "redirect:ItemPedido";
	}

	@RequestMapping("AtualizaItem")
	public String AtualizaItemCompra(CompraItem compraItem, Model model) {
		compraItem.setValorTotal(compraItem.getValorUnidade() * compraItem.getQuantidade());
		compraItem.setCompra(compraStatic);
		compraItemDao.atualiza(compraItem);
		Compra c = compraDao.BuscandoId(compraItem.getCompra().getCompraId());

		List<Double> v = compraItemDao.ValorSomaTotal(compraStatic);
		String ValorSinal = v.get(0).toString();
		Double valorDouble = Double.parseDouble(ValorSinal);
		c.setValorTotal(valorDouble);
		compraDao.atualiza(c);

		valor = 0.0;
		List<CompraItem> item = compraItemDao.ListItens(c);
		model.addAttribute("Itens", item);
		model.addAttribute("Compras", c);
		return "Compras/ItemPedido";
	}

	@RequestMapping("Comprador")
	public String AreaComprador(HttpSession session, Model model) {
		Usuario u = (Usuario) session.getAttribute("usuarioLogado");
		List<Compra> c = compraDao.Comprador(u.getUsuarioId().toString());
		model.addAttribute("Comprador", c);
		return "Compras/Comprador";
	}

	@RequestMapping("aprovacaoCompra")
	public String aprovacao(Long id, Model model) {
		model.addAttribute("compras", compraDao.buscaPorId(id));
		compraStatic = compraDao.buscaPorId(id);
		return "Compras/aprovacaoCompra";
	}

	@RequestMapping("EnviaAprovacao")
	public String EnviaAprovacao(Compra compra, String enviaAprovacao, Model model) {
		compraStatic = compraDao.buscaPorId(compra.getCompraId());
		compraStatic.setStatus("4-AGUARDANDO APROVAÇÃO");
		compraStatic.setAprovacaoPresidente("1|");
		compraStatic.setAprovacaoTesoureiro("1|");
		compraStatic.setAprovacaoEngenheiro("1|");
		compraDao.atualiza(compraStatic);
		return "redirect:aprovacaoCompra?id=" + compraStatic.getCompraId();
	}
	// AprovacaoPresidente, AprovacaoEngenheiro, AprovacaoTesoureiro
	// 1|Branco = Enviado para aprovação
	// 2|Nome Pessoa = Reprovado
	// 3|Nome Pessoa = Aprovado

	@RequestMapping("comentarioCompra")
	public String comentarioCompra(Long id, Model model) {
		compraStatic = compraDao.buscaPorId(id);
		model.addAttribute("coments", comentarioDao.CarregaComentarios(compraStatic));
		model.addAttribute("compras", compraDao.buscaPorId(id));
		return "Compras/comentarioCompra";
	}

	@RequestMapping("SelecionaComprador")
	public String SelecionaComprador(String comprador, Long compraId) {
		compraStatic = compraDao.buscaPorId(compraId);
		String[] Comprador = comprador.split("\\|", 2);
		if (Comprador[0] != "") {
			compraStatic.setStatus("2-ANALISE COMPRADOR");
			compraStatic.setCompradorId(Comprador[0]);
			compraStatic.setComprador(Comprador[1]);
			compraDao.atualiza(compraStatic);
		}
		return "redirect:PainelCompras";
	}

	@RequestMapping("InsereComentario")
	public String InsereComentario(Comentario c) {
		c.setCompra(compraStatic);
		c.setDataComentario(Calendar.getInstance());
		comentarioDao.adiciona(c);
		Notificacao notificacao = new Notificacao();
		notificacao.setCampo1("Pedido: " + compraStatic.getCompraId());
		notificacao.setCampo2("Novo Comentario");
		notificacao.setCampo3("comentarioCompra?id=" + compraStatic.getCompraId());
		notificacao.setCampo4("1");
		notificacaoDao.adiciona(notificacao);
		// Status 1-novo e 2-visualizado
		return "redirect:comentarioCompra?id=" + compraStatic.getCompraId();
	}

	@RequestMapping("Aprovar")
	public String Aprovar(String tipo, Long id, Model model) {

		if (id == null && tipo.contains("presidente")) {
			model.addAttribute("Compras", compraDao.AprovacaoPresidente());
		} else if (id == null && tipo.contains("tesoureiro")) {
			model.addAttribute("Compras", compraDao.AprovacaoTesoureiro());
		} else if (id == null && tipo.contains("engenheiro")) {
			model.addAttribute("Compras", compraDao.AprovacaoEngenheiro());
		} else {
			compraStatic = compraDao.buscaPorId(id);
			model.addAttribute("Compras", compraDao.CompraPorId(compraStatic));
		}

		model.addAttribute("tipo", tipo);
		return "Compras/Aprovar";
	}

	@RequestMapping("aprovarCompra")
	public String AprovarCompra(String tipo, Long id, Model model, HttpSession session)
			throws MalformedURLException, EmailException {
		Usuario u = (Usuario) session.getAttribute("usuarioLogado");
		compraStatic = compraDao.buscaPorId(id);

		if (tipo.equals("presidente")) {
			compraStatic.setAprovacaoPresidente("3|" + u.getNome());
			compraStatic.setDataAprovacaoPresidente(Calendar.getInstance());
			compraDao.atualiza(compraStatic);
		} else if (tipo.equals("tesoureiro")) {
			compraStatic.setAprovacaoTesoureiro("3|" + u.getNome());
			compraStatic.setDataAprovacaoTesoureiro(Calendar.getInstance());
			compraDao.atualiza(compraStatic);
		} else if (tipo.equals("engenheiro")) {
			compraStatic.setAprovacaoEngenheiro("3|" + u.getNome());
			compraStatic.setDataAprovacaoEngenheiro(Calendar.getInstance());
			compraDao.atualiza(compraStatic);
		}
		if (compraStatic.getAprovacaoPresidente().contains("3|")
				&& compraStatic.getAprovacaoTesoureiro().contains("3|")) {
			compraStatic.setStatus("5-APROVADO");

		    @SuppressWarnings("unused")
			List<String> Comprador = usuarioDao.CarrefaEmailUsuarioPerfil("4"); 
			List<String> Presidente = usuarioDao.CarrefaEmailUsuarioPerfil("9");
			List<String> Tesoureiro = usuarioDao.CarrefaEmailUsuarioPerfil("2");
			List<String> Engenheiro = usuarioDao.CarrefaEmailUsuarioPerfil("10");
			
			Mail e = new Mail();
			e.sendEmailCompraAprovacao(Comprador,Presidente,Tesoureiro,Engenheiro, compraStatic.getSolicitante(), compraStatic.getEmailSolicitante(),
					"PEDIDO " + compraStatic.getCompraId().toString() + " APROVADO",
					compraStatic.getCompraId().toString(), "Confimação de Pedido aprovado",
					"Favor dar sequência na compra.");

			Notificacao notificacao = new Notificacao();
			notificacao.setCampo1("Pedido: " + compraStatic.getCompraId());
			notificacao.setCampo2("Aprovado");
			notificacao.setCampo3("Pedido?id=" + compraStatic.getCompraId());
			notificacao.setCampo4("1");
			notificacaoDao.adiciona(notificacao);
			// Status 1-novo e 2-visualizado

			compraDao.atualiza(compraStatic);
		}
		return "redirect:/Home";
	}

	@RequestMapping("reprovarCompra")
	public String reprovarCompra(String tipo, Long id, Model model, HttpSession session)
			throws MalformedURLException, EmailException {
		Usuario u = (Usuario) session.getAttribute("usuarioLogado");
		compraStatic = compraDao.buscaPorId(id);

		if (tipo.equals("presidente")) {
			compraStatic.setAprovacaoPresidente("2|" + u.getNome());
			compraStatic.setDataAprovacaoPresidente(Calendar.getInstance());
			compraDao.atualiza(compraStatic);
		} else if (tipo.equals("tesoureiro")) {
			compraStatic.setAprovacaoTesoureiro("2|" + u.getNome());
			compraStatic.setDataAprovacaoTesoureiro(Calendar.getInstance());
			compraDao.atualiza(compraStatic);
		} else if (tipo.equals("engenheiro")) {
			compraStatic.setAprovacaoEngenheiro("2|" + u.getNome());
			compraStatic.setDataAprovacaoEngenheiro(Calendar.getInstance());
			compraDao.atualiza(compraStatic);
		}

		if (compraStatic.getAprovacaoPresidente().contains("2|") || compraStatic.getAprovacaoTesoureiro().contains("2|")
				|| compraStatic.getAprovacaoEngenheiro().contains("2|")) {
			compraStatic.setStatus("10-REPROVADO");
			compraDao.atualiza(compraStatic);
		}

		Notificacao notificacao = new Notificacao();
		notificacao.setCampo1("Pedido: " + compraStatic.getCompraId());
		notificacao.setCampo2("Reprovado");
		notificacao.setCampo3("Pedido?id=" + compraStatic.getCompraId());
		notificacao.setCampo4("1");
		notificacaoDao.adiciona(notificacao);

		return "redirect:/Home";
	}

	@RequestMapping("AreaAprovacoes")
	public String TelaAprovacoes(Model model, HttpSession session) {
		String User = null;
		Usuario u = (Usuario) session.getAttribute("usuarioLogado");
		// if (u.getEmail().contains("rafa"))
		// User = "AprovacaoTesoureiro";
		// else if (u.getEmail().contains("antonioluiz-sp"))
		// User = "AprovacaoPresidente";
		// else if (u.getEmail().contains("feltrin"))
		// User = "AprovacaoEngenheiro";
		// else if (u.getEmail().contains("thesilasdesign"))
		User = "Todos";

		model.addAttribute("Compras", compraDao.AreaAprovacoes(User));

		return "Compras/AreaAprovacao";

	}

	@RequestMapping(value = "/GerarPDFCompra.pdf", method = RequestMethod.GET)
	public ModelAndView downloadPDF(Long id, Model model) {
		Compra a = (Compra) compraDao.BuscandoId(id);
		return new ModelAndView("pdfView", "listBooks", a);
	}

	@RequestMapping("Pagamento")
	public String FormaPagamento(Long id, Model model) {
		model.addAttribute("pagamentos", compraDao.BuscandoId(id).getPagamento());
		compraStatic = compraDao.BuscandoId(id);
		model.addAttribute("Compras", compraStatic);
		return "Compras/Pagamento";
	}

	@RequestMapping("CadastroPagamento")
	public String CadastroPagamento(Pagamento pagamento, Model model) {
		pagamento.setCompra(compraStatic);
		pagamentoDao.adiciona(pagamento);

		model.addAttribute("pagamentos", compraDao.buscaPorId(compraStatic.getCompraId()).getPagamento());
		compraStatic = compraDao.buscaPorId(compraStatic.getCompraId());

		return "redirect:Pagamento?id=" + pagamento.getCompra().getCompraId();
	}

	@RequestMapping("RemoverParcela")
	public String RemoverParcela(Long id) {
		pagamentoDao.removeById(id);

		return "redirect:Pagamento?id=" + compraStatic.getCompraId();
	}

	Conversoes c = new Conversoes();

	@RequestMapping("ArquivoCompra")
	public String Projetos(Long id, Model model) throws SocketException, IOException {
		String[] arq = null;
		arq = c.ListaFTP("ArquivoCompra/" + id + "/");

		compraStatic = compraDao.BuscandoId(id);

		model.addAttribute("files", arq);
		model.addAttribute("Compras", compraStatic);
		model.addAttribute("Pedido", compraStatic.getCompraId());

		return "Compras/ArquivoCompra";
	}

	/*
	 * <option>$STATUS</option>" <option>1-SOLICITADO</option>"; <option>2-ANALISE
	 * COMPRADOR</option>"; echo <option>3-PENDENTE
	 * INFORMAÃ‡ÃƒO</option>"; echo <option>4-AGUARDANDO APROVAÇÃO</option>";
	 * <option>5-APROVADO</option>"; <option>6-ORCAMENTO E COMPRA</option>"; echo
	 * <option>7-AGUARDANDO ENTREGA</option> "; echo <option>8-FINALIZADO</option>";
	 * echo " <option>9-CANCELADO</option>
	 * "; <option>10-REPROVADO</option> <option>11-TESOURARIA-OK</option>";
	 */

}

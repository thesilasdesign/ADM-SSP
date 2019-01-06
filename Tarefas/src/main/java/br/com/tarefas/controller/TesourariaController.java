package br.com.tarefas.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketException;

import javax.transaction.Transactional;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tarefas.config.Conversoes;
import br.com.tarefas.model.Compra;
import br.com.tarefas.service.CompraService;
import br.com.tarefas.service.PagamentoService;

@Transactional
@Controller
public class TesourariaController {
	
	@Autowired
	CompraService compraDao; // usa apenas a interface!
	@Autowired
	PagamentoService pagamentoDao; // usa apenas a interface!
	
	Conversoes c = new Conversoes();
	@RequestMapping("Planilha")
	public String Projetos(Model model) throws SocketException, IOException{
		String[] arq = null;
		
		arq=c.ListaFTP("Planilha");
		
		model.addAttribute("files", arq);
		return "Tesouraria/Planilha";
	}
	
	@RequestMapping("PainelComprasTesouraria")
	public String Painel(Model model) throws EmailException, MalformedURLException {
		model.addAttribute("Compras", compraDao.lista());
		return "Tesouraria/PainelCompras";
	}
//	
	@RequestMapping("Pagamentos")
	public String Pagamentos(Model model)  {
		model.addAttribute("Compras", compraDao.PedidosFinalizados());
		return "Tesouraria/Pagamentos";
	}
	
	@RequestMapping("ShowPedido")
	public String ShowPedido(Model model, Long id)  {
		model.addAttribute("Compras", compraDao.BuscandoId(id));
		model.addAttribute("pagamentos", compraDao.BuscandoId(id).getPagamento());
		
		return "Tesouraria/Parcelas";
	}
	
	@RequestMapping("ConcluirPedido")
	public String ConcluirPedido(Model model, Long id)  {
		
		Compra compra = compraDao.BuscandoId(id);
		
		if (compra !=null) {
			compra.setStatus("11-TESOURARIA-OK");
			compraDao.atualiza(compra);
		}
		
		return "redirect:Pagamentos";
	}
	
}

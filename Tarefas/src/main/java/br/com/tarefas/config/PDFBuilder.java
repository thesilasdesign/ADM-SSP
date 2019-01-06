package br.com.tarefas.config;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.tarefas.model.Comentario;
import br.com.tarefas.model.Compra;
import br.com.tarefas.model.CompraItem;
import br.com.tarefas.model.Seguro;
import br.com.tarefas.model.SeguroTrabalho;

/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 * 
 * @author www.codejava.net
 *
 */
@Transactional
@Controller
public class PDFBuilder extends AbstractITextPdfView {

	@SuppressWarnings("unused")
	private static Font catFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
	private static Font redFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.RED);
	private static Font subFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
	private static Font Helvetica = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);

	public String converteData(Calendar data) {
		String dt = null;
		try {
			Calendar c = data;
			SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
			dt = s.format(c.getTime());

		} catch (Exception e) {
			// TODO: handle exception
		}
		return dt;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Compra compra = (Compra) model.get("listBooks");
		String tipo = (String) model.get("tipo");
		List<SeguroTrabalho> listSeguroTrabalho = (List<SeguroTrabalho>) model.get("listSeguroTrab");
		List<Seguro> listSeguroMinisterio = (List<Seguro>) model.get("listSeguro");

		if (listSeguroTrabalho != null) {

			Anchor anchor = new Anchor("Dados Solicitante:", redFont);
			anchor.setName("Dados Solicitante:");

			// Second parameter is the number of the chapter
			Chapter catPart = new Chapter(new Paragraph(anchor), 1);

			doc.add(new Paragraph("CONGREGAï¿½ï¿½O CRISTï¿½ NO BRASIL", smallBold));
			doc.add(new Paragraph("FORMULARIO P/ IMPLANTAï¿½ï¿½O E MOVIMENTAï¿½ï¿½O DO SEGURO DE ACIDENTES PESSOAIS",
					smallBold));
			doc.add(new Paragraph("VOLUNTARIOS ADMINISTRAï¿½ï¿½O JANDIRA - CNPJ: 09.273.888/0001-00", smallBold));
			doc.add(new Paragraph(" ", smallBold));

			doc.add(new Paragraph("Bairro/Comum: " + listSeguroTrabalho.get(0).getComum(), Helvetica));
			doc.add(new Paragraph("Responsï¿½vel ADM: Issac Santos", Helvetica));
			doc.add(new Paragraph("Telefone: 4321-9505", Helvetica));
			doc.add(new Paragraph(
					"Mï¿½s Competiencia: " + converteData(listSeguroTrabalho.get(0).getData()).substring(3, 5) + "/2017",
					Helvetica));
			doc.add(new Paragraph(" ", smallBold));

			if (tipo == "2")
				doc.add(new Paragraph("Relaï¿½ï¿½o Nomes e Datas - Voluntï¿½rios", smallBold));
			else if (tipo == "1")
				doc.add(new Paragraph("Relaï¿½ï¿½o Nomes - Ministï¿½rio", smallBold));

			doc.add(new Paragraph(" ", smallBold));
			Integer qtde = 0;
			if (tipo.equals("2")) {
				for (SeguroTrabalho seguroTrabalho : listSeguroTrabalho) {
					doc.add(new Paragraph(
							seguroTrabalho.getSeguro().getNome() + " - CPF: " + seguroTrabalho.getSeguro().getCpf()
									+ " - Data: " + converteData(seguroTrabalho.getData()) + " - Custo Diï¿½rio: R$ 0,61",
							Helvetica));
					qtde++;
				}
				Double a = 0.61 * qtde;
				doc.add(new Paragraph(" ", smallBold));
				doc.add(new Paragraph("Valor Total: " + a.toString(), Helvetica));
			} else if (tipo.equals("1")) {
				// for (Seguro seguro : listSeguro) {
				// doc.add(new Paragraph(
				// seguroTrabalho.getSeguro().getNome() + " - CPF: " +
				// seguroTrabalho.getSeguro().getCpf()
				// + " - Data: " + converteData(seguroTrabalho.getData()) + " -
				// Custo diÃ¡rio: R$ 0,61",
				// Helvetica));
				// qtde++;
				// }
				Double a = 0.61 * qtde;
				doc.add(new Paragraph(" ", smallBold));
				doc.add(new Paragraph("Valor Total: " + a.toString(), Helvetica));
			}

		} else if (listSeguroMinisterio != null) {
			Anchor anchor = new Anchor("Dados Solicitante:", redFont);
			anchor.setName("Dados Solicitante:");

			// Second parameter is the number of the chapter
			Chapter catPart = new Chapter(new Paragraph(anchor), 1);

			doc.add(new Paragraph("CONGREGAÇÃO CRISTÃ NO BRASIL", smallBold));
			doc.add(new Paragraph("FORMULARIO P/ IMPLANTAï¿½ï¿½O E MOVIMENTAï¿½ï¿½O DO SEGURO DE ACIDENTES PESSOAIS",
					smallBold));
			doc.add(new Paragraph("VOLUNTARIOS ADMINISTRAï¿½ï¿½O JANDIRA - CNPJ: 09.273.888/0001-00", smallBold));
			doc.add(new Paragraph(" ", smallBold));

			doc.add(new Paragraph("Bairro/Comum: Jandira - SP", Helvetica));
			doc.add(new Paragraph("Responsï¿½vel ADM: Issac Santos", Helvetica));
			doc.add(new Paragraph("Telefone: 4321-9505", Helvetica));
			doc.add(new Paragraph("Ano Competï¿½ncia: 2016", Helvetica));
			doc.add(new Paragraph(" ", smallBold));

			doc.add(new Paragraph("Relaï¿½ï¿½o Nomes - Ministï¿½rio", smallBold));

			doc.add(new Paragraph(" ", smallBold));
			Integer qtde = 0;
			if (tipo.equals("1")) {
				for (Seguro seguro : listSeguroMinisterio) {
					doc.add(new Paragraph(
							seguro.getNome() + " - CPF: " + seguro.getCpf()
									+ " - Custo Mensal: R$ 12,87",
							Helvetica));
					qtde++;
				}
				Double a = 12.87 * qtde;
				doc.add(new Paragraph(" ", smallBold));
				doc.add(new Paragraph("Valor Total: " + a.toString(), Helvetica));
			} else if (tipo.equals("1")) {
				// for (Seguro seguro : listSeguro) {
				// doc.add(new Paragraph(
				// seguroTrabalho.getSeguro().getNome() + " - CPF: " +
				// seguroTrabalho.getSeguro().getCpf()
				// + " - Data: " + converteData(seguroTrabalho.getData()) + " -
				// Custo diÃ¡rio: R$ 0,61",
				// Helvetica));
				// qtde++;
				// }
				Double a = 0.61 * qtde;
				doc.add(new Paragraph(" ", smallBold));
				doc.add(new Paragraph("Valor Total: " + a.toString(), Helvetica));
			}

		}
		if (compra != null)

		{
			PdfName pdfName = newName("Pedido_" + compra.getCompraId() + ".pdf");
			Anchor anchor = new Anchor("Dados Solicitante:", redFont);
			anchor.setName("Dados Solicitante:");

			// Second parameter is the number of the chapter
			Chapter catPart = new Chapter(new Paragraph(anchor), 1);

			doc.add(new Paragraph("CONGREGAÇÃO CRISTÃ NO BRASIL", subFont));
			doc.add(new Paragraph("ADMINISTRAÇÃO JANDIRA - CNPJ: 09.273.888/0001-00", subFont));
			doc.add(new Paragraph("RUA ANDRÉ VIDAL DE NEGREIROS, 96 - CENTRO - JANDIRA - CEP 06600-140", smallBold));

			// define font for table header row
			Font font = FontFactory.getFont(FontFactory.HELVETICA);
			font.setColor(BaseColor.BLACK);
			
//			String imageUrl = "https://uploaddeimagens.com.br/images/001/267/777/original/imagem.jpg?";
//			Image image2 = Image.getInstance(new URL(imageUrl));
//			
//			image2.scaleAbsolute(500f, 500f);
//			doc.add(image2);
			Paragraph espaco = new Paragraph("", smallBold);
			doc.add(espaco);
			doc.add(new Paragraph(" ", Helvetica));
			doc.add(new Paragraph(" ", Helvetica));
			doc.add(new Paragraph("PROVISÓRIO                                                                DESPESAS ", smallBold));
			PdfPTable tableini = new PdfPTable(2);
			tableini.setWidthPercentage(100.0f);
			tableini.setWidths(new float[] {3.0f, 3.0f});
			tableini.setSpacingBefore(10);
			// define table header cell
			PdfPCell cellini = new PdfPCell();
			cellini.setBackgroundColor(BaseColor.WHITE);
			cellini.setPadding(8);

			// write table header
			cellini.setPhrase(new Phrase("", font));
			tableini.addCell(cellini);

			cellini.setPhrase(new Phrase("", font));
			tableini.addCell(cellini);
			doc.add(tableini);	
			doc.add(new Paragraph(" ", Helvetica));
			doc.add(new Paragraph("OBSERVAÇÃO:", smallBold));
			doc.add(new Paragraph(" ", Helvetica));
			doc.add(new Paragraph(" ", Helvetica));
			doc.add(new Paragraph(" ", Helvetica));
						
			doc.add(new Paragraph("COMPRAS:", smallBold));
			doc.add(new Paragraph("ENTRADA SETOR:", smallBold));
			doc.add(new Paragraph(" ", Helvetica));
			
			doc.add(new Paragraph("DIGITALIZAÇÃO:", smallBold));
			doc.add(new Paragraph("ENTRADA SETOR:", smallBold));
			doc.add(new Paragraph(" ", Helvetica));
			
			doc.add(new Paragraph("TESOURARIA:", smallBold));
			doc.add(new Paragraph("ENTRADA SETOR:", smallBold));
			doc.add(new Paragraph(" ", Helvetica));
			
			doc.add(new Paragraph("DIGITALIZAÇÃO:", smallBold));
			doc.add(new Paragraph("ENTRADA SETOR:", smallBold));
			doc.add(new Paragraph(" ", Helvetica));
			
			doc.add(new Paragraph("CONTABILIDADE:", smallBold));
			doc.add(new Paragraph("ENTRADA SETOR:", smallBold));
			doc.add(new Paragraph(" ", Helvetica));
			
			doc.add(new Paragraph("CONSELHO FISCAL:", smallBold));
			doc.add(new Paragraph("ENTRADA SETOR:", smallBold));
			doc.add(new Paragraph(" ", Helvetica));
			
			doc.add(new Paragraph("Dados Pedido: ", smallBold));
			doc.add(new Paragraph("Numero do Pedido: " + compra.getCompraId(), Helvetica));
			doc.add(new Paragraph("Data Solicitação: " + converteData(compra.getDataAbertura()), Helvetica));
			doc.add(new Paragraph("Casa de Oração Solicitante: " + compra.getComum(), Helvetica));
			doc.add(new Paragraph("Justificativa: " + compra.getDescricao(), Helvetica));
			doc.add(new Paragraph(" ", Helvetica));
			Paragraph dadosSolicitante = new Paragraph("", smallBold);
			Section subCatPart = catPart.addSection(dadosSolicitante);
			doc.add(new Paragraph("Dados Solicitante", smallBold));
			doc.add(new Paragraph("Nome: " + compra.getSolicitante(), Helvetica));
			doc.add(new Paragraph("E-mail: " + compra.getEmailSolicitante(), Helvetica));
			doc.add(new Paragraph("Comprador: " + compra.getComprador(), Helvetica));
			doc.add(new Paragraph("Status Pedido: " + compra.getStatus(), Helvetica));
			doc.add(new Paragraph(" ", Helvetica));

			doc.add(new Paragraph("Dados Aprovação", smallBold));
			doc.add(new Paragraph("Presidente: Antonio Luiz da Silva Pereira, Data Aprovação: "
					+ converteData(compra.getDataAprovacaoPresidente()), Helvetica));
			doc.add(new Paragraph("Tesoureiro: Adailton Carlos Procópio Miranda, Data Aprovação: "
					+ converteData(compra.getDataAprovacaoTesoureiro()), Helvetica));
			doc.add(new Paragraph("Engenheiro: Douglas Visnyei Feltrin, Data Aprovação: "
					+ converteData(compra.getDataAprovacaoEngenheiro()), Helvetica));
			doc.add(new Paragraph(" ", Helvetica));
			

			doc.add(new Paragraph("Dados Entrega", smallBold));
			doc.add(new Paragraph("Entrega para: " + compra.getPessoa(), Helvetica));
			doc.add(new Paragraph(
					"Data Hora Entraga: " + converteData(compra.getDataEntrega()) + " as " + compra.getHoraEntrega(),
					Helvetica));
			doc.add(new Paragraph("Telefone para Dúvidas: " + compra.getTelefone(), Helvetica));
			doc.add(new Paragraph("Endereço: " + compra.getEnderecoEntrega(), Helvetica));
			doc.add(new Paragraph(" ", Helvetica));

			

			doc.add(new Paragraph(" ", Helvetica));

			doc.add(new Paragraph("Comentários do Pedido: " + compra.getCompraId(), smallBold));
			List<Comentario> listComentario = (List<Comentario>) compra.getComentario();

			for (int i = 0; i < listComentario.size(); i++) {
				doc.add(new Paragraph("Nome Usuário: " + listComentario.get(i).getNome(), Helvetica));
				doc.add(new Paragraph("Data Comentário: " + converteData(listComentario.get(i).getDataComentario()),
						Helvetica));
				doc.add(new Paragraph("Comentários: " + listComentario.get(i).getTexto(), Helvetica));
				doc.add(new Paragraph("     ", Helvetica));
			}

			doc.add(new Paragraph("Itens do Pedido: " + compra.getCompraId(), smallBold));

			PdfPTable table = new PdfPTable(4);
			
			table.setWidthPercentage(100.0f);
			table.setWidths(new float[] {0.5f, 3.0f, 1.0f, 1.0f });
			table.setSpacingBefore(10);

			// define table header cell
			PdfPCell cell = new PdfPCell();
			cell.setBackgroundColor(BaseColor.WHITE);
			cell.setPadding(8);

			// write table header
			cell.setPhrase(new Phrase("Qtde", font));
			table.addCell(cell);

			cell.setPhrase(new Phrase("Marca/Modelo", font));
			table.addCell(cell);

			cell.setPhrase(new Phrase("Vlr Unid", font));
			table.addCell(cell);

			cell.setPhrase(new Phrase("Vlr Total", font));
			table.addCell(cell);

			// write table row data
			List<CompraItem> list = (List<CompraItem>) compra.getCompraItem();
			String ValorTotal;
			Integer ValorFinalInt = 0, ValorFinal = 0;
			NumberFormat convValor = NumberFormat.getCurrencyInstance();
			DecimalFormat df = new DecimalFormat("0.##");
			Float teste = (float) 0.0;
			for (CompraItem item : list) {
				table.addCell(String.valueOf(item.getQuantidade()));
				table.addCell(item.getMarcaModelo());
				table.addCell(String.valueOf(convValor.format(item.getValorUnidade())));
				table.addCell(String.valueOf(convValor.format(item.getValorTotal())));
				ValorTotal = String.valueOf(item.getValorTotal());
				ValorTotal = ValorTotal.replace(".", "");
				ValorFinal = Integer.parseInt(ValorTotal);
				ValorFinalInt = ValorFinalInt + ValorFinal;
				teste = teste + item.getValorTotal();
			}
			doc.add(table);
			doc.add(new Paragraph("                                                                                                                      Valor Total: " + convValor.format(compra.getValorTotal()), smallBold));
		}
	}
}

package br.com.tarefas.config;

import java.net.MalformedURLException;
import java.util.Collection;
import java.util.List;

import javax.mail.internet.InternetAddress;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.tarefas.model.Usuario;
import br.com.tarefas.service.UsuarioService;

public class Mail {

	@Autowired
	UsuarioService usuarioDao; // usa apenas a interface!

	@SuppressWarnings("deprecation")
	public void sendEmailSenhaNova(String Nome, String email, String titulo, String Pedido, String msg1, String msg2)
			throws EmailException, MalformedURLException {

		HtmlEmail email1 = new HtmlEmail();

		email1.setHostName("mail.ccbspp.com.br");
		email1.setSmtpPort(465);
		email1.addTo(email, Nome);
		email1.setFrom("sistema@ccbspp.com.br", "Informatica - CCB");
		email1.setSubject(titulo);

		email1.setHtmlMsg("<!doctype html>\r\n" + 
				" <html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n" + 
				" <head>\r\n" + 
				"  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n" + 
				"  <meta name=\"viewport\" content=\"initial-scale=1.0\" />\r\n" + 
				"  <meta name=\"format-detection\" content=\"telephone=no\" />\r\n" + 
				"  <title></title>\r\n" + 
				"  <style type=\"text/css\">\r\n" + 
				" 	body {\r\n" + 
				"		width: 100%;\r\n" + 
				"		margin: 0;\r\n" + 
				"		padding: 0;\r\n" + 
				"		-webkit-font-smoothing: antialiased;\r\n" + 
				"	}\r\n" + 
				"	@media only screen and (max-width: 600px) {\r\n" + 
				"		table[class=\"table-row\"] {\r\n" + 
				"			float: none !important;\r\n" + 
				"			width: 98% !important;\r\n" + 
				"			padding-left: 20px !important;\r\n" + 
				"			padding-right: 20px !important;\r\n" + 
				"		}\r\n" + 
				"		table[class=\"table-row-fixed\"] {\r\n" + 
				"			float: none !important;\r\n" + 
				"			width: 98% !important;\r\n" + 
				"		}\r\n" + 
				"		table[class=\"table-col\"], table[class=\"table-col-border\"] {\r\n" + 
				"			float: none !important;\r\n" + 
				"			width: 100% !important;\r\n" + 
				"			padding-left: 0 !important;\r\n" + 
				"			padding-right: 0 !important;\r\n" + 
				"			table-layout: fixed;\r\n" + 
				"		}\r\n" + 
				"		td[class=\"table-col-td\"] {\r\n" + 
				"			width: 100% !important;\r\n" + 
				"		}\r\n" + 
				"		table[class=\"table-col-border\"] + table[class=\"table-col-border\"] {\r\n" + 
				"			padding-top: 12px;\r\n" + 
				"			margin-top: 12px;\r\n" + 
				"			border-top: 1px solid #E8E8E8;\r\n" + 
				"		}\r\n" + 
				"		table[class=\"table-col\"] + table[class=\"table-col\"] {\r\n" + 
				"			margin-top: 15px;\r\n" + 
				"		}\r\n" + 
				"		td[class=\"table-row-td\"] {\r\n" + 
				"			padding-left: 0 !important;\r\n" + 
				"			padding-right: 0 !important;\r\n" + 
				"		}\r\n" + 
				"		table[class=\"navbar-row\"] , td[class=\"navbar-row-td\"] {\r\n" + 
				"			width: 100% !important;\r\n" + 
				"		}\r\n" + 
				"		img {\r\n" + 
				"			max-width: 100% !important;\r\n" + 
				"			display: inline !important;\r\n" + 
				"		}\r\n" + 
				"		img[class=\"pull-right\"] {\r\n" + 
				"			float: right;\r\n" + 
				"			margin-left: 11px;\r\n" + 
				"            max-width: 125px !important;\r\n" + 
				"			padding-bottom: 0 !important;\r\n" + 
				"		}\r\n" + 
				"		img[class=\"pull-left\"] {\r\n" + 
				"			float: left;\r\n" + 
				"			margin-right: 11px;\r\n" + 
				"			max-width: 125px !important;\r\n" + 
				"			padding-bottom: 0 !important;\r\n" + 
				"		}\r\n" + 
				"		table[class=\"table-space\"], table[class=\"header-row\"] {\r\n" + 
				"			float: none !important;\r\n" + 
				"			width: 98% !important;\r\n" + 
				"		}\r\n" + 
				"		td[class=\"header-row-td\"] {\r\n" + 
				"			width: 100% !important;\r\n" + 
				"		}\r\n" + 
				"	}\r\n" + 
				"	@media only screen and (max-width: 480px) {\r\n" + 
				"		table[class=\"table-row\"] {\r\n" + 
				"			padding-left: 16px !important;\r\n" + 
				"			padding-right: 16px !important;\r\n" + 
				"		}\r\n" + 
				"	}\r\n" + 
				"	@media only screen and (max-width: 320px) {\r\n" + 
				"		table[class=\"table-row\"] {\r\n" + 
				"			padding-left: 12px !important;\r\n" + 
				"			padding-right: 12px !important;\r\n" + 
				"		}\r\n" + 
				"	}\r\n" + 
				"	@media only screen and (max-width: 608px) {\r\n" + 
				"		td[class=\"table-td-wrap\"] {\r\n" + 
				"			width: 100% !important;\r\n" + 
				"		}\r\n" + 
				"	}\r\n" + 
				"  </style>\r\n" + 
				" </head>\r\n" + 
				" <body style=\"font-family: Arial, sans-serif; font-size:13px; color: #444444; min-height: 200px;\" bgcolor=\"#E4E6E9\" leftmargin=\"0\" topmargin=\"0\" marginheight=\"0\" marginwidth=\"0\">\r\n" + 
				" <table width=\"100%\" height=\"100%\" bgcolor=\"#E4E6E9\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n" + 
				" <tr><td width=\"100%\" align=\"center\" valign=\"top\" bgcolor=\"#E4E6E9\" style=\"background-color:#E4E6E9; min-height: 200px;\">\r\n" + 
				"<table><tr><td class=\"table-td-wrap\" align=\"center\" width=\"608\"><div style=\"font-family: Arial, sans-serif; line-height: 32px; color: #444444; font-size: 13px;\">\r\n" + 
				"  <a href=\"#\" style=\"color: #478fca; text-decoration: none; font-size: 14px; background-color: transparent;\">\r\n" + 
				"  </a>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<table class=\"table-row\" style=\"table-layout: auto; padding-right: 24px; padding-left: 24px; width: 600px; background-color: #ffffff;\" bgcolor=\"#FFFFFF\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr height=\"55px\" style=\"font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; height: 55px;\">\r\n" + 
				"   <td class=\"table-row-td\" style=\"height: 55px; padding-right: 16px; font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; font-weight: normal; vertical-align: middle;\" valign=\"middle\" align=\"center\">\r\n" + 
				"     <a href=\"#\" align= \"center\" 	style=\"color: #428bca; text-decoration: none; padding: 0px; font-size: 18px; line-height: 20px; height: 50px; background-color: transparent;\">\r\n" + 
				"	  Administração Santana de Parnaiba e Pirapora\r\n" + 
				"	 </a>\r\n" + 
				"   </td>\r\n" + 
				" \r\n" + 
				"</tr></tbody></table>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<table class=\"table-space\" height=\"6\" style=\"height: 6px; font-size: 0px; line-height: 0; width: 600px; background-color: #e4e6e9;\" width=\"600\" bgcolor=\"#E4E6E9\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-space-td\" valign=\"middle\" height=\"6\" style=\"height: 6px; width: 600px; background-color: #e4e6e9;\" width=\"600\" bgcolor=\"#E4E6E9\" align=\"left\">&nbsp;</td></tr></tbody></table>\r\n" + 
				"<table class=\"table-space\" height=\"16\" style=\"height: 16px; font-size: 0px; line-height: 0; width: 600px; background-color: #ffffff;\" width=\"600\" bgcolor=\"#FFFFFF\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-space-td\" valign=\"middle\" height=\"16\" style=\"height: 16px; width: 600px; background-color: #ffffff;\" width=\"600\" bgcolor=\"#FFFFFF\" align=\"left\">&nbsp;</td></tr></tbody></table>\r\n" + 
				"\r\n" + 
				"<table class=\"table-row\" width=\"600\" bgcolor=\"#FFFFFF\" style=\"table-layout: fixed; background-color: #ffffff;\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-row-td\" style=\"font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; font-weight: normal; padding-left: 24px; padding-right: 24px;\" valign=\"top\" align=\"left\">\r\n" + 
				"\r\n" + 
				"</td></tr></tbody></table>\r\n" + 
				"\r\n" + 
				"<table class=\"table-row\" width=\"600\" bgcolor=\"#FFFFFF\" style=\"table-layout: fixed; background-color: #ffffff;\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-row-td\" style=\"font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; font-weight: normal; padding-left: 36px; padding-right: 36px;\" valign=\"top\" align=\"left\">\r\n" + 
				"   <table class=\"table-col\" align=\"left\" width=\"528\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" style=\"table-layout: fixed;\"><tbody><tr><td class=\"table-col-td\" width=\"528\" style=\"font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; font-weight: normal;\" valign=\"top\" align=\"left\">\r\n" + 
				"	 <table class=\"header-row\" width=\"528\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" style=\"table-layout: fixed;\"><tbody><tr><td class=\"header-row-td\" width=\"528\" style=\"font-size: 24px; margin: 0px; font-family: Arial, sans-serif; font-weight: normal; line-height: 19px; color: #478fca; padding-bottom: 10px; padding-top: 15px;\" valign=\"top\" align=\"left\">Paz de Deus,</td></tr></tbody></table>\r\n" + 
				"	 <table class=\"header-row\" width=\"528\" <td> <br></td></table>\r\n" + 
				"	 <table class=\"header-row\" width=\"528\" <td> Recuperação de Senha:</td></table>\r\n" + 
				"	 <table class=\"header-row\" width=\"528\" <td> Sua Nova Senha é 123qwe!@#:</td></table>\r\n" + 
				"	 <table class=\"header-row\" width=\"528\" <td> <br>Favor entrar no sistema usando está senha e alterar no Perfil uma nova.</td></table>\r\n" + 
				"	 <table class=\"header-row\" width=\"528\" <td> </td></table>\r\n" + 
				"	 <table class=\"header-row\" width=\"528\" <td> Deus Abençoe</td></table>\r\n" + 
				"	 <table class=\"header-row\" width=\"528\" <td> Administração Santana de Parnaiba e Pirapora </td></table>\r\n" + 
				"	 <table class=\"header-row\" width=\"528\" <td> <br></td></table>\r\n" + 
				"   </td></tr></tbody></table>\r\n" + 
				"</td></tr></tbody></table>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<table class=\"table-space\" height=\"6\" style=\"height: 6px; font-size: 0px; line-height: 0; width: 600px; background-color: #e4e6e9;\" width=\"600\" bgcolor=\"#E4E6E9\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-space-td\" valign=\"middle\" height=\"6\" style=\"height: 6px; width: 600px; background-color: #e4e6e9;\" width=\"600\" bgcolor=\"#E4E6E9\" align=\"left\">&nbsp;</td></tr></tbody></table>\r\n" + 
				"<table class=\"table-row\" width=\"600\" bgcolor=\"#FFFFFF\" style=\"table-layout: fixed; background-color: #ffffff;\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-row-td\" style=\"font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; font-weight: normal; padding-left: 36px; padding-right: 36px;\" valign=\"top\" align=\"left\">\r\n" + 
				" <table class=\"table-col\" align=\"left\" width=\"528\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" style=\"table-layout: fixed;\"><tbody><tr><td class=\"table-col-td\" width=\"528\" style=\"font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; font-weight: normal;\" valign=\"top\" align=\"left\">\r\n" + 
				"	 <table class=\"table-space\" height=\"16\" style=\"height: 16px; font-size: 0px; line-height: 0; width: 528px; background-color: #ffffff;\" width=\"528\" bgcolor=\"#FFFFFF\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-space-td\" valign=\"middle\" height=\"16\" style=\"height: 16px; width: 528px; background-color: #ffffff;\" width=\"528\" bgcolor=\"#FFFFFF\" align=\"left\">&nbsp;</td></tr></tbody></table>\r\n" + 
				"	 <div style=\"font-family: Arial, sans-serif; line-height: 19px; color: #777777; font-size: 14px; text-align: center;\">&copy; 2019 Congregação Cristã no Brasil </div>\r\n" + 
				"	 <table class=\"table-space\" height=\"12\" style=\"height: 12px; font-size: 0px; line-height: 0; width: 528px; background-color: #ffffff;\" width=\"528\" bgcolor=\"#FFFFFF\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-space-td\" valign=\"middle\" height=\"12\" style=\"height: 12px; width: 528px; background-color: #ffffff;\" width=\"528\" bgcolor=\"#FFFFFF\" align=\"left\">&nbsp;</td></tr></tbody></table>\r\n" + 
				"	\r\n" + 
				"	 <table class=\"table-space\" height=\"16\" style=\"height: 16px; font-size: 0px; line-height: 0; width: 528px; background-color: #ffffff;\" width=\"528\" bgcolor=\"#FFFFFF\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-space-td\" valign=\"middle\" height=\"16\" style=\"height: 16px; width: 528px; background-color: #ffffff;\" width=\"528\" bgcolor=\"#FFFFFF\" align=\"left\">&nbsp;</td></tr></tbody></table>\r\n" + 
				" </td></tr></tbody></table>\r\n" + 
				"</td></tr></tbody></table>\r\n" + 
				"<table class=\"table-space\" height=\"8\" style=\"height: 8px; font-size: 0px; line-height: 0; width: 600px; background-color: #e4e6e9;\" width=\"600\" bgcolor=\"#E4E6E9\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-space-td\" valign=\"middle\" height=\"8\" style=\"height: 8px; width: 600px; background-color: #e4e6e9;\" width=\"600\" bgcolor=\"#E4E6E9\" align=\"left\">&nbsp;</td></tr></tbody></table></td></tr></table>\r\n" + 
				"</td></tr>\r\n" + 
				" </table>\r\n" + 
				" </body>\r\n" + 
				" </html>");
		// configure uma mensagem alternativa caso o servidor nï¿½o suporte HTML
		email1.setTextMsg("Seu servidor de e-mail não suporta mensagem HTML");
		email1.setSSL(true);
		email1.setDebug(true);
		email1.setAuthentication("sistema@ccbspp.com.br", "123@iniciar");
		// envia o e-mail
		email1.send();

	}

	@SuppressWarnings("deprecation")
	public void sendEmailInformatica(String Nome, String email, String titulo, String Pedido, String msg1, String msg2,
			String msg3) throws EmailException, MalformedURLException {

		HtmlEmail email1 = new HtmlEmail();

		email1.setHostName("mail.ccbspp.com.br");
		email1.setSmtpPort(465);
		email1.addTo(email, Nome);
		email1.addCc("gildasio.gomes@congregacao.org.br", "Gildasio Gomes");
		email1.setFrom("thesilasdesign@gmail.com", "Informática - CCB");
		email1.setSubject(titulo);

		email1.setHtmlMsg("<html>\n" + "<body>\n" + "<h4> " + msg1 + "</h4>\n" + "<h2> " + msg2 + "</h2>\n" + "<h2> "
				+ msg3 + "</h2>\n" + "<p>Mensagem enviada pelo Sistema."
				+ "<a href=\"http://www.jandiraccb.com.br\"><b>JandiraCCB!</b></a></p>\n" + "</body>\n" + "</html>");
		// configure uma mensagem alternativa caso o servidor nï¿½o suporte HTML
		email1.setTextMsg("Seu servidor de e-mail não suporta mensagem HTML");
		email1.setSSL(true);
		email1.setAuthentication("sistema@ccbspp.com.br", "123@iniciar");
		// envia o e-mail
		email1.send();
	}

	@SuppressWarnings("deprecation")
	public void sendEmailEquipeCompras(List<String> Comprador,List<String> Presidente, List<String> Tesoureiro, List<String> Engenharia, String Nome, String email, String titulo, String Pedido, String msg1,
			String msg2) throws EmailException, MalformedURLException {

		HtmlEmail email1 = new HtmlEmail();

		email1.setHostName("mail.jandiraccb.com.br");
		email1.setSmtpPort(465);
		email1.addTo(email, Nome);

		for (int i = 0; i < Comprador.size(); i++) {
			email1.addCc(Comprador.get(i));
		}
		for (int i = 0; i < Presidente.size(); i++) {
			email1.addCc(Presidente.get(i));
		}
		for (int i = 0; i < Tesoureiro.size(); i++) {
			email1.addCc(Tesoureiro.get(i));
		}
		for (int i = 0; i < Engenharia.size(); i++) {
			email1.addCc(Engenharia.get(i));
		}
		email1.addCc("thesilasdesign@gmail.com", "Silas Oliveira");
		email1.setFrom("sistema@ccbspp.com.br", "Informática - Jandira CCB");
		email1.setSubject(titulo);

		email1.setHtmlMsg("<!doctype html>\r\n" + 
				" <html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n" + 
				" <head>\r\n" + 
				"  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n" + 
				"  <meta name=\"viewport\" content=\"initial-scale=1.0\" />\r\n" + 
				"  <meta name=\"format-detection\" content=\"telephone=no\" />\r\n" + 
				"  <title></title>\r\n" + 
				"  <style type=\"text/css\">\r\n" + 
				" 	body {\r\n" + 
				"		width: 100%;\r\n" + 
				"		margin: 0;\r\n" + 
				"		padding: 0;\r\n" + 
				"		-webkit-font-smoothing: antialiased;\r\n" + 
				"	}\r\n" + 
				"	@media only screen and (max-width: 600px) {\r\n" + 
				"		table[class=\"table-row\"] {\r\n" + 
				"			float: none !important;\r\n" + 
				"			width: 98% !important;\r\n" + 
				"			padding-left: 20px !important;\r\n" + 
				"			padding-right: 20px !important;\r\n" + 
				"		}\r\n" + 
				"		table[class=\"table-row-fixed\"] {\r\n" + 
				"			float: none !important;\r\n" + 
				"			width: 98% !important;\r\n" + 
				"		}\r\n" + 
				"		table[class=\"table-col\"], table[class=\"table-col-border\"] {\r\n" + 
				"			float: none !important;\r\n" + 
				"			width: 100% !important;\r\n" + 
				"			padding-left: 0 !important;\r\n" + 
				"			padding-right: 0 !important;\r\n" + 
				"			table-layout: fixed;\r\n" + 
				"		}\r\n" + 
				"		td[class=\"table-col-td\"] {\r\n" + 
				"			width: 100% !important;\r\n" + 
				"		}\r\n" + 
				"		table[class=\"table-col-border\"] + table[class=\"table-col-border\"] {\r\n" + 
				"			padding-top: 12px;\r\n" + 
				"			margin-top: 12px;\r\n" + 
				"			border-top: 1px solid #E8E8E8;\r\n" + 
				"		}\r\n" + 
				"		table[class=\"table-col\"] + table[class=\"table-col\"] {\r\n" + 
				"			margin-top: 15px;\r\n" + 
				"		}\r\n" + 
				"		td[class=\"table-row-td\"] {\r\n" + 
				"			padding-left: 0 !important;\r\n" + 
				"			padding-right: 0 !important;\r\n" + 
				"		}\r\n" + 
				"		table[class=\"navbar-row\"] , td[class=\"navbar-row-td\"] {\r\n" + 
				"			width: 100% !important;\r\n" + 
				"		}\r\n" + 
				"		img {\r\n" + 
				"			max-width: 100% !important;\r\n" + 
				"			display: inline !important;\r\n" + 
				"		}\r\n" + 
				"		img[class=\"pull-right\"] {\r\n" + 
				"			float: right;\r\n" + 
				"			margin-left: 11px;\r\n" + 
				"            max-width: 125px !important;\r\n" + 
				"			padding-bottom: 0 !important;\r\n" + 
				"		}\r\n" + 
				"		img[class=\"pull-left\"] {\r\n" + 
				"			float: left;\r\n" + 
				"			margin-right: 11px;\r\n" + 
				"			max-width: 125px !important;\r\n" + 
				"			padding-bottom: 0 !important;\r\n" + 
				"		}\r\n" + 
				"		table[class=\"table-space\"], table[class=\"header-row\"] {\r\n" + 
				"			float: none !important;\r\n" + 
				"			width: 98% !important;\r\n" + 
				"		}\r\n" + 
				"		td[class=\"header-row-td\"] {\r\n" + 
				"			width: 100% !important;\r\n" + 
				"		}\r\n" + 
				"	}\r\n" + 
				"	@media only screen and (max-width: 480px) {\r\n" + 
				"		table[class=\"table-row\"] {\r\n" + 
				"			padding-left: 16px !important;\r\n" + 
				"			padding-right: 16px !important;\r\n" + 
				"		}\r\n" + 
				"	}\r\n" + 
				"	@media only screen and (max-width: 320px) {\r\n" + 
				"		table[class=\"table-row\"] {\r\n" + 
				"			padding-left: 12px !important;\r\n" + 
				"			padding-right: 12px !important;\r\n" + 
				"		}\r\n" + 
				"	}\r\n" + 
				"	@media only screen and (max-width: 608px) {\r\n" + 
				"		td[class=\"table-td-wrap\"] {\r\n" + 
				"			width: 100% !important;\r\n" + 
				"		}\r\n" + 
				"	}\r\n" + 
				"  </style>\r\n" + 
				" </head>\r\n" + 
				" <body style=\"font-family: Arial, sans-serif; font-size:13px; color: #444444; min-height: 200px;\" bgcolor=\"#E4E6E9\" leftmargin=\"0\" topmargin=\"0\" marginheight=\"0\" marginwidth=\"0\">\r\n" + 
				" <table width=\"100%\" height=\"100%\" bgcolor=\"#E4E6E9\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n" + 
				" <tr><td width=\"100%\" align=\"center\" valign=\"top\" bgcolor=\"#E4E6E9\" style=\"background-color:#E4E6E9; min-height: 200px;\">\r\n" + 
				"<table><tr><td class=\"table-td-wrap\" align=\"center\" width=\"608\"><div style=\"font-family: Arial, sans-serif; line-height: 32px; color: #444444; font-size: 13px;\">\r\n" + 
				"  <a href=\"#\" style=\"color: #478fca; text-decoration: none; font-size: 14px; background-color: transparent;\">\r\n" + 
				"  </a>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<table class=\"table-row\" style=\"table-layout: auto; padding-right: 24px; padding-left: 24px; width: 600px; background-color: #ffffff;\" bgcolor=\"#FFFFFF\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr height=\"55px\" style=\"font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; height: 55px;\">\r\n" + 
				"   <td class=\"table-row-td\" style=\"height: 55px; padding-right: 16px; font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; font-weight: normal; vertical-align: middle;\" valign=\"middle\" align=\"center\">\r\n" + 
				"     <a href=\"#\" align= \"center\" 	style=\"color: #428bca; text-decoration: none; padding: 0px; font-size: 18px; line-height: 20px; height: 50px; background-color: transparent;\">\r\n" + 
				"	  Administração Santana de Parnaiba e Pirapora\r\n" + 
				"	 </a>\r\n" + 
				"   </td>\r\n" + 
				" \r\n" + 
				"</tr></tbody></table>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<table class=\"table-space\" height=\"6\" style=\"height: 6px; font-size: 0px; line-height: 0; width: 600px; background-color: #e4e6e9;\" width=\"600\" bgcolor=\"#E4E6E9\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-space-td\" valign=\"middle\" height=\"6\" style=\"height: 6px; width: 600px; background-color: #e4e6e9;\" width=\"600\" bgcolor=\"#E4E6E9\" align=\"left\">&nbsp;</td></tr></tbody></table>\r\n" + 
				"<table class=\"table-space\" height=\"16\" style=\"height: 16px; font-size: 0px; line-height: 0; width: 600px; background-color: #ffffff;\" width=\"600\" bgcolor=\"#FFFFFF\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-space-td\" valign=\"middle\" height=\"16\" style=\"height: 16px; width: 600px; background-color: #ffffff;\" width=\"600\" bgcolor=\"#FFFFFF\" align=\"left\">&nbsp;</td></tr></tbody></table>\r\n" + 
				"\r\n" + 
				"<table class=\"table-row\" width=\"600\" bgcolor=\"#FFFFFF\" style=\"table-layout: fixed; background-color: #ffffff;\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-row-td\" style=\"font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; font-weight: normal; padding-left: 24px; padding-right: 24px;\" valign=\"top\" align=\"left\">\r\n" + 
				"\r\n" + 
				"</td></tr></tbody></table>\r\n" + 
				"\r\n" + 
				"<table class=\"table-row\" width=\"600\" bgcolor=\"#FFFFFF\" style=\"table-layout: fixed; background-color: #ffffff;\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-row-td\" style=\"font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; font-weight: normal; padding-left: 36px; padding-right: 36px;\" valign=\"top\" align=\"left\">\r\n" + 
				"   <table class=\"table-col\" align=\"left\" width=\"528\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" style=\"table-layout: fixed;\"><tbody><tr><td class=\"table-col-td\" width=\"528\" style=\"font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; font-weight: normal;\" valign=\"top\" align=\"left\">\r\n" + 
				"	 <table class=\"header-row\" width=\"528\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" style=\"table-layout: fixed;\"><tbody><tr><td class=\"header-row-td\" width=\"528\" style=\"font-size: 24px; margin: 0px; font-family: Arial, sans-serif; font-weight: normal; line-height: 19px; color: #478fca; padding-bottom: 10px; padding-top: 15px;\" valign=\"top\" align=\"left\">Paz de Deus,</td></tr></tbody></table>\r\n" + 
				"	 <table class=\"header-row\" width=\"528\" <td> <br></td></table>\r\n" + 
				"	 <table class=\"header-row\" width=\"528\" <td> Confimação de novo Pedido número " + Pedido + " , favor, dar sequência na compra.</td></table>\r\n" + 
				"	 <table class=\"header-row\" width=\"528\" <td> <br></td></table>\r\n" + 
				"	 <table class=\"header-row\" width=\"528\" <td> </td></table>\r\n" + 
				"	 <table class=\"header-row\" width=\"528\" <td> Deus Abençoe</td></table>\r\n" + 
				"	 <table class=\"header-row\" width=\"528\" <td> Administração Santana de Parnaiba e Pirapora </td></table>\r\n" + 
				"	 <table class=\"header-row\" width=\"528\" <td> <br></td></table>\r\n" + 
				"   </td></tr></tbody></table>\r\n" + 
				"</td></tr></tbody></table>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<table class=\"table-space\" height=\"6\" style=\"height: 6px; font-size: 0px; line-height: 0; width: 600px; background-color: #e4e6e9;\" width=\"600\" bgcolor=\"#E4E6E9\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-space-td\" valign=\"middle\" height=\"6\" style=\"height: 6px; width: 600px; background-color: #e4e6e9;\" width=\"600\" bgcolor=\"#E4E6E9\" align=\"left\">&nbsp;</td></tr></tbody></table>\r\n" + 
				"<table class=\"table-row\" width=\"600\" bgcolor=\"#FFFFFF\" style=\"table-layout: fixed; background-color: #ffffff;\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-row-td\" style=\"font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; font-weight: normal; padding-left: 36px; padding-right: 36px;\" valign=\"top\" align=\"left\">\r\n" + 
				" <table class=\"table-col\" align=\"left\" width=\"528\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" style=\"table-layout: fixed;\"><tbody><tr><td class=\"table-col-td\" width=\"528\" style=\"font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; font-weight: normal;\" valign=\"top\" align=\"left\">\r\n" + 
				"	 <table class=\"table-space\" height=\"16\" style=\"height: 16px; font-size: 0px; line-height: 0; width: 528px; background-color: #ffffff;\" width=\"528\" bgcolor=\"#FFFFFF\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-space-td\" valign=\"middle\" height=\"16\" style=\"height: 16px; width: 528px; background-color: #ffffff;\" width=\"528\" bgcolor=\"#FFFFFF\" align=\"left\">&nbsp;</td></tr></tbody></table>\r\n" + 
				"	 <div style=\"font-family: Arial, sans-serif; line-height: 19px; color: #777777; font-size: 14px; text-align: center;\">&copy; 2019 Congregação Cristã no Brasil </div>\r\n" + 
				"	 <table class=\"table-space\" height=\"12\" style=\"height: 12px; font-size: 0px; line-height: 0; width: 528px; background-color: #ffffff;\" width=\"528\" bgcolor=\"#FFFFFF\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-space-td\" valign=\"middle\" height=\"12\" style=\"height: 12px; width: 528px; background-color: #ffffff;\" width=\"528\" bgcolor=\"#FFFFFF\" align=\"left\">&nbsp;</td></tr></tbody></table>\r\n" + 
				"	\r\n" + 
				"	 <table class=\"table-space\" height=\"16\" style=\"height: 16px; font-size: 0px; line-height: 0; width: 528px; background-color: #ffffff;\" width=\"528\" bgcolor=\"#FFFFFF\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-space-td\" valign=\"middle\" height=\"16\" style=\"height: 16px; width: 528px; background-color: #ffffff;\" width=\"528\" bgcolor=\"#FFFFFF\" align=\"left\">&nbsp;</td></tr></tbody></table>\r\n" + 
				" </td></tr></tbody></table>\r\n" + 
				"</td></tr></tbody></table>\r\n" + 
				"<table class=\"table-space\" height=\"8\" style=\"height: 8px; font-size: 0px; line-height: 0; width: 600px; background-color: #e4e6e9;\" width=\"600\" bgcolor=\"#E4E6E9\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-space-td\" valign=\"middle\" height=\"8\" style=\"height: 8px; width: 600px; background-color: #e4e6e9;\" width=\"600\" bgcolor=\"#E4E6E9\" align=\"left\">&nbsp;</td></tr></tbody></table></td></tr></table>\r\n" + 
				"</td></tr>\r\n" + 
				" </table>\r\n" + 
				" </body>\r\n" + 
				" </html>");
		// configure uma mensagem alternativa caso o servidor nï¿½o suporte HTML
		email1.setTextMsg("Seu servidor de e-mail nÃ£o suporta mensagem HTML");
		email1.setSSL(true);
		email1.setDebug(true);
		email1.setAuthentication("sistema@ccbspp.com.br", "123@iniciar");
		// envia o e-mail
		email1.send();
	}

	@SuppressWarnings("deprecation")
	public void sendEmailCompraAprovacao(String Nome, String email, String titulo, String Pedido, String msg1,
			String msg2) throws EmailException, MalformedURLException {

		HtmlEmail email1 = new HtmlEmail();

		email1.setHostName("mail.jandiraccb.com.br");
		email1.setSmtpPort(465);
		email1.addTo(email, Nome);
		email1.addCc("michael.bryan@congregacao.org.br", "Michael Bryan");
		email1.addCc("antonio.pereira@congregacao.org.br", "Antonio Pereira");
		email1.addCc("rafamartinsbr@me.com", "Rafael Martins");
		email1.addCc("thesilasdesign@gmail.com", "Silas Oliveira");
		email1.setFrom("sistema@ccbspp.com.br", "InformÃ¡tica - Jandira CCB");
		email1.setSubject(titulo);

		email1.setHtmlMsg("<html>\n" + "<body>\n" + "<h1> " + msg1 + "</h1>\n" + "<h2> " + msg2 + "</h2>\n"
				+ "<p>Mensagem enviada atrav&eacute;s de Aplica&ccedil;&atilde;o "
				+ "<a href=\"http://www.jandiraccb.com.br\"><b>JandiraCCB!</b></a></p>\n" + "</body>\n" + "</html>");
		// configure uma mensagem alternativa caso o servidor nï¿½o suporte HTML
		email1.setTextMsg("Seu servidor de e-mail nÃ£o suporta mensagem HTML");
		email1.setSSL(true);
		email1.setDebug(true);
		email1.setAuthentication("sistema@ccbspp.com.br", "123@iniciar");
		// envia o e-mail
		email1.send();
	}

	@SuppressWarnings("deprecation")
	public void sendEmailNovoUsuario(String Nome, String email) throws EmailException, MalformedURLException {

		HtmlEmail email1 = new HtmlEmail();

		email1.setHostName("mail.jandiraccb.com.br");
		email1.setSmtpPort(465);
		email1.addTo(email, Nome);
		email1.setFrom("sistema@ccbspp.com.br", "Informatica - Jandira CCB");
		email1.setSubject("ADM - SSP - Novo usuário cadastrado no Portal");

		email1.setHtmlMsg("<!doctype html>\r\n" + " <html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n" + " <head>\r\n"
				+ "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n"
				+ "  <meta name=\"viewport\" content=\"initial-scale=1.0\" />\r\n"
				+ "  <meta name=\"format-detection\" content=\"telephone=no\" />\r\n" + "  <title></title>\r\n"
				+ "  <style type=\"text/css\">\r\n" + " 	body {\r\n" + "		width: 100%;\r\n"
				+ "		margin: 0;\r\n" + "		padding: 0;\r\n" + "		-webkit-font-smoothing: antialiased;\r\n"
				+ "	}\r\n" + "	@media only screen and (max-width: 600px) {\r\n"
				+ "		table[class=\"table-row\"] {\r\n" + "			float: none !important;\r\n"
				+ "			width: 98% !important;\r\n" + "			padding-left: 20px !important;\r\n"
				+ "			padding-right: 20px !important;\r\n" + "		}\r\n"
				+ "		table[class=\"table-row-fixed\"] {\r\n" + "			float: none !important;\r\n"
				+ "			width: 98% !important;\r\n" + "		}\r\n"
				+ "		table[class=\"table-col\"], table[class=\"table-col-border\"] {\r\n"
				+ "			float: none !important;\r\n" + "			width: 100% !important;\r\n"
				+ "			padding-left: 0 !important;\r\n" + "			padding-right: 0 !important;\r\n"
				+ "			table-layout: fixed;\r\n" + "		}\r\n" + "		td[class=\"table-col-td\"] {\r\n"
				+ "			width: 100% !important;\r\n" + "		}\r\n"
				+ "		table[class=\"table-col-border\"] + table[class=\"table-col-border\"] {\r\n"
				+ "			padding-top: 12px;\r\n" + "			margin-top: 12px;\r\n"
				+ "			border-top: 1px solid #E8E8E8;\r\n" + "		}\r\n"
				+ "		table[class=\"table-col\"] + table[class=\"table-col\"] {\r\n"
				+ "			margin-top: 15px;\r\n" + "		}\r\n" + "		td[class=\"table-row-td\"] {\r\n"
				+ "			padding-left: 0 !important;\r\n" + "			padding-right: 0 !important;\r\n"
				+ "		}\r\n" + "		table[class=\"navbar-row\"] , td[class=\"navbar-row-td\"] {\r\n"
				+ "			width: 100% !important;\r\n" + "		}\r\n" + "		img {\r\n"
				+ "			max-width: 100% !important;\r\n" + "			display: inline !important;\r\n"
				+ "		}\r\n" + "		img[class=\"pull-right\"] {\r\n" + "			float: right;\r\n"
				+ "			margin-left: 11px;\r\n" + "            max-width: 125px !important;\r\n"
				+ "			padding-bottom: 0 !important;\r\n" + "		}\r\n" + "		img[class=\"pull-left\"] {\r\n"
				+ "			float: left;\r\n" + "			margin-right: 11px;\r\n"
				+ "			max-width: 125px !important;\r\n" + "			padding-bottom: 0 !important;\r\n"
				+ "		}\r\n" + "		table[class=\"table-space\"], table[class=\"header-row\"] {\r\n"
				+ "			float: none !important;\r\n" + "			width: 98% !important;\r\n" + "		}\r\n"
				+ "		td[class=\"header-row-td\"] {\r\n" + "			width: 100% !important;\r\n" + "		}\r\n"
				+ "	}\r\n" + "	@media only screen and (max-width: 480px) {\r\n"
				+ "		table[class=\"table-row\"] {\r\n" + "			padding-left: 16px !important;\r\n"
				+ "			padding-right: 16px !important;\r\n" + "		}\r\n" + "	}\r\n"
				+ "	@media only screen and (max-width: 320px) {\r\n" + "		table[class=\"table-row\"] {\r\n"
				+ "			padding-left: 12px !important;\r\n" + "			padding-right: 12px !important;\r\n"
				+ "		}\r\n" + "	}\r\n" + "	@media only screen and (max-width: 608px) {\r\n"
				+ "		td[class=\"table-td-wrap\"] {\r\n" + "			width: 100% !important;\r\n" + "		}\r\n"
				+ "	}\r\n" + "  </style>\r\n" + " </head>\r\n"
				+ " <body style=\"font-family: Arial, sans-serif; font-size:13px; color: #444444; min-height: 200px;\" bgcolor=\"#E4E6E9\" leftmargin=\"0\" topmargin=\"0\" marginheight=\"0\" marginwidth=\"0\">\r\n"
				+ " <table width=\"100%\" height=\"100%\" bgcolor=\"#E4E6E9\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\r\n"
				+ " <tr><td width=\"100%\" align=\"center\" valign=\"top\" bgcolor=\"#E4E6E9\" style=\"background-color:#E4E6E9; min-height: 200px;\">\r\n"
				+ "<table><tr><td class=\"table-td-wrap\" align=\"center\" width=\"608\"><div style=\"font-family: Arial, sans-serif; line-height: 32px; color: #444444; font-size: 13px;\">\r\n"
				+ "  <a href=\"#\" style=\"color: #478fca; text-decoration: none; font-size: 14px; background-color: transparent;\">\r\n"
				+ "  </a>\r\n" + "</div>\r\n" + "\r\n"
				+ "<table class=\"table-row\" style=\"table-layout: auto; padding-right: 24px; padding-left: 24px; width: 600px; background-color: #ffffff;\" bgcolor=\"#FFFFFF\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr height=\"55px\" style=\"font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; height: 55px;\">\r\n"
				+ "   <td class=\"table-row-td\" style=\"height: 55px; padding-right: 16px; font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; font-weight: normal; vertical-align: middle;\" valign=\"middle\" align=\"center\">\r\n"
				+ "     <a href=\"#\" align= \"center\" 	style=\"color: #428bca; text-decoration: none; padding: 0px; font-size: 18px; line-height: 20px; height: 50px; background-color: transparent;\">\r\n"
				+ "	  Administração Santana de Parnaiba e Pirapora\r\n" + "	 </a>\r\n" + "   </td>\r\n" + " \r\n"
				+ "</tr></tbody></table>\r\n" + "\r\n" + "\r\n"
				+ "<table class=\"table-space\" height=\"6\" style=\"height: 6px; font-size: 0px; line-height: 0; width: 600px; background-color: #e4e6e9;\" width=\"600\" bgcolor=\"#E4E6E9\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-space-td\" valign=\"middle\" height=\"6\" style=\"height: 6px; width: 600px; background-color: #e4e6e9;\" width=\"600\" bgcolor=\"#E4E6E9\" align=\"left\">&nbsp;</td></tr></tbody></table>\r\n"
				+ "<table class=\"table-space\" height=\"16\" style=\"height: 16px; font-size: 0px; line-height: 0; width: 600px; background-color: #ffffff;\" width=\"600\" bgcolor=\"#FFFFFF\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-space-td\" valign=\"middle\" height=\"16\" style=\"height: 16px; width: 600px; background-color: #ffffff;\" width=\"600\" bgcolor=\"#FFFFFF\" align=\"left\">&nbsp;</td></tr></tbody></table>\r\n"
				+ "\r\n"
				+ "<table class=\"table-row\" width=\"600\" bgcolor=\"#FFFFFF\" style=\"table-layout: fixed; background-color: #ffffff;\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-row-td\" style=\"font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; font-weight: normal; padding-left: 24px; padding-right: 24px;\" valign=\"top\" align=\"left\">\r\n"
				+ " <table class=\"table-col\" align=\"left\" width=\"552\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" style=\"table-layout: fixed;\"><tbody><tr><td class=\"table-col-td\" width=\"552\" style=\"font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; font-weight: normal;\" valign=\"top\" align=\"left\">	\r\n"
				+ "	<div style=\"font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; text-align: center;\">\r\n"
				+ "		<img width=\"100%\" height=\"100%\" src=\"https://i.pinimg.com/originals/c2/23/e7/c223e71d86dc9d7531f8a47c662ea796.jpg\" style=\"border: 0px none #444444; vertical-align: middle; display: block; padding-bottom: 9px;\" hspace=\"0\" vspace=\"0\" border=\"0\">\r\n"
				+ "	</div>\r\n" + " </td></tr></tbody></table>\r\n" + "</td></tr></tbody></table>\r\n" + "\r\n"
				+ "<table class=\"table-row\" width=\"600\" bgcolor=\"#FFFFFF\" style=\"table-layout: fixed; background-color: #ffffff;\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-row-td\" style=\"font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; font-weight: normal; padding-left: 36px; padding-right: 36px;\" valign=\"top\" align=\"left\">\r\n"
				+ "   <table class=\"table-col\" align=\"left\" width=\"528\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" style=\"table-layout: fixed;\"><tbody><tr><td class=\"table-col-td\" width=\"528\" style=\"font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; font-weight: normal;\" valign=\"top\" align=\"left\">\r\n"
				+ "	 <table class=\"header-row\" width=\"528\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" style=\"table-layout: fixed;\"><tbody><tr><td class=\"header-row-td\" width=\"528\" style=\"font-size: 24px; margin: 0px; font-family: Arial, sans-serif; font-weight: normal; line-height: 19px; color: #478fca; padding-bottom: 10px; padding-top: 15px;\" valign=\"top\" align=\"left\">Paz de Deus, "
				+ Nome + "</td></tr></tbody></table>\r\n"
				+ "	 <table class=\"header-row\" width=\"528\" <td> <br></td></table>\r\n"
				+ "	 <table class=\"header-row\" width=\"528\" <td> O irmão(a), foi cadastrado com sucesso, favor, aguardar liberação para utilizar o portal, será enviado um e-mail de confirmação.</td></table>\r\n"
				+ "	 <table class=\"header-row\" width=\"528\" <td> <br></td></table>\r\n"
				+ "	 <table class=\"header-row\" width=\"528\" <td> </td></table>\r\n"
				+ "	 <table class=\"header-row\" width=\"528\" <td> Deus Abençoe</td></table>\r\n"
				+ "	 <table class=\"header-row\" width=\"528\" <td> \r\n"
				+ "Congregação Cristã no Brasil - Todos os direitos reservados </td></table>\r\n"
				+ "	 <table class=\"header-row\" width=\"528\" <td> <br></td></table>\r\n"
				+ "   </td></tr></tbody></table>\r\n" + "</td></tr></tbody></table>\r\n" + "\r\n" + "\r\n" + "\r\n"
				+ "\r\n"
				+ "<table class=\"table-space\" height=\"6\" style=\"height: 6px; font-size: 0px; line-height: 0; width: 600px; background-color: #e4e6e9;\" width=\"600\" bgcolor=\"#E4E6E9\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-space-td\" valign=\"middle\" height=\"6\" style=\"height: 6px; width: 600px; background-color: #e4e6e9;\" width=\"600\" bgcolor=\"#E4E6E9\" align=\"left\">&nbsp;</td></tr></tbody></table>\r\n"
				+ "<table class=\"table-row\" width=\"600\" bgcolor=\"#FFFFFF\" style=\"table-layout: fixed; background-color: #ffffff;\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-row-td\" style=\"font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; font-weight: normal; padding-left: 36px; padding-right: 36px;\" valign=\"top\" align=\"left\">\r\n"
				+ " <table class=\"table-col\" align=\"left\" width=\"528\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" style=\"table-layout: fixed;\"><tbody><tr><td class=\"table-col-td\" width=\"528\" style=\"font-family: Arial, sans-serif; line-height: 19px; color: #444444; font-size: 13px; font-weight: normal;\" valign=\"top\" align=\"left\">\r\n"
				+ "	 <table class=\"table-space\" height=\"16\" style=\"height: 16px; font-size: 0px; line-height: 0; width: 528px; background-color: #ffffff;\" width=\"528\" bgcolor=\"#FFFFFF\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-space-td\" valign=\"middle\" height=\"16\" style=\"height: 16px; width: 528px; background-color: #ffffff;\" width=\"528\" bgcolor=\"#FFFFFF\" align=\"left\">&nbsp;</td></tr></tbody></table>\r\n"
				+ "	 <div style=\"font-family: Arial, sans-serif; line-height: 19px; color: #777777; font-size: 14px; text-align: center;\">&copy; 2019 Congregação Cristã no Brasil </div>\r\n"
				+ "	 <table class=\"table-space\" height=\"12\" style=\"height: 12px; font-size: 0px; line-height: 0; width: 528px; background-color: #ffffff;\" width=\"528\" bgcolor=\"#FFFFFF\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-space-td\" valign=\"middle\" height=\"12\" style=\"height: 12px; width: 528px; background-color: #ffffff;\" width=\"528\" bgcolor=\"#FFFFFF\" align=\"left\">&nbsp;</td></tr></tbody></table>\r\n"
				+ "	\r\n"
				+ "	 <table class=\"table-space\" height=\"16\" style=\"height: 16px; font-size: 0px; line-height: 0; width: 528px; background-color: #ffffff;\" width=\"528\" bgcolor=\"#FFFFFF\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-space-td\" valign=\"middle\" height=\"16\" style=\"height: 16px; width: 528px; background-color: #ffffff;\" width=\"528\" bgcolor=\"#FFFFFF\" align=\"left\">&nbsp;</td></tr></tbody></table>\r\n"
				+ " </td></tr></tbody></table>\r\n" + "</td></tr></tbody></table>\r\n"
				+ "<table class=\"table-space\" height=\"8\" style=\"height: 8px; font-size: 0px; line-height: 0; width: 600px; background-color: #e4e6e9;\" width=\"600\" bgcolor=\"#E4E6E9\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tbody><tr><td class=\"table-space-td\" valign=\"middle\" height=\"8\" style=\"height: 8px; width: 600px; background-color: #e4e6e9;\" width=\"600\" bgcolor=\"#E4E6E9\" align=\"left\">&nbsp;</td></tr></tbody></table></td></tr></table>\r\n"
				+ "</td></tr>\r\n" + " </table>\r\n" + " </body>\r\n" + " </html>");
		// configure uma mensagem alternativa caso o servidor nï¿½o suporte HTML
		email1.setTextMsg("Seu servidor de e-mail não suporta mensagem HTML");
		email1.setSSL(true);
		email1.setDebug(true);
		email1.setAuthentication("sistema@ccbspp.com.br", "adm1@Iniciar");
		// envia o e-mail
		email1.send();

	}

}
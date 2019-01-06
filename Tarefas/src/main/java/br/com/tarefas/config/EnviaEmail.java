package br.com.tarefas.config;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.tarefas.model.Acesso;
import br.com.tarefas.model.Email;


public class EnviaEmail {
 
	public void enviar(Email email) throws Exception {
		System.out.println("Inicio do programa");
 
		//Configuração para envio de E-mail via GMail		
		Properties props = new Properties();
		props.setProperty("smtp.jandiraccb.com.br", "smtp.uhserver.com");
		props.setProperty("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "587");
		props.setProperty("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("pop3.jandiraccb.com.br", "pop.uhserver.com");
		props.put("mail.transport.protocol", "smtp");
 
		Session session = Session.getInstance(props, new Acesso(email.getDe(),
				email.getSenha()));
 
		session.setDebug(true);
 
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(email.getDe()));
		message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email.getPara()));
		message.setSubject(email.getTitulo());
		message.setText(email.getCorpo());
 
		Transport.send(message);
		System.out.println("Conclu�do");
	}
}
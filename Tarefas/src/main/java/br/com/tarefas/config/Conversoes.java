package br.com.tarefas.config;

import java.io.IOException;
import java.net.SocketException;
import java.text.NumberFormat;
import java.util.Random;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class Conversoes {

	// converte para banco
	public Float converteParaBanco(String valorBR) {
		String valor = valorBR;
		valor = valor.replace(",", ".");
		float f = Float.valueOf(valor);
		System.out.println(f);
		return f;
	}

	// converte para real
	public String converteParaReal(Float valorBanco) {
		System.out.println(NumberFormat.getCurrencyInstance().format(valorBanco));
		return NumberFormat.getCurrencyInstance().format(valorBanco);
	}

	public String[] ListaFTP(String pasta) throws SocketException, IOException {
		String[] arq = null;

		FTPClient ftp = new FTPClient();
		ftp.connect("184.107.94.164");
		ftp.login("ccbssp", "cYUg2+;&@(Rf");
		if (FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
			System.out.println("....: Conectado");
			ftp.enterLocalPassiveMode();
		}
		ftp.changeWorkingDirectory("public_html/ccbspp/Secretaria"	);
		System.out.print("....: " + ftp.getReplyString());
		System.out.println("....: Porta " + ftp.getDefaultPort());
		try {
			arq = ftp.listNames();
			@SuppressWarnings("unused")
			FTPFile[] ftpFiles = ftp.listFiles();
			System.out.println("Listando arquivos: \n");
			for (String f : arq) {
				System.out.println(f);
			}
			ftp.logout();
			ftp.disconnect();
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (SocketException es) {
			System.out.println(es.getMessage());
		}
		return arq;
	}
	
	
	public String[] ListaFTP2(String pasta) throws SocketException, IOException {
		String[] arq = null;

		String server = "184.107.94.164";
        int port = 21;
        String user = "ccbspp";
        String pass = "cYUg2+;&@(Rf";
 
        FTPClient ftpClient = new FTPClient();
        try {
 
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
 
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.changeWorkingDirectory("public_html/ccbspp/Secretaria"	);
			arq = ftpClient.listNames();
			@SuppressWarnings("unused")
			FTPFile[] ftpFiles = ftpClient.listFiles();
			System.out.println("Listando arquivos: \n");
			for (String f : arq) {
				System.out.println(f);
			}
			ftpClient.logout();
			ftpClient.disconnect();
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (SocketException es) {
			System.out.println(es.getMessage());
		}
		return arq;
	}
	
	

	public String SenhaRandon() {
		// Determia as letras que poderão estar presente nas chaves
		String letras = "AB2@C2D14E84@265!FG6H#$24$&7I$4&JK38LM*96678?0RST!~UVY+9WX*Z";

		Random random = new Random();

		String armazenaChaves = "";
		int index = -1;
		for (int i = 0; i < 14; i++) {
			index = random.nextInt(letras.length());
			armazenaChaves += letras.substring(index, index + 1);
		}
		return armazenaChaves;
	}

	public String MenuRandon() {
		// Determia as letras que poderão estar presente nas chaves
		String letras = "AB2@C2D14E84@265!FG6H#";

		Random random = new Random();

		String armazenaChaves = "";
		int index = -1;
		for (int i = 0; i < 14; i++) {
			index = random.nextInt(letras.length());
			armazenaChaves += letras.substring(index, index + 1);
		}
		return armazenaChaves;
	}

}

package br.com.tarefas.controller;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringJoiner;

@Controller
public class UploadController {

	//Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "c://temp//";

    //@RequestMapping(value = "/upload", method = RequestMethod.POST)
    @RequestMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
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

    			// APPROACH #1: uploads first file using an InputStream
    			File firstLocalFile = new File(path.toString());

    			String firstRemoteFile = "public_html/ccbspp/Secretaria/" + path.getFileName();
    			InputStream inputStream = new FileInputStream(firstLocalFile);

    			System.out.println("Start uploading first file");
    			boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
    			inputStream.close();
    			if (done) {
    				System.out.println("The first file is uploaded successfully.");
    			}

    			// APPROACH #2: uploads second file using an OutputStream
    			File secondLocalFile = new File(path.toString());
    			String secondRemoteFile = "public_html/ccbspp/";
    			inputStream = new FileInputStream(secondLocalFile);

    			System.out.println("Start uploading second file");
    			OutputStream outputStream = ftpClient.storeFileStream(secondRemoteFile);
    			byte[] bytesIn = new byte[4096];
    			int read = 0;

    			while ((read = inputStream.read(bytesIn)) != -1) {
    				outputStream.write(bytesIn, 0, read);
    			}
    			inputStream.close();
    			outputStream.close();

    			boolean completed = ftpClient.completePendingCommand();
    			if (completed) {
    				System.out.println("The second file is uploaded successfully.");
    			}

    		} catch (IOException ex) {
    			System.out.println("Error: " + ex.getMessage());
    			ex.printStackTrace();
    		} finally {
    			try {
    				if (ftpClient.isConnected()) {
    					ftpClient.logout();
    					ftpClient.disconnect();
    				}
    			} catch (IOException ex) {
    				ex.printStackTrace();
    			}
    		}

            redirectAttributes.addFlashAttribute("message", 
                        "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        
        
        return "redirect:/uploadStatus";
    }


}
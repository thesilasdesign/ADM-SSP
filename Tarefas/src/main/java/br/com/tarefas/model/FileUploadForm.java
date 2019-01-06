package br.com.tarefas.model;

import java.util.List;
 
import org.springframework.web.multipart.MultipartFile;
 
public class FileUploadForm {
 
    private List<MultipartFile> files;

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "ListaBatismo [files=" + files + "]";
	}
     
    
}
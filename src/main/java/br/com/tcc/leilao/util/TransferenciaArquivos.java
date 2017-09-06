package br.com.tcc.leilao.util;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class TransferenciaArquivos {

	public String upload(MultipartFile file, Long produto_id, String storage){
		String name;
		File serverFile;
		String link = "";
		if (!file.isEmpty()) {
			
				name = file.getOriginalFilename();
				
				System.out.println(storage);
                // Creating the directory to store file
                String rootPath = storage + File.separator + "produtos";
				File dir = new File(rootPath);
                if (!dir.exists())
                    dir.mkdirs();
                // Create the file on server
                serverFile = new File(dir.getAbsolutePath() + File.separator + produto_id +"_"+name);
               try{
                    byte[] bytes = file.getBytes();
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream( serverFile ));
                    stream.write(bytes);
                    stream.close();
                    link = produto_id +"_"+name;
                } catch (Exception e) {
                	return link;
                }
                
	    } else {
	    	return link;
	    }		
		
		return link;
		
	}
}

package edu.ciit.iot.face;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;


public class GetFileContentAsBase64 {

	public static String getFileContentAsBase64(String path) {
    	try {
    		byte[] imgData = Files.readAllBytes(Paths.get(path));
    		//byte[] imgData = FileUtil.readFileByBytes(path);
        
        	String base64 = Base64.getEncoder().encodeToString(imgData);
        	return base64;
        }
        catch (Exception e) {
            System.err.printf("Ω‚Œˆ ß∞‹£°");
        }
        return null;
    }
    
}

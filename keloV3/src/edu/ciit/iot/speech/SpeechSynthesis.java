package edu.ciit.iot.speech;

import java.io.IOException;

import org.json.JSONObject;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;

public class SpeechSynthesis {
	
		public static void speechSynthesis(AipSpeech client,String txt,String fileName) {
//			AipSpeech client =  GetAuth.getToken();
			
			
			TtsResponse res = client.synthesis(txt, "zh", 1, null);
	        byte[] data = res.getData();
	        JSONObject res1 = res.getResult();
	        if (data != null) {
	            try {
	                Util.writeBytesToFileSystem(data, fileName);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        if (res1 != null) {
	            System.out.println(res1.toString(2));
	        }
		}

}


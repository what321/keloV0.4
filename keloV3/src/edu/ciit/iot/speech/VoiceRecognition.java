package edu.ciit.iot.speech;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.speech.AipSpeech;

public class VoiceRecognition {
	public static JSONObject audioToString(AipSpeech client,String filename) {
		//AipSpeech client =  GetAuth.getToken();
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("dev_pid", 1536);
		JSONObject res = client.asr(filename, "wav", 16000, params);
		
		
		
		return res;
	}

}

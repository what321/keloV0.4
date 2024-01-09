package edu.ciit.iot.speech;

import com.baidu.aip.speech.AipSpeech;

public class GetAuth {
	public static final String APP_ID = "替换为自己的APP ID";//换成自己在百度智能云注册语音识别应用后，获取的APP_ID
    public static final String API_KEY = "替换为自己的API_KEY ";//换成获取的API_KEY
    public static final String SECRET_KEY = "替换为自己的SECRET_KEY";//换成获取的SECRET_KEY
    
    public static AipSpeech getToken() {
		AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
		
		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(2000);
		return client;
		
	}
    
}

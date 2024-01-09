package edu.ciit.iot.speech;

import javax.swing.JButton;
import javax.xml.xpath.XPathEvaluationResult.XPathResultType;

import com.baidu.aip.speech.AipSpeech;

import edu.ciit.iot.serial.SerialCom;
import edu.ciit.iot.serial.SerialParameter;

public class SpeechThread extends Thread {
	
	private SerialCom serialCom;
	private SerialParameter serialParameter;
	private boolean state;
	private AipSpeech client;
	

	public SpeechThread(AipSpeech client,Boolean state,SerialCom serialCom,SerialParameter serialParameter) {
		super();
		this.serialCom = serialCom;
		this.serialParameter = serialParameter;
		this.state = state;
		this.client = client;
	}
	
	@Override
	public void run() {
		while(state) {
			String cmdString = CmdAnalysis.cmdrecog(client);
			if(cmdString != null) {
				CmdAnalysis.CmdExcute(client,cmdString, serialCom, serialParameter);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else {
				continue;
			}
			
		}
		
	}

	public void exit() {
		// TODO Auto-generated method stub
		state = false;
	}
	

}

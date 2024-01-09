package edu.ciit.iot.speech;

import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import org.json.JSONObject;

import com.baidu.aip.speech.AipSpeech;

import cn.hutool.json.JSONUtil;
import edu.ciit.iot.database.DBtool;
import edu.ciit.iot.database.Operater;
import edu.ciit.iot.serial.Message;
import edu.ciit.iot.serial.SerialCom;
import edu.ciit.iot.serial.SerialComListener;
import edu.ciit.iot.serial.SerialParameter;
import edu.ciit.iot.serial.SerialProtocol;
import edu.ciit.iot.ui.CalibrationView;
import edu.ciit.iot.ui.SerialConfig;
import edu.ciit.iot.ui.ToolView;
import edu.ciit.iot.util.ByteUtils;
import edu.ciit.iot.util.SwingUtil;
import javazoom.jl.decoder.JavaLayerException;

public class CmdAnalysis{
	
	
	public static String cmdrecog(AipSpeech client) {
		String cmd = null;
		String audioFile = "D:\\Documents\\eclipse-workspace\\keloV3\\resource\\011.wav";
		AudioRecorder audioRecorder = new AudioRecorder(audioFile);
		audioRecorder.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		audioRecorder.stopRecording();
		JSONObject res1 = VoiceRecognition.audioToString(client,audioFile);
		JsonRootBean resultElement1 = JSONUtil.toBean(res1.toString(), JsonRootBean.class);
		
		if (resultElement1.getResult()!=null) {
			cmd = resultElement1.getResult().get(0);
			System.out.println(cmd);
			return cmd;
			
		} else {
			return null;
		}
		
	}
	
	public static void CmdExcute(AipSpeech client,String cmdString,SerialCom serialCom, SerialParameter serialParameter) {
		
		if (cmdString.contains("配置串口")||cmdString.contains("配置窗口")) {
			SerialConfig serialConfig = new SerialConfig();
			serialConfig.setVisible(true);
			SpeechSynthesis.speechSynthesis(client,"已为您打开串口配置", "audio1.mp3");
			try {
				MusicPlayer.mp3Player("audio1.mp3");
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (cmdString.contains("打开串口")||cmdString.contains("打开窗口")) {
			serialCom.openPort(serialParameter);
			byte[] bb = ByteUtils.hexToByteArray("0141C010");
			serialCom.sendCom(bb);
			
		}else if (cmdString.contains("关闭串口")||cmdString.contains("关闭窗口")) {
			serialCom.closePort();
			
		}else if (cmdString.contains("校准数据")||cmdString.contains("标定数据")) {
			CalibrationView calibrationView = new CalibrationView(serialCom);
			calibrationView.setVisible(true);
			
		}else if (cmdString.contains("一路输出")) {
			boolean state = Message.getinstance().getdOutput().get(0);
			byte[] sendCmd = SerialProtocol.getDouputCmd(0, state);
			serialCom.sendCom(sendCmd);
		}else if (cmdString.contains("二路输出")) {
			boolean state = Message.getinstance().getdOutput().get(1);
			byte[] sendCmd = SerialProtocol.getDouputCmd(1, state);
			serialCom.sendCom(sendCmd);
		}else if (cmdString.contains("三路输出")) {
			boolean state = Message.getinstance().getdOutput().get(2);
			byte[] sendCmd = SerialProtocol.getDouputCmd(2, state);
			serialCom.sendCom(sendCmd);
		}else if (cmdString.contains("四路输出")) {
			boolean state = Message.getinstance().getdOutput().get(3);
			byte[] sendCmd = SerialProtocol.getDouputCmd(3, state);
			serialCom.sendCom(sendCmd);
		}
		
		
		
		
		
		
		
	}



	
	

}

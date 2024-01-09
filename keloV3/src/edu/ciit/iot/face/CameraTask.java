package edu.ciit.iot.face;

import java.security.PublicKey;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamUtils;
import com.github.sarxos.webcam.util.ImageUtils;

import cn.hutool.json.JSONUtil;
import edu.ciit.iot.database.DBtool;
import edu.ciit.iot.database.OperateRecorder;
import edu.ciit.iot.database.Operater;
import edu.ciit.iot.serial.SerialCom;
import edu.ciit.iot.ui.CameraView;
import edu.ciit.iot.ui.OperaterView;

public class CameraTask extends Thread {
	private Boolean flag;
	private CameraView cameraView;
	private AipFace client;
	private static JSONObject result;
	private static JsonRootBean resultElement;
	private static int err_code;
	private String userId = null;
	private JLabel lbl_nameChange;
	
	private JTextField textField_1;
	

	
	public CameraTask( CameraView cameraView, AipFace client,JTextField textField_1,JLabel lbl_nameChange) {
//		super();
		this.cameraView = cameraView;
		this.client = client;
		this.textField_1 = textField_1;
		this.lbl_nameChange = lbl_nameChange;
		

	}
	

	@Override
	public void run() {
		int i;
		//前台摄像头视频流，后台拍摄照片
		for (i = 0; i < 10; i++) {
			//摄像头拍照，文件：capture.png
			WebcamUtils.capture(cameraView.webcam, "capture", ImageUtils.FORMAT_PNG);
			System.out.println("第"+i+"次拍照");
			
			//进行人脸识别
			result = GetInfo.search(client);
			resultElement = JSONUtil.toBean(result.toString(), JsonRootBean.class);
			
			//如果获取结果为空，则说明该人脸不在用户组的人脸库中，跳出当前循环，进行下一次拍摄
			if (resultElement.getResult()==null) {
				continue;
			}
			
			//获取错误码
			err_code = resultElement.getError_code();
			try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			//如果错误码为0，说明人脸库中有相似人脸，即识别成功
			if (err_code == 0) {
				break;
			}
		
		}
		
		//若拍摄超过10次，说明未匹配人脸
		if(i >= 10) {
     		System.out.println("未找到此用户");
     		SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					lbl_nameChange.setText("验证失败");
					textField_1.setText("");
					
				}
			});
     		
     		
     	}else {     //若拍摄小于10次，说明匹配人脸
     		System.out.println("登录成功");
     		userId = resultElement.getResult().getUser_list().get(0).getUser_id();
     		//数据库查询方法重载，需在DBTool中写该方法
			List<Operater> listOperaters = DBtool.query(userId);
			Operater operater = listOperaters.get(0);
			
     		SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					textField_1.setText(userId);
					lbl_nameChange.setText(operater.getName());
					
				}
			});
     		
     		
		}
		
		cameraView.webcam.close();
		cameraView.setVisible(false);
		
	}
	
	public void exit() {
		// TODO Auto-generated method stub
//		flag = false;;
	}
	
	
	

}

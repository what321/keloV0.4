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
		//ǰ̨����ͷ��Ƶ������̨������Ƭ
		for (i = 0; i < 10; i++) {
			//����ͷ���գ��ļ���capture.png
			WebcamUtils.capture(cameraView.webcam, "capture", ImageUtils.FORMAT_PNG);
			System.out.println("��"+i+"������");
			
			//��������ʶ��
			result = GetInfo.search(client);
			resultElement = JSONUtil.toBean(result.toString(), JsonRootBean.class);
			
			//�����ȡ���Ϊ�գ���˵�������������û�����������У�������ǰѭ����������һ������
			if (resultElement.getResult()==null) {
				continue;
			}
			
			//��ȡ������
			err_code = resultElement.getError_code();
			try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			//���������Ϊ0��˵������������������������ʶ��ɹ�
			if (err_code == 0) {
				break;
			}
		
		}
		
		//�����㳬��10�Σ�˵��δƥ������
		if(i >= 10) {
     		System.out.println("δ�ҵ����û�");
     		SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					lbl_nameChange.setText("��֤ʧ��");
					textField_1.setText("");
					
				}
			});
     		
     		
     	}else {     //������С��10�Σ�˵��ƥ������
     		System.out.println("��¼�ɹ�");
     		userId = resultElement.getResult().getUser_list().get(0).getUser_id();
     		//���ݿ��ѯ�������أ�����DBTool��д�÷���
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

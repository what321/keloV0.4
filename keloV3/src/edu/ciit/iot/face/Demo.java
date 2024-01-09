package edu.ciit.iot.face;

import javax.swing.JFrame;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.github.sarxos.webcam.WebcamUtils;
import com.github.sarxos.webcam.util.ImageUtils;

import cn.hutool.json.JSONUtil;

public class Demo {
	private static JFrame window;
	static JSONObject result;
	static JsonRootBean resultElement;
	static int err_code;
	static int i;

	public static void main(String[] args) {
		
		// 获取默认的摄像头实例
        final Webcam webcam = Webcam.getDefault();
        // 设置摄像头捕获的图像尺寸为VGA
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        // 创建一个WebcamPanel对象，并将摄像头实例传递给它
        WebcamPanel panel = new WebcamPanel(webcam);
        // 设置在图像面板上显示FPS、调试信息和图像尺寸，并进行镜像显示
        panel.setFPSDisplayed(true);
        panel.setDisplayDebugInfo(true);
        panel.setImageSizeDisplayed(true);
        panel.setMirrored(true);
        // 创建一个JFrame窗口对象，并将摄像头面板添加到窗口中
        window = new JFrame("摄像头");
        window.add(panel);
        // 设置窗口的一些属性和可见性
        window.setResizable(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
        
        window.setResizable(true);
        window.pack();
        window.setVisible(true);
        
        String fileNameString = "001";
        
        // TODO Auto-generated method stub
     	AipFace client = GetAuth.getToken();
		
     	for (i = 0; i < 3; i++) {
     		try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
     		
        	WebcamUtils.capture(webcam, fileNameString, ImageUtils.FORMAT_PNG);
        	result = GetInfo.search(client);
    		resultElement = JSONUtil.toBean(result.toString(), JsonRootBean.class);
    		err_code = resultElement.getError_code();
    		
    		if (err_code == 0) {
    			break;
			}
    		
		}
     	if(i >= 3) {
     		System.out.println("未找到此用户");
     	}else {
			System.out.println("成功登入");
		}
		
		String userId = resultElement.getResult().getUser_list().get(0).getUser_id();
		System.out.println(err_code);
		System.out.println(userId);
		
		

	}

}

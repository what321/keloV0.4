package test;


import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.github.sarxos.webcam.WebcamUtils;
import com.github.sarxos.webcam.util.ImageUtils;
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class AJava {
	private static JFrame window;
	public static void main(String[] args) throws Exception {
		
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
        
        String fileNameString = "D://" + System.currentTimeMillis();
        for (int i = 0; i < 3; i++) {
        	WebcamUtils.capture(webcam, fileNameString, ImageUtils.FORMAT_PNG);
        	Thread.sleep(500);
        	System.out.println("拍摄成功："+Integer.toString(i));
		}
        window.dispose();
        webcam.close();
//        

		
		
    }

}

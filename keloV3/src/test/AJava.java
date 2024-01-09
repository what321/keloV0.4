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
		
		// ��ȡĬ�ϵ�����ͷʵ��
        final Webcam webcam = Webcam.getDefault();
        // ��������ͷ�����ͼ��ߴ�ΪVGA
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        // ����һ��WebcamPanel���󣬲�������ͷʵ�����ݸ���
        WebcamPanel panel = new WebcamPanel(webcam);
        // ������ͼ���������ʾFPS��������Ϣ��ͼ��ߴ磬�����о�����ʾ
        panel.setFPSDisplayed(true);
        panel.setDisplayDebugInfo(true);
        panel.setImageSizeDisplayed(true);
        panel.setMirrored(true);
        
        // ����һ��JFrame���ڶ��󣬲�������ͷ�����ӵ�������
        window = new JFrame("����ͷ");
        window.add(panel);
        // ���ô��ڵ�һЩ���ԺͿɼ���
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
        	System.out.println("����ɹ���"+Integer.toString(i));
		}
        window.dispose();
        webcam.close();
//        

		
		
    }

}

package edu.ciit.iot.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;

public class CameraView extends JDialog {
	public final Webcam webcam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CameraView dialog = new CameraView();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public CameraView() {
		setBounds(100, 100, 806, 649);
		getContentPane().setLayout(null);
		
		JLabel lbl_result = new JLabel("\u8BC6\u522B\u4E2D...");
		lbl_result.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_result.setFont(new Font("宋体", Font.BOLD, 24));
		lbl_result.setBounds(254, 541, 242, 61);
		getContentPane().add(lbl_result);
		
		// 获取默认的摄像头实例
		webcam = Webcam.getDefault();
		// 设置摄像头捕获的图像尺寸为VGA
		webcam.setViewSize(WebcamResolution.VGA.getSize());
		// 创建一个WebcamPanel对象，并将摄像头实例传递给它
		WebcamPanel cameraPanel = new WebcamPanel(webcam);
		cameraPanel.setLocation(0, 10);
		cameraPanel.setSize(782, 521);
		cameraPanel.setMirrored(true);
		getContentPane().add(cameraPanel);

	}
}

package edu.ciit.iot.ui;

import javax.swing.JPanel;

import edu.ciit.iot.serial.SerialCom;
import edu.ciit.iot.serial.SerialComListener;
import edu.ciit.iot.serial.SerialParameter;
import edu.ciit.iot.speech.CmdAnalysis;
import edu.ciit.iot.speech.GetAuth;
import edu.ciit.iot.speech.SpeechThread;
import edu.ciit.iot.util.SwingUtil;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import com.baidu.aip.speech.AipSpeech;
import com.mysql.cj.xdevapi.Client;

public class SpeechView extends JPanel{
	private JLabel lblNewLabel;
	private SerialCom serialCom;
	private SerialParameter serialParameter;
	private volatile boolean state = false;
	private AipSpeech client;
	SpeechThread speechThread;

	/**
	 * Create the panel.
	 */
	public SpeechView(SerialCom serialCom, SerialParameter serialParameter) {
		this.serialCom = serialCom;
		this.serialParameter = serialParameter;
		this.state = state;
		setLayout(null);
		
		JButton btn_open = new JButton("\u5F00\u542F");
		btn_open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				client = GetAuth.getToken();
				
				lblNewLabel.setIcon(SwingUtil.createAutoAdjustIcon(ToolView.class.getResource("/images/work_run.png"), true));
				speechThread = new SpeechThread(client,true, serialCom, serialParameter );
				speechThread.start();
				System.out.println("线程开启");

				
			}
		});
		btn_open.setFont(new Font("宋体", Font.BOLD, 18));
		btn_open.setBounds(22, 64, 100, 46);
		add(btn_open);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(SwingUtil.createAutoAdjustIcon(ToolView.class.getResource("/images/work_stop.png"), true));
		lblNewLabel.setBounds(101, 120, 68, 64);
		add(lblNewLabel);
		
		JButton btn_close = new JButton("\u5173\u95ED");
		btn_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblNewLabel.setIcon(SwingUtil.createAutoAdjustIcon(ToolView.class.getResource("/images/work_stop.png"), true));
				speechThread.exit();
				System.out.println("线程关闭");
				
			}
		});
		btn_close.setFont(new Font("宋体", Font.BOLD, 18));
		btn_close.setBounds(154, 64, 100, 46);
		add(btn_close);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BED\u97F3\u8BC6\u522B");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_1.setBounds(71, 10, 131, 46);
		add(lblNewLabel_1);

	}
	
}

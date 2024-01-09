package edu.ciit.iot.ui;

import javax.swing.JPanel;

import edu.ciit.iot.serial.Message;
import edu.ciit.iot.serial.SerialCom;
import edu.ciit.iot.serial.SerialComListener;
import edu.ciit.iot.serial.SerialParameter;
import edu.ciit.iot.serial.SerialStateListner;
import edu.ciit.iot.util.ByteUtils;
import edu.ciit.iot.util.SwingUtil;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Color;


public class ToolView extends JPanel implements SerialComListener{
	
	private SerialCom serialCom;
	private SerialParameter serialParameter;
	public static JButton btn_connect;
	
	private Icon openSeriaIcon = SwingUtil.createAutoAdjustIcon(ToolView.class.getResource("/images/connect.png"),true);
	private Icon closeSeriaIcon = SwingUtil.createAutoAdjustIcon(ToolView.class.getResource("/images/unconn.png"),true);
	/**
	 * Create the panel.
	 */
	public ToolView(SerialCom serialCom, SerialParameter serialParameter) {
		
		this.serialCom = serialCom;
		this.serialParameter = serialParameter;
		
		setBackground(new Color(223, 223, 223));
		setLayout(null);
		
		btn_connect = new JButton("\u4E32\u53E3\u8FDE\u63A5");
		btn_connect.setBackground(new Color(236, 248, 255));
		btn_connect.setIcon(SwingUtil.createAutoAdjustIcon(ToolView.class.getResource("/images/unconn.png"), true));
		btn_connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (serialCom.isIsopen()) {
					serialCom.closePort();
//					btn_connect.setIcon(SwingUtil.createAutoAdjustIcon(ToolView.class.getResource("/images/unconn.png"), true));
					
				} else {
					serialCom.openPort(serialParameter);
					byte[] bb = ByteUtils.hexToByteArray("0141C010");
					serialCom.sendCom(bb);
//					btn_connect.setIcon(SwingUtil.createAutoAdjustIcon(ToolView.class.getResource("/images/connect.png"), true));
					

				}
				
			}
		});
//		btn_connect.setIcon(new ImageIcon(ToolView.class.getResource("/images/unconn.png")));
		btn_connect.setToolTipText("\u4E32\u53E3\u8FDE\u63A5");
		btn_connect.setBounds(53, 10, 60, 60);
		add(btn_connect);
		
		JButton btn_serial = new JButton("\u4E32\u53E3\u8BBE\u7F6E");
		btn_serial.setBackground(new Color(236, 248, 255));
//		btn_serial.setIcon(new ImageIcon(ToolView.class.getResource("/images/configure_pressed.png")));
		btn_serial.setIcon(SwingUtil.createAutoAdjustIcon(ToolView.class.getResource("/images/configure_pressed.png"), true));
		btn_serial.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SerialConfig serialConfig = new SerialConfig();
			serialConfig.setVisible(true);
			}
		});
		btn_serial.setBounds(193, 10, 60, 60);
		add(btn_serial);
		
		JButton btn_calibration = new JButton("\u6821\u51C6");
		btn_calibration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalibrationView calibrationView = new CalibrationView(serialCom);
				calibrationView.setVisible(true);
			}
		});
		btn_calibration.setBackground(new Color(236, 248, 255));
//		btn_calibration.setIcon(new ImageIcon(ToolView.class.getResource("/images/appointment-new-2.png")));
		btn_calibration.setIcon(SwingUtil.createAutoAdjustIcon(ToolView.class.getResource("/images/appointment-new-2.png"), true));
		btn_calibration.setToolTipText("\u79F0\u91CF\u6570\u636E\u7684\u6821\u51C6");
		btn_calibration.setBounds(333, 10, 60, 60);
		add(btn_calibration);
		
		JButton btn_information = new JButton("\u7CFB\u7EDF\u4FE1\u606F");
		btn_information.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				informationView about = new informationView();
				about.setVisible(true);
			}
		});
		btn_information.setBackground(new Color(236, 248, 255));
//		btn_information.setIcon(new ImageIcon(ToolView.class.getResource("/images/Alert_15.png")));
		btn_information.setIcon(SwingUtil.createAutoAdjustIcon(ToolView.class.getResource("/images/Alert_15.png"), true));
		btn_information.setToolTipText("\u663E\u793A\u7248\u672C\u4FE1\u606F");
		btn_information.setBounds(473, 10, 60, 60);
		add(btn_information);
		
		JButton btn_exit = new JButton("\u9000\u51FA");
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (serialCom.isIsopen()) {
					serialCom.closePort();
				}
				System.exit(0);
			}
		});
		
		btn_exit.setBackground(new Color(236, 248, 255));
//		btn_exit.setIcon(new ImageIcon(ToolView.class.getResource("/images/exit_normal.png")));
		btn_exit.setIcon(SwingUtil.createAutoAdjustIcon(ToolView.class.getResource("/images/exit_normal.png"), true));
		btn_exit.setToolTipText("\u7CFB\u7EDF\u9000\u51FA");
		btn_exit.setBounds(613, 10, 60, 60);
		add(btn_exit);

	}
	@Override
	public void update(Message message) {
		// TODO Auto-generated method stub
		if (message.isIsopen()) {
			btn_connect.setIcon(openSeriaIcon);
			
		} else {
			btn_connect.setIcon(closeSeriaIcon);

		}
		
	}
	
	



}

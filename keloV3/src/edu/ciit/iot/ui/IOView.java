package edu.ciit.iot.ui;

import javax.swing.JPanel;

import edu.ciit.iot.database.OperateRecorder;
import edu.ciit.iot.serial.Message;
import edu.ciit.iot.serial.SerialCom;
import edu.ciit.iot.serial.SerialComListener;
import edu.ciit.iot.serial.SerialProtocol;
import edu.ciit.iot.util.ByteUtils;
import edu.ciit.iot.util.SwingUtil;

import javax.swing.JLabel;

import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class IOView extends JPanel implements SerialComListener{
	private Icon greenIcon = SwingUtil.createAutoAdjustIcon(ToolView.class.getResource("/images/circle_green.png"),true);
	private Icon redIcon = SwingUtil.createAutoAdjustIcon(ToolView.class.getResource("/images/circle_red.png"),true);
	private Icon grayIcon = SwingUtil.createAutoAdjustIcon(ToolView.class.getResource("/images/circle_grey.png"),true);
	
	private List<JLabel> inputedLEDList = new ArrayList<>();
	private List<JButton> outputButtonList = new ArrayList<>();
	
	private SerialCom serialCom;
	

	/**
	 * Create the panel.
	 */
	public IOView(SerialCom serialCom) {
		setLayout(null);
		this.serialCom = serialCom;
		
		JLabel lbl_input = new JLabel("\u8F93\u5165\uFF1A");
		lbl_input.setFont(new Font("宋体", Font.BOLD, 24));
		lbl_input.setBounds(48, 35, 92, 43);
		add(lbl_input);
		
		JLabel lbl_output = new JLabel("\u8F93\u51FA\uFF1A");
		lbl_output.setFont(new Font("宋体", Font.BOLD, 24));
		lbl_output.setBounds(48, 108, 92, 43);
		add(lbl_output);
		
		for (int i = 0; i < 4; i++) {
			JLabel inputLED = new JLabel("");
			inputLED.setIcon(grayIcon);
			inputLED.setBounds(492-100*i, 26, 60, 60);
			add(inputLED);
			inputedLEDList.add(inputLED);
			
		}
		
		for (int i = 0; i < 4; i++) {
			JButton outputButton = new JButton("");
			outputButton.setIcon(grayIcon);
			outputButton.setBounds(492-100*i, 102, 60, 60);
			add(outputButton);
			outputButtonList.add(outputButton);
			outputButton.addActionListener(new ActionListener() {
					
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//当前按钮的序列号
					int j = outputButtonList.indexOf(outputButton);
					//当前按钮j的动作之前状态
					boolean state = Message.getinstance().getdOutput().get(j);
					
					//转化为控制指令码
					byte[] sendCmd = SerialProtocol.getDouputCmd(j, state);
					serialCom.sendCom(sendCmd);
					
					if ((j==3) && (state == false)) {
						OperateRecorder operateRecorder = OperateRecorder.getinstance();
						Message message = Message.getinstance();
						operateRecorder.setBeginWeight(message.getWeight());
						
					}
					
					
				}
			});

			
		}
		
			

	}

	@Override
	public void update(Message message) {
		
		System.out.println("IOView");
		// TODO Auto-generated method stub
		
		Map inMap = message.getdInput();
		if (inMap.isEmpty()) return;
		
		for (int i = 0; i < 4; i++) {
			if (message.getdInput().get(i)) {
				inputedLEDList.get(i).setIcon(greenIcon);
				
			} else {
				inputedLEDList.get(i).setIcon(redIcon);

			}
			
		}
		
		for (int i = 0; i < 4; i++) {
			if (message.getdOutput().get(i)) {
				outputButtonList.get(i).setIcon(greenIcon);
				
			} else {
				outputButtonList.get(i).setIcon(grayIcon);

			}
			
		}
		
	}
}

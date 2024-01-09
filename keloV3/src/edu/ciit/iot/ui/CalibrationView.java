package edu.ciit.iot.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import edu.ciit.iot.serial.SerialCom;
import edu.ciit.iot.serial.SerialProtocol;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalibrationView extends JDialog {
	private JTextField textField_weight;
	private SerialCom serialCom;

	

	/**
	 * Create the dialog.
	 */
	public CalibrationView(SerialCom serialCom) {
		this.serialCom = serialCom;
		setTitle("\u6807\u5B9A\u91CD\u91CF");
		setBounds(100, 100, 550, 348);
		getContentPane().setLayout(null);
		
		JLabel lbl_tag = new JLabel("\u76EE\u6807\u91CD\u91CF\uFF1A");
		lbl_tag.setFont(new Font("宋体", Font.BOLD, 30));
		lbl_tag.setBounds(37, 74, 155, 55);
		getContentPane().add(lbl_tag);
		
		textField_weight = new JTextField();
		textField_weight.setFont(new Font("宋体", Font.PLAIN, 26));
		textField_weight.setBounds(197, 74, 222, 55);
		getContentPane().add(textField_weight);
		textField_weight.setColumns(10);
		
		JLabel lbl_kg = new JLabel("Kg");
		lbl_kg.setFont(new Font("宋体", Font.BOLD, 30));
		lbl_kg.setBounds(436, 74, 54, 55);
		getContentPane().add(lbl_kg);
		
		JButton btn_confirm = new JButton("\u786E\u5B9A");
		btn_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//获得重量
				int weight = Integer.parseInt(textField_weight.getText().trim());
				//得到下发指令
				byte[] calibrationCmd = SerialProtocol.getCalibration(weight, 2);
				//发送指令
				serialCom.sendCom(calibrationCmd);
				dispose();
			}
		});
		btn_confirm.setFont(new Font("宋体", Font.BOLD, 24));
		btn_confirm.setBounds(103, 180, 115, 43);
		getContentPane().add(btn_confirm);
		
		JButton btn_cancel = new JButton("\u53D6\u6D88");
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_cancel.setFont(new Font("宋体", Font.BOLD, 24));
		btn_cancel.setBounds(301, 180, 115, 43);
		getContentPane().add(btn_cancel);
		
		

	}
}

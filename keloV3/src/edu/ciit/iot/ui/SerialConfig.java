package edu.ciit.iot.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;

import edu.ciit.iot.serial.SerialCom;
import edu.ciit.iot.serial.SerialParameter;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SerialConfig extends JDialog {
	
	private String baud[] = {"1200", "2400","4800","9600","19200","38400","57600","115200"};
//	private String Ports[] = {"COM1","COM2","COM3","COM4"};
	private SerialParameter serialParameter;
	

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SerialConfig dialog = new SerialConfig();
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
	public SerialConfig() {
		
		serialParameter = SerialParameter.getinstance();
		
		setTitle("\u4E32\u53E3\u53C2\u6570\u914D\u7F6E");
		setBounds(100, 100, 800, 300);
		getContentPane().setLayout(null);
		
		JLabel lbl_serialPort = new JLabel("\u4E32\u53E3\u8BBE\u5907\uFF1A");
		lbl_serialPort.setFont(new Font("宋体", Font.PLAIN, 18));
		lbl_serialPort.setBounds(61, 89, 90, 60);
		getContentPane().add(lbl_serialPort);
		
		JComboBox comboBox_Port = new JComboBox(SerialCom.listPorts().toArray());
		comboBox_Port.setBounds(204, 100, 160, 40);
		getContentPane().add(comboBox_Port);
		
		JLabel lbl_Baud = new JLabel("\u6CE2\u7279\u7387\uFF1A");
		lbl_Baud.setFont(new Font("宋体", Font.PLAIN, 18));
		lbl_Baud.setBounds(421, 90, 90, 60);
		getContentPane().add(lbl_Baud);
		
		JComboBox comboBox_Baud = new JComboBox(baud);
		comboBox_Baud.setBounds(564, 100, 160, 40);
		getContentPane().add(comboBox_Baud);
		
		
		
		JButton btn_save = new JButton("\u4FDD\u5B58");
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String port = comboBox_Port.getSelectedItem().toString();
				String baudrate = comboBox_Baud.getSelectedItem().toString();
				serialParameter.setSerialPort(port);
				serialParameter.setBaudRate(baudrate);
				System.out.println(serialParameter);
				dispose();
			}
		});
		btn_save.setFont(new Font("宋体", Font.PLAIN, 18));
		btn_save.setBounds(202, 187, 90, 40);
		getContentPane().add(btn_save);
		
		JButton btn_cancel = new JButton("\u53D6\u6D88");
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_cancel.setFont(new Font("宋体", Font.PLAIN, 18));
		btn_cancel.setBounds(494, 187, 90, 40);
		getContentPane().add(btn_cancel);
		

	}
}

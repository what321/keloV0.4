package edu.ciit.iot.ui;

import javax.swing.JPanel;

import edu.ciit.iot.database.DBtool;
import edu.ciit.iot.database.OperateRecorder;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class OperatorRecordeView extends JPanel {
	private JLabel lbl_record;

	/**
	 * Create the panel.
	 */
	public OperatorRecordeView() {
		setLayout(null);
		
		lbl_record = new JLabel("New label");
		lbl_record.setFont(new Font("宋体", Font.BOLD, 20));
		lbl_record.setBounds(140, 76, 438, 36);
		add(lbl_record);
		
		JButton btnNewButton = new JButton("\u8BB0\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl_record.setText("");
				
				Date currentDate = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateString = dateFormat.format(currentDate);
				
				OperateRecorder operateRecorder = OperateRecorder.getinstance();
				operateRecorder.setOperateId(operateRecorder.getOperateId());
				operateRecorder.setCylinderId(operateRecorder.getCylinderId());
				operateRecorder.setGasType(operateRecorder.getGasType());
				operateRecorder.setBeginWeight(operateRecorder.getBeginWeight());
				operateRecorder.setEndWight(operateRecorder.getEndWight());
				operateRecorder.setOperateData(dateString);
				
				DBtool.recode(operateRecorder);
				lbl_record.setText("充装量为"+(operateRecorder.getEndWight()-operateRecorder.getBeginWeight())+"Kg");
				
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton.setBounds(218, 10, 150, 48);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u8BB0\u5F55\u4FE1\u606F\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 75, 111, 38);
		add(lblNewLabel);
		
		

	}
}

package edu.ciit.iot.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.plaf.multi.MultiOptionPaneUI;

import edu.ciit.iot.database.Cylinder;
import edu.ciit.iot.database.DBtool;
import edu.ciit.iot.database.OperateRecorder;
import edu.ciit.iot.database.Operater;
import edu.ciit.iot.util.UtilFun;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class CylinderInfo extends JPanel {
	private JTextField cylinderID;
	private JTextField txt_factory;
	private JTextField txt_rightUnit;
	private JTextField txt_gasType;
	private JTextField txt_tareWeight;
	private JTextField txt_maxWeight;
	

	/**
	 * Create the panel.
	 */
	public CylinderInfo() {
		setLayout(null);
		
		JLabel txt_gasId = new JLabel("\u6C14\u74F6\u7F16\u7801\uFF1A");
		txt_gasId.setFont(new Font("宋体", Font.BOLD, 20));
		txt_gasId.setBounds(29, 28, 114, 34);
		add(txt_gasId);
		
		cylinderID = new JTextField();
		cylinderID.setBounds(152, 28, 202, 34);
		add(cylinderID);
		cylinderID.setColumns(10);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("\u751F\u4EA7\u5382\u5BB6\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_1.setBounds(30, 76, 114, 34);
		add(lblNewLabel_1);
		
		txt_factory = new JTextField("");
		txt_factory.setFont(new Font("宋体", Font.BOLD, 20));
		txt_factory.setBounds(154, 76, 526, 34);
		add(txt_factory);
		
		JLabel lblNewLabel_2 = new JLabel("\u4EA7\u6743\u5355\u4F4D\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_2.setBounds(337, 120, 114, 34);
		add(lblNewLabel_2);
		
		txt_rightUnit = new JTextField("");
		txt_rightUnit.setFont(new Font("宋体", Font.BOLD, 20));
		txt_rightUnit.setBounds(457, 120, 223, 34);
		add(txt_rightUnit);
		
		JLabel lblNewLabel_3 = new JLabel("\u6C14\u74F6\u4ECB\u8D28\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_3.setBounds(29, 120, 114, 34);
		add(lblNewLabel_3);
		
		txt_gasType = new JTextField("");
		txt_gasType.setFont(new Font("宋体", Font.BOLD, 20));
		txt_gasType.setBounds(152, 120, 102, 34);
		add(txt_gasType);
		
		JLabel lblNewLabel_4 = new JLabel("\u7A7A\u74F6\u91CD\u91CF\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_4.setBounds(29, 164, 114, 34);
		add(lblNewLabel_4);
		
		txt_tareWeight = new JTextField("");
		txt_tareWeight.setFont(new Font("宋体", Font.BOLD, 20));
		txt_tareWeight.setBounds(152, 164, 115, 34);
		add(txt_tareWeight);
		
		JLabel lblNewLabel_5 = new JLabel("kg");
		lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 22));
		lblNewLabel_5.setBounds(283, 172, 35, 26);
		add(lblNewLabel_5);
		
		JLabel lbl = new JLabel("\u6700\u5927\u91CD\u91CF\uFF1A");
		lbl.setFont(new Font("宋体", Font.BOLD, 20));
		lbl.setBounds(365, 164, 114, 34);
		add(lbl);
		
		txt_maxWeight = new JTextField("");
		txt_maxWeight.setFont(new Font("宋体", Font.BOLD, 20));
		txt_maxWeight.setBounds(499, 164, 115, 34);
		add(txt_maxWeight);
		
		JLabel lblNewLabel_6 = new JLabel("kg");
		lblNewLabel_6.setFont(new Font("宋体", Font.BOLD, 22));
		lblNewLabel_6.setBounds(624, 172, 35, 26);
		add(lblNewLabel_6);
		
		
		JButton btn_check = new JButton("\u67E5\u8BE2");
		btn_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txt_factory.setText("");
				txt_rightUnit.setText("");
				txt_gasType.setText("");
				txt_tareWeight.setText("");
				txt_maxWeight.setText("");
				
				
//				//得到登录id
				String idString = cylinderID.getText().trim();
//				//根据id获得操作员信息
				List<Cylinder> cylinders = DBtool.queryCylinder(idString);
				if(!cylinders.isEmpty()) {
					Cylinder cylinder = cylinders.get(0);
					
					txt_factory.setText(cylinder.getFactory());
					txt_rightUnit.setText(cylinder.getRightUnit());
					txt_gasType.setText(cylinder.getGasType());
					txt_tareWeight.setText(Integer.toString(cylinder.getTareWeight()));
					txt_maxWeight.setText(Integer.toString(cylinder.getMaxWight()));
					
//					OperateRecorder operateRecorder = OperateRecorder.getinstance();
//					operateRecorder.setMaxweight(cylinder.getMaxWight());
					
					
					OperateRecorder operateRecorder = OperateRecorder.getinstance();
					operateRecorder.setCylinderId(idString);
					operateRecorder.setGasType(cylinder.getGasType());
					operateRecorder.setMaxweight(cylinder.getMaxWight());
					
				}else {
//					new MultiOptionPaneUI()
				}
				
			}
		});
		btn_check.setFont(new Font("宋体", Font.BOLD, 18));
		btn_check.setBounds(364, 26, 100, 40);
		add(btn_check);
		
		JButton btnNewButton = new JButton("\u589E\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cylinder cylinder = new Cylinder();
				cylinder.setId(cylinderID.getText());
				cylinder.setFactory(txt_factory.getText());
				cylinder.setRightUnit(txt_rightUnit.getText());
				cylinder.setGasType(txt_gasType.getText());
				cylinder.setTareWeight(Integer.parseInt(txt_tareWeight.getText()));
				cylinder.setMaxWight(Integer.parseInt(txt_maxWeight.getText()));
				DBtool.addCylinder(cylinder);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton.setBounds(474, 26, 100, 40);
		add(btnNewButton);
		
		JButton btn_update = new JButton("\u66F4\u65B0");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cylinder cylinder = new Cylinder();
				cylinder.setId(cylinderID.getText());
				cylinder.setFactory(txt_factory.getText());
				cylinder.setRightUnit(txt_rightUnit.getText());
				cylinder.setGasType(txt_gasType.getText());
				cylinder.setTareWeight(Integer.parseInt(txt_tareWeight.getText()));
				cylinder.setMaxWight(Integer.parseInt(txt_maxWeight.getText()));
				DBtool.updateCylinder(cylinder);
				
				if(DBtool.updateCylinder(cylinder) ) {
					new JOptionPane();
					JOptionPane.showMessageDialog(null, "执行成功", "alter", 3);
				}
				
			}
		});
		btn_update.setFont(new Font("宋体", Font.BOLD, 18));
		btn_update.setBounds(580, 26, 100, 40);
		add(btn_update);
		
		JButton btn_delete = new JButton("\u5220\u9664");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(DBtool.deleteCylinder(cylinderID.getText().trim()) ) {
					txt_factory.setText("");
					cylinderID.setText("");
					txt_gasType.setText("");
					txt_rightUnit.setText("");
					txt_tareWeight.setText("");
					txt_maxWeight.setText("");
					
					
					new JOptionPane();
					JOptionPane.showMessageDialog(null, "执行成功", "alter", 3);
				}
				
			}
		});
		btn_delete.setFont(new Font("宋体", Font.BOLD, 18));
		btn_delete.setBounds(688, 26, 100, 40);
		add(btn_delete);

	}
}

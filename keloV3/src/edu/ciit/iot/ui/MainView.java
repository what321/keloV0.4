package edu.ciit.iot.ui;

import java.awt.EventQueue;

import javax.sql.RowSetReader;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.ciit.iot.database.Work;
import edu.ciit.iot.serial.SerialCom;
import edu.ciit.iot.serial.SerialParameter;
import edu.ciit.iot.util.ByteUtils;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {

	private JPanel contentPane;
	private SerialCom serialCom;
	private SerialParameter serialParameter;


	/**
	 * Create the frame.
	 */
	public MainView(SerialParameter parameter, SerialCom serialCom) {
		setBackground(new Color(236, 248, 255));
		
		this.serialCom = serialCom;
		this.serialParameter = parameter;
		
		setTitle("\u672C\u5730\u5E94\u7528\u670D\u52A1\u5668");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-7, 100, 846, 909);
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		IOView ioView = new IOView(serialCom);
		ioView.setLocation(0, 78);
		ioView.setSize(573, 184);
		serialCom.resgisterObsever(ioView);
		contentPane.add(ioView);
		
		ToolView toolView =   new ToolView(serialCom, serialParameter);
		toolView.setBounds(0, 0, 832, 79);
		serialCom.resgisterObsever(toolView);
		contentPane.add(toolView);
		toolView.setBackground(new Color(236, 248, 255));
		
		WeightView weightView = new WeightView(serialCom);
		weightView.setLocation(0, 259);
		weightView.setSize(832, 114);
		serialCom.resgisterObsever(weightView);
		contentPane.add(weightView);
		
		OperaterView operaterView = new OperaterView();
		operaterView.setSize(832, 133);
		operaterView.setLocation(0, 371);
		contentPane.add(operaterView);
		
		CylinderInfo cylinderInfo = new CylinderInfo();
		cylinderInfo.setSize(832, 221);
		cylinderInfo.setLocation(0, 499);
		contentPane.add(cylinderInfo);
		
		SpeechView speechView = new SpeechView(serialCom, parameter);
		speechView.setSize(260, 184);
		speechView.setLocation(572, 78);
		contentPane.add(speechView);
		
		OperatorRecordeView operatorRecordeView = new OperatorRecordeView();
		operatorRecordeView.setLocation(0, 717);
		operatorRecordeView.setSize(832, 133);
		contentPane.add(operatorRecordeView);
		
		Work work = new Work();
		serialCom.resgisterObsever(work);
		
		
	}
}

package edu.ciit.iot.ui;

import javax.swing.JPanel;

import edu.ciit.iot.serial.Message;
import edu.ciit.iot.serial.SerialCom;
import edu.ciit.iot.serial.SerialComListener;
import edu.ciit.iot.serial.SerialProtocol;
import edu.ciit.iot.util.ByteUtils;
import edu.ciit.iot.util.SwingUtil;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WeightView extends JPanel implements SerialComListener{
	JLabel lbl_weightValue;
	private SerialCom serialCom;
	/**
	 * Create the panel.
	 */
	public WeightView(SerialCom serialCom) {
		this.serialCom = serialCom;
		setLayout(null);
		
		JLabel lbl_weight = new JLabel("\u91CD\u91CF\uFF1A");
		lbl_weight.setFont(new Font("ËÎÌו", Font.BOLD, 32));
		lbl_weight.setBounds(37, 20, 133, 70);
		add(lbl_weight);
		
		lbl_weightValue = new JLabel("00.0");
		lbl_weightValue.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_weightValue.setFont(new Font("ËÎÌו", Font.BOLD, 28));
		lbl_weightValue.setBounds(165, 30, 236, 53);
		add(lbl_weightValue);
		
		JLabel lbl_kg = new JLabel("Kg");
		lbl_kg.setFont(new Font("ËÎÌו", Font.BOLD, 32));
		lbl_kg.setBounds(427, 39, 90, 33);
		add(lbl_kg);
		
		JButton btn_peel = new JButton("\u53BB\u76AE");
		btn_peel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				serialCom.sendCom(ByteUtils.hexToByteArray(SerialProtocol.peelCMD));
			}
		});
		btn_peel.setToolTipText("\u53BB\u76AE\u64CD\u4F5C");
		btn_peel.setIcon(SwingUtil.createAutoAdjustIcon(ToolView.class.getResource("/images/peel_normal.png"), true));
		btn_peel.setBounds(570, 10, 90, 91);
		add(btn_peel);

	}

	@Override
	public void update(Message message) {
		// TODO Auto-generated method stub
		String weightString = Integer.toString(message.getWeight());
		lbl_weightValue.setText(weightString);
		
	}
}

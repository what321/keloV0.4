package edu.ciit.iot.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class informationView extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			informationView dialog = new informationView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public informationView() {
		setTitle("about");
		setBounds(-7, 100, 615, 249);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Version:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setBounds(71, 9, 113, 60);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("v0.1");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_1.setBounds(209, 9, 96, 60);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BBE\u5907\u4EE3\u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("ËÎÌו", Font.BOLD, 24));
		lblNewLabel_2.setBounds(71, 78, 139, 60);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("001");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_3.setBounds(209, 78, 85, 60);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("BuildID:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_4.setBounds(322, 9, 104, 60);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("MuQi");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_5.setBounds(460, 9, 119, 60);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u4F01\u4E1A\u4EE3\u7801\uFF1A");
		lblNewLabel_2_1.setFont(new Font("ËÎÌו", Font.BOLD, 24));
		lblNewLabel_2_1.setBounds(322, 78, 139, 60);
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_6 = new JLabel("ciit");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_6.setBounds(460, 78, 78, 60);
		getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("ËÎÌו", Font.PLAIN, 26));
		btnNewButton.setBounds(241, 148, 119, 54);
		getContentPane().add(btnNewButton);
	}
}

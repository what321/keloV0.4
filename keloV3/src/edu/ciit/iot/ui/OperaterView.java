package edu.ciit.iot.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.JTextField;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamUtils;
import com.github.sarxos.webcam.util.ImageUtils;

import cn.hutool.json.JSONUtil;
import edu.ciit.iot.database.DBtool;
import edu.ciit.iot.database.OperateRecorder;
import edu.ciit.iot.database.Operater;
import edu.ciit.iot.face.*;
import edu.ciit.iot.util.UtilFun;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OperaterView extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	
	private static JSONObject result;
	private static JsonRootBean resultElement;
	private static int err_code;
	private String userId;
	private JLabel lbl_nameChange;

	private boolean flag = true;
	/**
	 * Create the panel.
	 */
	public OperaterView() {
		setLayout(null);
		
		
		JLabel lbl_id = new JLabel("\u5DE5\u53F7");
		lbl_id.setFont(new Font("宋体", Font.BOLD, 20));
		lbl_id.setBounds(11, 23, 55, 40);
		add(lbl_id);
		
		JLabel lblNewLabel = new JLabel("\u5BC6\u7801");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel.setBounds(280, 23, 78, 40);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(369, 26, 195, 39);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(77, 26, 192, 40);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lbl_name = new JLabel("\u59D3\u540D\uFF1A");
		lbl_name.setFont(new Font("宋体", Font.BOLD, 20));
		lbl_name.setBounds(16, 90, 83, 29);
		add(lbl_name);
		
		lbl_nameChange = new JLabel(" ");
		lbl_nameChange.setFont(new Font("宋体", Font.BOLD, 18));
		lbl_nameChange.setBounds(94, 90, 178, 29);
		add(lbl_nameChange);
		
		JButton btn_login = new JButton("\u5BC6\u7801\u767B\u5F55");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl_nameChange.setText("");
				//得到登录id
				String idString = textField_1.getText().trim();
				//得到登录密码MD5加密后的字符串
				String psssWordString = textField.getText().trim();
				String md5PWSDString = UtilFun.encryption(psssWordString);
				//根据id获得操作员信息
				List<Operater> listOperaters = DBtool.query(idString, md5PWSDString);
				if(!listOperaters.isEmpty()) {
					Operater operater = listOperaters.get(0);
					//显示操作员姓名
					lbl_nameChange.setText(operater.getName());
					
					OperateRecorder operateRecorder = OperateRecorder.getinstance();
					operateRecorder.setOperateId(idString);
				}
				
				
			}
		});
		btn_login.setFont(new Font("宋体", Font.PLAIN, 20));
		btn_login.setBounds(575, 24, 113, 39);
		add(btn_login);
		
		JButton btn_faceLogin = new JButton("\u4EBA\u8138\u767B\u5F55");
		btn_faceLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				AipFace client = GetAuth.getToken();
				
				CameraView cameraView = new CameraView();
				cameraView.setVisible(true);
				
				CameraTask cameraTask = new CameraTask(cameraView, client, textField_1, lbl_nameChange);
				cameraTask.start();
			}
				
//			
		});
		btn_faceLogin.setFont(new Font("宋体", Font.PLAIN, 20));
		btn_faceLogin.setBounds(699, 24, 113, 39);
		add(btn_faceLogin);
		
		

	}
}

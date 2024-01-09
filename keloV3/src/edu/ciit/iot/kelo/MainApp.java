package edu.ciit.iot.kelo;

import edu.ciit.iot.serial.SerialCom;
import edu.ciit.iot.serial.SerialParameter;
import edu.ciit.iot.ui.MainView;


public class MainApp {

	public static void main(String[] args) {
		
		
		SerialParameter serialParameter = SerialParameter.getinstance();
		SerialCom serialCom = SerialCom.getinstance();
		
				
		
		// TODO Auto-generated method stub
		MainView mainView = new MainView(serialParameter, serialCom);
		mainView.setVisible(true);
		
		TimeTask timeTask = new TimeTask(serialCom);
		timeTask.start();
		
		
		
	}

}

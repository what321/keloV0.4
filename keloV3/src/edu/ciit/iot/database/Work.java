package edu.ciit.iot.database;

import edu.ciit.iot.serial.Message;
import edu.ciit.iot.serial.SerialCom;
import edu.ciit.iot.serial.SerialComListener;
import edu.ciit.iot.database.OperateRecorder;
import edu.ciit.iot.serial.SerialProtocol;

public class Work implements SerialComListener{
	
	

	@Override
	public void update(Message message) {
		// TODO Auto-generated method stub
		OperateRecorder operateRecorder = OperateRecorder.getinstance();
		if(message.getWeight()>operateRecorder.getMaxweight()) {
			
			byte[] sendCmd =  SerialProtocol.getDouputCmd(3, true);
			SerialCom serialCom = SerialCom.getinstance();
			serialCom.sendCom(sendCmd);
			
			operateRecorder.setEndWight(message.getWeight());
		}
		
		
		
	}
	
	

}

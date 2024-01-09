package test;

import edu.ciit.iot.serial.SerialCom;
import edu.ciit.iot.serial.SerialParameter;
import edu.ciit.iot.util.ByteUtils;

public class SerialTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SerialParameter parameter = SerialParameter.getinstance();
		parameter.setBaudRate("9600");
		parameter.setSerialPort("COM1");
		
//		SerialCom serialCom = new SerialCom();
		SerialCom serialCom = SerialCom.getinstance();
		serialCom.openPort(parameter);
		
//		byte[] aa = "abc".getBytes();
//		serialCom.sendCom(aa);
		
		byte[] bb = ByteUtils.hexToByteArray("0141C010");
		serialCom.sendCom(bb);

	}

}

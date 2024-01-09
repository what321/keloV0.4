package edu.ciit.iot.serial;

import java.io.Serial;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import edu.ciit.iot.database.Work;
import edu.ciit.iot.util.*;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

public class SerialCom extends Subject{
	private SerialPort serialPort;
	private boolean isopen = false;
	
	
	public SerialPort getSerialPort() {
		return serialPort;
	}
	public void setSerialPort(SerialPort serialPort) {
		this.serialPort = serialPort;
	}
	public boolean isIsopen() {
		return isopen;
	}
	public void setIsopen(boolean isopen) {
		this.isopen = isopen;
	}
	
	//单例模式
	private static SerialCom instance = new SerialCom();
	private SerialCom() {};
	public static SerialCom getinstance() {
		if (instance!=null) {
			return instance;
			
		} else {
			return new SerialCom();

		}
		
	}
	
	
	
	
	//罗列所有可用串口
	public static List<String> listPorts(){
		List<String> portNameList = new ArrayList<>();
		Set<String> set = new HashSet<>();
		
		SerialPort[] serialPorts = SerialPort.getCommPorts();
		for (SerialPort serialPort:serialPorts) {
			if(set.add(serialPort.getSystemPortName()))
				portNameList.add(serialPort.getSystemPortName());
		}
		
		return portNameList;
	}

	//打开指定串口
	public void openPort(SerialParameter parameter) {
		Message message = Message.getinstance();
		
		serialPort = SerialPort.getCommPort(parameter.getSerialPort());
		int baudrate = Integer.parseInt(parameter.getBaudRate());
		
		if (baudrate == 0) {
			System.out.println("baudrate is 0!!!");
			
		} 
		if (serialPort.isOpen()) {
			System.out.println("COM Port is in use!!!");
			
		}else {
			serialPort.openPort(1000);
			serialPort.setFlowControl(serialPort.FLOW_CONTROL_DISABLED);
			serialPort.setComPortParameters(baudrate, 8,SerialPort.TWO_STOP_BITS, SerialPort.NO_PARITY);
			serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING|SerialPort.TIMEOUT_WRITE_BLOCKING, 1000, 1000);
			
			isopen = true;
			message.setIsopen(true);
			notifyObseverUpdate(message);
			
		}
		
		serialPort.addDataListener(new SerialReader());
		
		
	}
	
	private class SerialReader implements SerialPortDataListener {

		@Override
		public int getListeningEvents() {
			// TODO Auto-generated method stub
			return serialPort.LISTENING_EVENT_DATA_RECEIVED;
		}

		@Override
		public void serialEvent(SerialPortEvent arg0) {
			// TODO Auto-generated method stub
			byte[] newData = arg0.getReceivedData();
			
//			System.out.println(newData);
//			System.out.println(ByteUtils.bytesToHexString(newData));
//			System.out.println( new String(newData));
			
			//判断是否为本机（设备号0x01）
			if(newData[0] != (byte)0x01) return;
			//判断指令
			if(newData[1] == (byte)0x41) {
				//解析并填充message
				Message message = SerialProtocol.getState(newData, newData.length);
//				System.out.println(message);
				
				notifyObseverUpdate(message);
			}
			
		}
		
		
	}
	
	public boolean closePort() {
		Message message = Message.getinstance();
		if (isopen) {
			serialPort.closePort();
			
			message.setIsopen(false);
			notifyObseverUpdate(message);
			System.out.println(isopen);
			
		}
		return true;
	}
	
	
	
	
	
	public void sendCom(byte[] cmd) {
		if (!isopen) {
			return;
			
		} 
		serialPort.writeBytes(cmd, cmd.length);	
		
	}
	

}


package edu.ciit.iot.serial;

public class SerialParameter {
	private String serialPort;
	private String baudRate;
	
	private static SerialParameter instance = new SerialParameter();
	private SerialParameter(){}
	
	public static SerialParameter getinstance(){
		if (instance!=null) {
			return instance;
		} else {
			return new SerialParameter();
		}
	      
	   }
	
	public String getSerialPort() {
		return serialPort;
	}
	public void setSerialPort(String serialPort) {
		this.serialPort = serialPort;
	}
	public String getBaudRate() {
		return baudRate;
	}
	public void setBaudRate(String baudRate) {
		this.baudRate = baudRate;
	}
	
	@Override
	public String toString() {
		return "SerialParameter [serialPort=" + serialPort + ", baudRate=" + baudRate + "]";
	}

	
}

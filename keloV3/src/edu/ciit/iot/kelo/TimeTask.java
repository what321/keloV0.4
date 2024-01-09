package edu.ciit.iot.kelo;

import edu.ciit.iot.serial.SerialCom;
import edu.ciit.iot.util.ByteUtils;

public class TimeTask extends Thread {
	private SerialCom serialCom;

	public TimeTask(SerialCom serialCom) {
		super();
		this.serialCom = serialCom;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			//得到命令
			byte[] bb = ByteUtils.hexToByteArray("0141C010");
			//下发命令
			serialCom.sendCom(bb);
			//休眠
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	

}

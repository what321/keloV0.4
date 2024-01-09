package edu.ciit.iot.database;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class Demo {

	public static void main(String[] args) {
		
//		Date date=new Date();
//		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		
		
		
		// TODO Auto-generated method stub
		OperateRecorder operateRecorder = OperateRecorder.getinstance();
		operateRecorder.setOperateId("0001");
		operateRecorder.setCylinderId("02");
		operateRecorder.setGasType("ΡυΖψ");
		operateRecorder.setBeginWeight(0);
		operateRecorder.setBeginWeight(100);
		operateRecorder.setOperateData("2023-11-01 00:00:00");
//		System.out.println(operateRecorder);
		DBtool.recode(operateRecorder);

	}

}

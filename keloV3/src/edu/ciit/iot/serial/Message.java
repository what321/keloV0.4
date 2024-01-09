package edu.ciit.iot.serial;

import java.io.ObjectOutputStream.PutField;
import java.util.HashMap;
import java.util.Map;

public class Message {
	//重量数据
	private int weight; 
	//读输入端口状态
	private Map<Integer, Boolean> dInput = new HashMap();
	//读输出端口状态
	private Map<Integer, Boolean> dOutput = new HashMap();
	//消息是否被改变
	private boolean isChanged = false;
	private boolean isopen = false;
	
	
	//用于扩展，当前未使用
//	@SuppressWarnings("unused")
//	private int humid = 0;
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Map<Integer, Boolean> getdInput() {
		return dInput;
	}
	public void setdInput(Map<Integer, Boolean> dInput) {
		this.dInput = dInput;
	}
	public Map<Integer, Boolean> getdOutput() {
		return dOutput;
	}
	public void setdOutput(Map<Integer, Boolean> dOutput) {
		this.dOutput = dOutput;
	}
	public boolean isChanged() {
		return isChanged;
	}
	public void setChanged(boolean isChanged) {
		this.isChanged = isChanged;
	}
	
	
	
	public boolean isIsopen() {
		return isopen;
	}
	public void setIsopen(boolean isopen) {
		this.isopen = isopen;
	}
	@Override
	public String toString() {
		return "Message [weight=" + weight + ", dInput=" + dInput + ", dOutput=" + dOutput + ", isChanged=" + isChanged
				+ ", isopen=" + isopen + "]";
	}
	
	//饿汉单例模式
	private static Message instance = new Message();
	private Message() {	};

	
	public static Message getinstance() {
		if (instance!=null) {
			return instance;
			
		} else {
			return new Message();

		}
		
	}
	
	
}

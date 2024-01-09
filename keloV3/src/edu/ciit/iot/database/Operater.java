package edu.ciit.iot.database;

import javax.management.loading.PrivateClassLoader;

import edu.ciit.iot.serial.SerialCom;

public class Operater {
	private String id;
	private String name;
	private String tel;
	private String addr;
	private boolean delFlag;
	private String passWord;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public boolean isDelFlag() {
		return delFlag;
	}
	public void setDelFlag(boolean delFlag) {
		this.delFlag = delFlag;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public Operater(String id, String name, String tel, String addr, boolean delFlag, String passWord) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.addr = addr;
		this.delFlag = delFlag;
		this.passWord = passWord;
	}
	
	public Operater() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
//	//µ¥ÀýÄ£Ê½
//		private static Operater instance = new Operater();
//		private Operater() {};
//		public static SerialCom getinstance() {
//			if (instance!=null) {
//				return instance;
//				
//			} else {
//				return new Operater();
//
//			}
//			
//		}
	
	
	@Override
	public String toString() {
		return "Operater [id=" + id + ", name=" + name + ", tel=" + tel + ", addr=" + addr + ", delFlag=" + delFlag
				+ ", passWord=" + passWord + "]";
	}
	
	
	

}

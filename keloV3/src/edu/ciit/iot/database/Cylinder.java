package edu.ciit.iot.database;

public class Cylinder {
	private String id;
	private String factory;
	private String rightUnit;
	private String gasType;
	private int tareWeight;
	private int maxWight;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFactory() {
		return factory;
	}
	public void setFactory(String factory) {
		this.factory = factory;
	}
	public String getRightUnit() {
		return rightUnit;
	}
	public void setRightUnit(String rightUnit) {
		this.rightUnit = rightUnit;
	}
	public String getGasType() {
		return gasType;
	}
	public void setGasType(String gasType) {
		this.gasType = gasType;
	}
	public int getTareWeight() {
		return tareWeight;
	}
	public void setTareWeight(int tareWeight) {
		this.tareWeight = tareWeight;
	}
	public int getMaxWight() {
		return maxWight;
	}
	public void setMaxWight(int maxWight) {
		this.maxWight = maxWight;
	}
	public Cylinder(String id, String factory, String rightUnit, String gasType, int tareWeight, int maxWight) {
		super();
		this.id = id;
		this.factory = factory;
		this.rightUnit = rightUnit;
		this.gasType = gasType;
		this.tareWeight = tareWeight;
		this.maxWight = maxWight;
	}
	public Cylinder() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Cylinder [id=" + id + ", factory=" + factory + ", rightUnit=" + rightUnit + ", gasType=" + gasType
				+ ", tareWeight=" + tareWeight + ", maxWight=" + maxWight + "]";
	}
	
	

}

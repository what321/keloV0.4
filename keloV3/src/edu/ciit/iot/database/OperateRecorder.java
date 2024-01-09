package edu.ciit.iot.database;


public class OperateRecorder {
	private int id;
	private String operateId;
	private String cylinderId;
	private String gasType;
	private int beginWeight;
	private int endWight;
	private String operateData;
	private int maxweight = 999999;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOperateId() {
		return operateId;
	}
	public void setOperateId(String operateId) {
		this.operateId = operateId;
	}
	public String getCylinderId() {
		return cylinderId;
	}
	public void setCylinderId(String cylinderId) {
		this.cylinderId = cylinderId;
	}
	public String getGasType() {
		return gasType;
	}
	public void setGasType(String gasType) {
		this.gasType = gasType;
	}
	public int getBeginWeight() {
		return beginWeight;
	}
	public void setBeginWeight(int beginWeight) {
		this.beginWeight = beginWeight;
	}
	public int getEndWight() {
		return endWight;
	}
	public void setEndWight(int endWight) {
		this.endWight = endWight;
	}
	public String getOperateData() {
		return operateData;
	}
	public void setOperateData(String operateData) {
		this.operateData = operateData;
	}
	
		public int getMaxweight() {
		return maxweight;
	}
	public void setMaxweight(int maxweight) {
		this.maxweight = maxweight;
	}

		//µ¥ÀýÄ£Ê½
		private static OperateRecorder instance = new OperateRecorder();
		private OperateRecorder() {};
		public static OperateRecorder getinstance() {
			if (instance!=null) {
				return instance;
				
			} else {
				return new OperateRecorder();

			}
			
		}
		@Override
		public String toString() {
			return "OperateRecorder [id=" + id + ", operateId=" + operateId + ", cylinderId=" + cylinderId
					+ ", gasType=" + gasType + ", beginWeight=" + beginWeight + ", endWight=" + endWight
					+ ", operateData=" + operateData + ", maxweight=" + maxweight + "]";
		}
		
		
}

package com.preva.vo;

public class FuelSummaryDetails {
	private String deviceID,timestamp;
	private double fueltotal;
	
	
	
	public double getFueltotal() {
		return fueltotal;
	}
	public void setFueltotal(double fueltotal) {
		this.fueltotal = fueltotal;
	}
	public String getDeviceID() {
		return deviceID;
	}
	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	
	

}

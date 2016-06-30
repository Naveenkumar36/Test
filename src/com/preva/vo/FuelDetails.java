package com.preva.vo;

public class FuelDetails {
private String deviceID,timestamp,datestamp,statuscode,address;
private int serialID;
private double fueltotal,Speed;


public double getFueltotal() {
	return fueltotal;
}
public void setFueltotal(double fueltotal) {
	this.fueltotal = fueltotal;
}
public String getDatestamp() {
	return datestamp;
}
public void setDatestamp(String datestamp) {
	this.datestamp = datestamp;
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
public String getStatuscode() {
	return statuscode;
}
public void setStatuscode(String statuscode) {
	this.statuscode = statuscode;
}

public double getSpeed() {
	return Speed;
}
public void setSpeed(double speed) {
	Speed = speed;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

public int getSerialID() {
	return serialID;
}
public void setSerialID(int serialID) {
	this.serialID = serialID;
}

}

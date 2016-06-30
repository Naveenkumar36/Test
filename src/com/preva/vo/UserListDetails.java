package com.preva.vo;

import java.io.Serializable;

public class UserListDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String vehiclegroup,vehiclename,drivername,deviceID,date,speed,lastlocation,latitude,longitude,statuscode;
	public String getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(String statuscode) {
		this.statuscode = statuscode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	private int serialID;
	public String getVehiclegroup() {
		return vehiclegroup;
	}

	public void setVehiclegroup(String vehiclegroup) {
		this.vehiclegroup = vehiclegroup;
	}

	public int getSerialID() {
		return serialID;
	}

	public void setSerialID(int serialID) {
		this.serialID = serialID;
	}

		public String getVehiclename() {
		return vehiclename;
	}

	public void setVehiclename(String vehiclename) {
		this.vehiclename = vehiclename;
	}

	public String getDrivername() {
		return drivername;
	}

	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}

	public String getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	/*public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}*/

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getLastlocation() {
		return lastlocation;
	}

	public void setLastlocation(String lastlocation) {
		this.lastlocation = lastlocation;
	}

	public void setInt(int i) {
		// TODO Auto-generated method stub
		
	}
	

}

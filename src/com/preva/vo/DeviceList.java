package com.preva.vo;

import java.io.Serializable;

public class DeviceList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String  deviceID;
	private String description;

		public String getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}

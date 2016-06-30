package com.preva.dao;

import java.io.IOException;
import java.util.List;



import com.preva.vo.DeviceList;


public interface DeviceListDAOI {
	public List<DeviceList> getDeviceList() throws IOException;
	

}

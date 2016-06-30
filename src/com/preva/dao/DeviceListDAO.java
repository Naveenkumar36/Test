package com.preva.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.preva.controller.FuelDBProcess;
import com.preva.dao.util.DBConnectionFactory;
import com.preva.vo.DeviceList;;


public class DeviceListDAO implements DeviceListDAOI,Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<DeviceList> getDeviceList() throws IOException {
		Connection con=null;
		List<DeviceList> devicelist = new ArrayList<DeviceList>();
		Properties p=new Properties();
		InputStream is= DeviceListDAO.class.getClassLoader().getResourceAsStream("jdbc.properties");
		p.load(is);
		String accountID = p.getProperty("accountId");
		try{
			
			con= DBConnectionFactory.getDBConnection();
			String sql="SELECT  DeviceID,Description FROM Device WHERE  accountID='"+accountID+"'";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			System.out.println("<-------------Device DAO----------->");
			while (rs.next()){
				DeviceList device=new DeviceList();
				device.setDeviceID((rs.getString(1)));
				device.setDescription((rs.getString(2)));
				devicelist.add(device);
			  }
			}catch (Exception e) {
				e.printStackTrace();
				
			}
	
			return devicelist;
			
		
		}

	
}

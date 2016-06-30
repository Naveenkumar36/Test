package com.preva.dao.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/** 
 * @author Harinath 
 */  
public class DBConnectionFactory {
	
	private static Driver d;
	private static Properties p;
	private static String url;
	
	static {
		try{
		p=new Properties();
		

		InputStream is= DBConnectionFactory.class.getClassLoader().
		getResourceAsStream("jdbc.properties");
		p.load(is);
		

		 Class.forName( p.getProperty("driverClassName"));

		d=(Driver)(Class.forName( p.getProperty("driverClassName"))).newInstance();

		url=p.getProperty("url");
		

		}catch(Exception e){
			System.out.println("Failed Loading Driver");
			throw new RuntimeException( "Failed Loading DBConnectionFactory");
		}
	}//static

	public static Connection getDBConnection()throws SQLException {
		return d.connect(url, p);
	}//getDBConnection
};//class
package com.preva.dao;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.preva.dao.util.DBConnectionFactory;
import com.preva.vo.FuelDetails;
import com.preva.vo.FuelSummaryDetails;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements UserDAOI,Serializable {
   
    /**
     *
     */
    private static final long serialVersionUID = 1L;


   
   
   
    public List<FuelDetails> getFuelDetails(String accountID,String deviceID,String Timestamp1,String Timestamp2) {
        Connection con=null;
        List<FuelDetails> fuelDetails = new ArrayList<FuelDetails>();
        try{
            con= DBConnectionFactory.getDBConnection();
            int count=1;
            String sql="SELECT a.accountID,a.deviceID,a.TIMESTAMP,a.statuscode,a.address,a.speedKPH,a.fuelTotal FROM EventData a WHERE (a.TIMESTAMP BETWEEN '"+Timestamp1+"' AND '"+Timestamp2+"') AND a.accountID='"+accountID+"' AND a.deviceID='"+deviceID+"'";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            System.out.println("<-------------------Fuel details-------------->");
            while (rs.next()){
                FuelDetails fd=new FuelDetails();
                fd.setSerialID(count);
                fd.setDeviceID(rs.getString(2));
                String stringtimestamp=rs.getString(3);
                 long l=Long.parseLong(stringtimestamp);
                 long longtimestamp = l * 1000L;
                 String datestring= new java.text.SimpleDateFormat("dd MMM HH:mm").format(new java.util.Date(longtimestamp));
                    fd.setDatestamp(datestring);
                    String status=rs.getString(4);
                   
                    System.out.print(""+status);
                if(status.equalsIgnoreCase("61714")){
                    fd.setStatuscode("InMotion");
                }
                if(status.equalsIgnoreCase("61715")){
                    fd.setStatuscode("Stop");
                }   
                String address=rs.getString(5);
                String address1[]=address.split(" \\d");
                fd.setAddress(address1[0]);
                String speed1=rs.getString(6);
                double speed=Double.parseDouble(speed1);
                double Speed = Math.round(speed);
                fd.setSpeed(Speed);
                String fuel=rs.getString(7);
                double fueltotal=Double.parseDouble(fuel);
                double roundOff = Math.round(fueltotal);
                fd.setFueltotal(roundOff);
                fuelDetails.add(fd);
                count++;
              }
           
            }catch (Exception e) {
            	System.out.println("Exception In UserDao"+e);
                e.printStackTrace();
               
            }
        return fuelDetails;
       
        }
    public List<FuelSummaryDetails> getFuelSummaryDetails(String accountID,String deviceID,String Timestamp1,String Timestamp2) {
        Connection con=null;
        List<FuelSummaryDetails> fuelsumDetails = new ArrayList<FuelSummaryDetails>();
        try{
           
       
            con= DBConnectionFactory.getDBConnection();

            String sql="SELECT accountID,deviceID,TIMESTAMP,fuelTotal FROM EventData WHERE (TIMESTAMP BETWEEN '"+Timestamp1+"' AND '"+Timestamp2+"') AND accountID='"+accountID+"' AND deviceID='"+deviceID+"'";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            System.out.println("<-------------------Fuel Summary details-------------->");
       
            double temp=0.0,total=0.0;
           
            while (rs.next()){
                FuelSummaryDetails fd1=new FuelSummaryDetails();
           
                fd1.setDeviceID(rs.getString(2));
                String stringtimestamp=rs.getString(3);
                 long l=Long.parseLong(stringtimestamp);
                 long longtimestamp = l * 1000L;
                 String datestring= new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date(longtimestamp));
                    fd1.setTimestamp(datestring);
                String fuel=rs.getString(4);
                double fuel1=Double.parseDouble(fuel);
               
                System.out.println("<-------------------Fuel-------------->"+fuel1);
                  total=total+(fuel1-temp);
              
                fd1.setFueltotal(total);
                fuelsumDetails.add(fd1);
               
                   temp=fuel1;
                    System.out.println("<-------------------Total-------------->"+total);
              }   
             
            }catch (Exception e) {
                e.printStackTrace();
               
            }finally{
                try {
                    con.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
               
            }
       
            return fuelsumDetails;
           
       
        }
   
}
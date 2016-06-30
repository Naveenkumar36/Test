package com.preva.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.preva.dao.DeviceListDAO;
import com.preva.dao.UserDAO;
import com.preva.vo.DeviceList;
import com.preva.vo.FuelDetails;


/**
 * Servlet implementation class FuelDBProcess
 */
public class FuelDBProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FuelDBProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
				response.setContentType("text/html");
				HttpSession session=request.getSession(true);
			//	String pass=(String)session.getAttribute("pass");
				Properties p=new Properties();
				InputStream is= FuelDBProcess.class.getClassLoader().getResourceAsStream("jdbc.properties");
				p.load(is);
				String accountID = p.getProperty("accountId");
				String deviceID=request.getParameter("vehicleId");
				String fromdate=request.getParameter("AnotherDate");
				String todate=request.getParameter("ADate");
			    session.setAttribute("vid",deviceID);
			    session.setAttribute("fromdate",fromdate);
			    session.setAttribute("startdate",todate);
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm"); 
				Date startD = (Date) sdf.parse(fromdate);
				Date endD = (Date) sdf.parse(todate);
				Calendar cal1 = Calendar.getInstance();
				Calendar cal2 = Calendar.getInstance();
				cal1.setTime(startD);
				cal2.setTime(endD);
				long timestamp1,timestamp2;
				timestamp1=cal1.getTimeInMillis()/1000;
				timestamp2=cal2.getTimeInMillis()/1000;
				String Timestamp1 = Long.toString(timestamp1);
				System.out.println(Timestamp1);
				String Timestamp2 = Long.toString(timestamp2);
				DeviceListDAO devicelistdao=new DeviceListDAO();
				List<DeviceList> devicelist=devicelistdao.getDeviceList();
				for(DeviceList dl:devicelist)
				{
					if(dl.getDeviceID().equalsIgnoreCase(deviceID))
					{
						String description=dl.getDescription();
						session.setAttribute("description",description);
					}
				}
			
			
				UserDAO rdao=new UserDAO();
				List<FuelDetails> fuelDetails=rdao.getFuelDetails(accountID, deviceID, Timestamp1, Timestamp2);
				if (!(fuelDetails.isEmpty())){
					
				String precisionFactor1 = p.getProperty("precisionFactor");
				float precisionFactor=Float.parseFloat(precisionFactor1);
				System.out.println("precisionFactor"+precisionFactor);
					int count = 0;
					int c=0;
					int serialID=1;
					List<FuelDetails> fdList = new ArrayList<FuelDetails>();
					for(FuelDetails fd : fuelDetails)
					{
						if(fd.getStatuscode().equalsIgnoreCase("Stop")){
							if(count == 0){
								count++;
								c=0;
								System.out.println(" First if c:"+c);
								System.out.println("First if count:"+count);
							}
						}else
							{
								if(c>=3 && fd.getFueltotal()>=2){
									fd.setSerialID(serialID);
										fdList.add(fd);
											count = 0;
											serialID++;
												System.out.println(" second c :"+c);
												System.out.println("second count: "+count);
       
								}
								c++;
       
							}
					}

					double previousFuel,FuelDiff1,FuelDiff=0.0;
					previousFuel=fdList.size()>0 ? fdList.get(0).getFueltotal() : 0.0;
					int serialID1=1;
					List<FuelDetails> finalfdList = new ArrayList<FuelDetails>();
					for(FuelDetails fd1 : fdList){
						double currentfuel=fd1.getFueltotal();
						FuelDiff1=Math.abs(currentfuel-previousFuel);
						System.out.println("currentfuel"+currentfuel);
						System.out.println("previousFuel"+previousFuel);
						System.out.println("FuelDiff"+FuelDiff);
						if(FuelDiff1<=precisionFactor || FuelDiff1==FuelDiff){
							fd1.setSerialID(serialID1);
							finalfdList.add(fd1);
							serialID1=serialID1+1;
							System.out.println("serial"+serialID1);
						}
						previousFuel=currentfuel;
						FuelDiff=FuelDiff1;
					}	

					session.setAttribute("fueldetails", finalfdList);
					
					
					System.out.print(""+finalfdList);
					
				}
				String action=request.getParameter("action");
			
				if("Show Report" .equalsIgnoreCase(action)){
					RequestDispatcher rd=request.getRequestDispatcher("FuelDBReport.jsp");
					rd.forward(request,response);
				}else if("Show Graph" .equalsIgnoreCase(action)){
					RequestDispatcher rd=request.getRequestDispatcher("FuelDBGraph.jsp");
					rd.forward(request,response); 
				}
				
					
				
			}catch (Exception e) {
// TODO: handle exception
			}

}
}
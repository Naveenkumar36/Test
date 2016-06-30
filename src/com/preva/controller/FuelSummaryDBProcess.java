package com.preva.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.preva.dao.UserDAO;
import com.preva.vo.FuelSummaryDetails;

/**
 * Servlet implementation class FuelSummaryDBProcess
 */
public class FuelSummaryDBProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FuelSummaryDBProcess() {
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
			
			String accountID="vijaymangla";
			String deviceID=request.getParameter("vehicleId");
			String fromdate=request.getParameter("AnotherDate");
			String todate=request.getParameter("ADate");
			
		    session.setAttribute("vid",deviceID);
		    session.setAttribute("fromdate",fromdate);
		    session.setAttribute("startdate",todate);
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
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
			String Timestamp2 = Long.toString(timestamp2);
			
			
			
			UserDAO rdao=new UserDAO();
			List<FuelSummaryDetails> fuelsumDetails=rdao.getFuelSummaryDetails(accountID, deviceID, Timestamp1, Timestamp2);
			 FuelSummaryDetails fsd = fuelsumDetails.get(fuelsumDetails.size() - 1);	
			 List<FuelSummaryDetails> fsdList = new ArrayList<FuelSummaryDetails>(); 
			 fsdList.add(fsd);
				        	 session.setAttribute("fuelsumdetails", fsdList);
				        		 RequestDispatcher rd=request.getRequestDispatcher("FuelDBSummaryReport.jsp");
									rd.forward(request,response);
				       
		         
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}

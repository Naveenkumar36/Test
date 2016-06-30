package com.preva.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.preva.dao.DeviceListDAO;
import com.preva.vo.DeviceList;


/**
 * Servlet implementation class StoppageProcess
 */
public class FuelProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FuelProcess() {
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
		
		
		
		
			response.setContentType("text/html");
			HttpSession session=request.getSession(true);
			
			System.out.println("<---------Fuel Process--------------->");
			DeviceListDAO devicelistdao=new DeviceListDAO();
			List<DeviceList> devicelist=devicelistdao.getDeviceList();
				         if(devicelist!=null){
				        	
				        	 session.setAttribute("devicelists", devicelist);
				        		 RequestDispatcher rd=request.getRequestDispatcher("FuelReport.jsp");
									rd.include(request,response);
				        	return;
				         }	
				         RequestDispatcher rd=request.getRequestDispatcher("Header.jsp");
							rd.forward(request,response);
							
		        	 
		        	 
		         
		
	
	}

}

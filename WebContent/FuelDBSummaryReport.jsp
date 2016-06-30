<%@ page language="java" session="true"contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.preva.vo.DeviceList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/displaytag.css" type="text/css">  
<link rel="stylesheet" href="css/screen.css" type="text/css">  
<link rel="stylesheet" href="css/site.css" type="text/css">  
<link href="css/sty.css" rel="stylesheet" type="text/css" />
<link href="css/tabborder.css" rel="stylesheet" type="text/css" />
</head>
<body>
		    

<jsp:include page="Header.jsp" />

			        
            <c:choose>
    <c:when test="${not empty fuelsumdetails}"> 
			<table id="display_table">
            <tr ><td><b>Fuel Summary Details</b></td></tr>
            <tr ><td><b><%=request.getParameter("vehicleId") %></b></td></tr>
            <tr><td>From &nbsp;<%=session.getAttribute("fromdate") %>&nbsp;to&nbsp;<%=session.getAttribute("startdate") %></td></tr>
            
            </table>
            
            <display:table id="deviceDetailsID" name="sessionScope.fuelsumdetails"  pagesize="10" export="true" sort="list">
 
   <display:setProperty name="basic.empty.showtable" value="true" />
   <display:setProperty name="paging.banner.placement">none</display:setProperty>
  
    <display:column property="deviceID" title="Device ID"  style="width: 1%"/>
     <display:column title="From Date" ><%=session.getAttribute("fromdate") %></display:column>
        <display:column property="timestamp" title="To Date" />
     <display:column property="fueltotal" title="FuelTotal" />
</display:table> 
  </c:when>
	    <c:otherwise>

	    <jsp:include page="pages/FuelSummarybody.jsp" />

<table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF">
	<tr class="topheader">
		<td colspan="6" style="color:white;">Fuel Summary report for <%=request.getParameter("vehicleId") %> from <%=session.getAttribute("fromdate") %> to <%=session.getAttribute("startdate") %> </td>
	</tr>
	
	
	<tr class="secondhedr">
		<td colspan="6" style="color:white;">No data found</td>
	</tr>
	
</table>
    </c:otherwise>
</c:choose>		 
	<jsp:include page="Footer.jsp"/>	
		
		
</body>
</html>
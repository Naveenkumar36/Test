<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> <title>Preva Tracking Systems</title>
<link rel="icon" href="pictures/preva_logo.png" />
<link rel="stylesheet" href="css/displaytag.css" type="text/css">  
<link rel="stylesheet" href="css/screen.css" type="text/css">  
<link rel="stylesheet" href="css/site.css" type="text/css">  
<link href="css/sty.css" rel="stylesheet" type="text/css" />
<link href="css/tabborder.css" rel="stylesheet" type="text/css" />
</head>
<body>

<jsp:include page="Header.jsp" />

		        
            <c:choose>
    <c:when test="${not empty sessionScope.fueldetails}"> 
			<table id="display_table">
            <tr ><td style="text-align:center;"><b>Fuel Details</b></td></tr>
          <tr ><td style="text-align:center;"><b><%=session.getAttribute("description") %></b>
            <b><%=session.getAttribute("vid") %></b> 
            </td></tr>
            <tr><td style="text-align:center;">From &nbsp;<%=session.getAttribute("fromdate") %>&nbsp;to&nbsp;<%=session.getAttribute("startdate") %></td></tr>
            
            </table>
            
            <display:table id="deviceDetailsID" name="sessionScope.fueldetails"  pagesize="10" export="true" sort="list">
 
   <display:setProperty name="basic.empty.showtable" value="true" />
  <display:setProperty name="paging.banner.group_size" value="10" />
    <display:setProperty name="paging.banner.item_name" value="Record" />
    <display:setProperty name="paging.banner.item_names" value="Records" />
     <display:setProperty name="export.csv.filename" value="FuelReport.csv"/>
     <display:setProperty name="export.excel.filename" value="FuelReport.xlxs"/>
      <display:setProperty name="export.xml.filename" value="FuelReport.xml"/>
      
   <display:column property="serialID" title="Sl.No"  style="width: 1%"/>
    <display:column property="deviceID" title="Device ID"  style="width: 1%"/>
    <display:column property="datestamp" title="DATE/Time"  format="{0,date,dd-MM-yyyy}"/>
    <display:column property="statuscode" title="Status"/>
     <display:column property="fueltotal" title="FuelTotal" />
    <display:column property="address" title="Address" />
</display:table> 
  </c:when>
	    <c:otherwise>

	    <jsp:include page="pages/Fuelbody.jsp" />

			<table width="100%" border="1" cellpadding="0" cellspacing="0"
				bordercolor="#FFFFFF">
				<tr class="topheader">
					<td colspan="6" style="color: white; text-align: center;">Fuel
						Report for <%=session.getAttribute("description")%> [<%=session.getAttribute("vid")%> ]
						from <%=session.getAttribute("fromdate")%> to <%=session.getAttribute("startdate")%>
					</td>
				</tr>


				<tr class="secondhedr">
					<td colspan="6" style="color: white; text-align: center;">No
						data found</td>
				</tr>

			</table>
		</c:otherwise>
</c:choose>		 
	<jsp:include page="Footer.jsp"/>	
		
		
</body>
</html>
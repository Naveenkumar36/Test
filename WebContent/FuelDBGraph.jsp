<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "com.preva.vo.DeviceList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Preva Tracking Systems</title>
<link rel="icon" href="pictures/preva_logo.png" />
<link rel="stylesheet" href="css/displaytag.css" type="text/css">  
<link rel="stylesheet" href="css/screen.css" type="text/css">  
<link rel="stylesheet" href="css/site.css" type="text/css">  
<link href="css/sty.css" rel="stylesheet" type="text/css" />
<link href="css/tabborder.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
 <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Date', 'Fuel '],
          <c:forEach var="data" items="${fueldetails}">
        ['${data.datestamp}',${data.fueltotal}],
        </c:forEach>
        ]);

        var options = {
          title: 'Graphical Representation of Fuel Consumption',
          vAxis: {textStyle: {
              color: '#9900ff',bold:'true'
          },title: 'Fuel (litre)',minValue:' 0',titleTextStyle: {color: '#9900ff',fontName:'TimesRoman',fontSize:'16', bold:'true', italic:'true'}},
            hAxis: {textStyle: {
                color: '#9900ff',bold:'true'
            },title: 'Date/Time',  titleTextStyle: {color: '#9900ff',fontName:'TimesRoman',fontSize:'16', bold:'true', italic:'true'}}
        };

        var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>

</head>
<body>
<jsp:include page="Header.jsp" />
 <c:choose>
    <c:when test="${not empty sessionScope.fueldetails}">
<table id="display_table">
            <tr ><td style="text-align:center;"><b>Fuel Details in Graph</b></td></tr>
            <tr ><td style="text-align:center;"><b><%=session.getAttribute("description") %></b></td></tr>
           <tr ><td style="text-align:center;"><b><%=session.getAttribute("vid") %></b></td></tr> 
                   <tr><td style="text-align:center;">From &nbsp;<%=session.getAttribute("fromdate") %>&nbsp;to&nbsp;<%=session.getAttribute("startdate") %></td></tr>
          
            </table>
    <div id="chart_div" style="width: 900px; height: 500px;"></div>
    </c:when>
        <c:otherwise>

        <jsp:include page="pages/Fuelbody.jsp" />

<table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF">
    <tr class="topheader">
        <td colspan="6" style="color:white;text-align:center;">Fuel Graph for <%=session.getAttribute("description") %>
        [<%=session.getAttribute("vid") %> ] from <%=session.getAttribute("fromdate") %> to <%=session.getAttribute("startdate") %> </td>
    </tr>
  
  
    <tr class="secondhedr">
        <td colspan="6" style="color:white;text-align:center;">No data found to display graph</td>
    </tr>
  
</table>
    </c:otherwise>
</c:choose>        
    <jsp:include page="Footer.jsp"/>  
  </body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.preva.vo.DeviceList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>TrackWISE&sup3;</title>
<link rel="icon" href="pictures/preva_logo.png"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/sty.css" rel="stylesheet" type="text/css" />
<link href="css/logotable.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/createsubuser.css" type="text/css">  
</head>
<body>
<table class="logo_table"  >
	<tr class="logo_row1_table">
		<td class="logo_col1_table" ><img src="pictures/preva_logo.png" width=160 height=53></td>
		<td class="logo_col2_table">
			Welcome<b> Ram </b>
			&nbsp;&nbsp;&nbsp;&nbsp;
			
			<%= new java.util.Date() %>
			<script type="text/javascript">
				document.write(formatDate(new Date(),"MM,dd,yyyy "));
			</script>
			
				&nbsp;&nbsp;&nbsp;&nbsp;
				<!--<a href="Signout.jsp" style="color: black;font-weight:700"><b>Logout</b></a>
			
			
		--></td>
	</tr>
</table>
<br>
<ul id="top-menu">
	<li id="menulist"><a href="http://117.218.63.242:4000/fuel/Track" >TrackWISE Home</a></li>
 
 <li><a href="#">Reports</a> 
  <ul>
        <li><a href="<%=request.getContextPath()%>/FuelProcess">Fuel Report</a></li><!--
         <li><a href="<%=request.getContextPath()%>/FuelSummaryProcess">Fuel Summary Report</a></li>
    --></ul> 
 </li>
 

</ul>
<div id="MenuLineDiv" style="width:100%; height: 2px; font-size: 2px; background-color: #FFCD44; position: relative; top: 18px;"></div>
<br></br>

</body>
</html>
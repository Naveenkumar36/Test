<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ page import = "com.preva.vo.DeviceList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Preva Tracking Systems</title>
<link rel="icon" href="pictures/preva_logo.png" />
<link href="css/sty.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/screen.css" type="text/css">  
<link rel="stylesheet" href="css/site.css" type="text/css">  
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="js/jquery.simple-dtpicker.js"></script>
	<link type="text/css" href="css/jquery.simple-dtpicker.css" rel="stylesheet" />
<script type="text/javascript" src="js/fieldsvalidate.js" >
</script>
</head>
<body>
<form  name="myForm" onsubmit="return validateForm()" action="FuelDBProcess" method="post">
<table width=100% border="1">
			<tr bgcolor=#075A99 >
			<td width=100% align=left><b><font color=white>Fuel Report</font></b></td>
			
			</tr>
			</table>
			
			
			
			   <table cellpadding="0" cellspacing="0" width="100%" class="reportSearchBorder">
	              <tr><td>&nbsp;</td></tr>
	               <tr>
		               <td width="100%">
		                            <table width="100%" cellpadding="0" cellspacing="0" border=0>			
			                          <tr>
				                          <td  align="left"  id="VehicleIdDescDiv" valign="middle">Vehicle Number</td>
				                             <td >
					                                 <table align=left border=0>
						                               <tr>
							                            <td  align=left>
							                                <select name="vehicleId"  class="txtbig"  ><option value="">Select vehicle number</option>
								                              <c:forEach var="vehiclelist" items="${devicelists}">
									                            <option value="${vehiclelist.deviceID}">${vehiclelist.description}</option>
									                            </c:forEach></select>
									                             
							                         </td>
						                            </tr>
						                            <tr><td align="center"></td></tr>
						                                <tr>
							                             <td valign="middle"></td>
							
						                             </tr>
						
					                              </table>
				                               </td>
				                  <td width="3%"></td>
				                  <td width="37%"></td>
				                  </tr></table>
				
				<table>
				
				             <tr><td>&nbsp;</td></tr>
			          <tr>
				           <td width="60%">
					        
<table>


<tr>
<td>From Date</td>
	<td>
	  		<input type="text" name="AnotherDate" id="AnotherDate" maxlength="25" size="25">
			<script type="text/javascript">
				$(function(){
					$('*[name=AnotherDate]').appendDtpicker({
						"closeOnSelected": true
					});
				});
			</script>
			<!--  <input type="Text" name="AnotherDate" id="demo1" maxlength="25" size="25"><a href="javascript:NewCal('demo1','ddMMyyyy',true,24)"><img src="pictures/cal.gif" width="16" height="16" border="0" alt="select"></a>-->
	  		<br>(eg:- 17-12-2013 19:14)
	</td><td width="30"></td><td width="30"></td>
	<td>To Date</td>
	<td><input type="text" name="ADate" id="ADate" maxlength="25" size="25">
			<script type="text/javascript">
				$(function(){
					$('*[name=ADate]').appendDtpicker({
						"closeOnSelected": true
					});
				});
			</script>
	  		<!-- <input type="Text" id="demo2" name="ADate" maxlength="25" size="25"><a href="javascript:NewCal('demo2','ddMMyyyy',true,24)"><img src="pictures/cal.gif" width="16" height="16" border="0" alt="select"></a> -->
	  		<br>(eg:- 17-12-2013 19:14)
	</td> 
</tr>
</table>
</td>
	    </tr>
	<tr><td>&nbsp;</td></tr>
	<tr>
		<td width="60%"><table width="100%" cellpadding="0" cellspacing="0">
			<tr>
				
				<td align="right"><input type="submit" value="Show Report" name="action" class="button1"></td>
				<td align="center"><input type="submit" value="Show Graph" name="action" class="button1"></td>
			
			</tr>
		</table></td>
	</tr>
	<tr><td>&nbsp;</td></tr>

</table>

			</td>	
			</tr>
		</table>				
	</form>
</body>
</html>
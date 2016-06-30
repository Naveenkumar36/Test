function validateForm() {

	var todayDate = new Date();
	var fromDate=document.myForm.AnotherDate.value;
	var toDate=document.myForm.ADate.value;
	
	/* var todayDate1 = todayDate.getFullYear() + "-" +
                   ("0" + (todayDate.getMonth() + 1)).slice(-2) + "-" +
                   ("0" + todayDate.getDate()).slice(-2) + " " + ("0" + todayDate.getHours()).slice(-2) + ":" +
                   ("0" + todayDate.getMinutes()).slice(-2);*/
	if(document.myForm.vehicleId.selectedIndex ==0 ){
		alert("Please select vehicle number");
		document.myForm.vehicleId.focus();
		return false;
	}
	if (document.myForm.speed.selectedIndex == 0){
		alert("Please select Speed");
		return false;
	}
	if (fromDate =="null"|| fromDate == ""){
		alert("Please select FromDate");
		document.myForm.AnotherDate.focus();
		return false;
	}
	var fromparts = fromDate.split(" ");
    var fromdate= fromparts[0];
    var fromtime=fromparts[1];
    var fromdayfield = fromdate.split("-")[0];
    var frommonthfield = fromdate.split("-")[1];
    var fromyearfield = fromdate.split("-")[2];
	var fromhourfield = fromtime.split(":")[0];
	var fromminfield = fromtime.split(":")[1];
	var fromsecfield = fromtime.split(":")[2];
	 var fromDate = new Date(fromyearfield, frommonthfield-1, fromdayfield,fromhourfield,fromminfield,fromsecfield);
	if (fromDate.getTime()>todayDate.getTime()){
		alert("Please select FromDate lessthan CurrentDate");
		document.myForm.AnotherDate.focus();
		return false;
	}
	 if (toDate == null || toDate == ""){
		alert("Please select ToDate");
		document.myForm.ADate.focus();
		return false;
	}
	 var toparts = toDate.split(" ");
	  var todate= toparts[0];
	  var totime=toparts[1];
	  var todayfield = todate.split("-")[0];
	  var tomonthfield = todate.split("-")[1];
	  var toyearfield = todate.split("-")[2];
	  var tohourfield = totime.split(":")[0];
	  var tominfield = totime.split(":")[1];
	  var tosecfield = totime.split(":")[2];
	  
	 
	  var toDate = new Date(toyearfield, tomonthfield-1, todayfield,tohourfield,tominfield,tosecfield);
	  if(toDate.getTime()>todayDate.getTime()){
		alert("Please select ToDate lessthan CurrentDate");
		document.myForm.ADate.focus();
		return false;
	}
	if (fromDate.getTime()>toDate.getTime()){
		alert("Please select FromDate lessthan ToDate");
		document.myForm.AnotherDate.focus();
		return false;
	}
	return true;
}
/*function validateForm() {
	
	var x=document.forms["myForm"]["vehicleId"].value;
	var y=document.forms["myForm"]["AnotherDate"].value;
	var z=document.forms["myForm"]["ADate"].value;
	var p=document.forms["myForm"]["speed"].value;
	
	if (x=="Select vehicle number" || x=="0")
	{
		alert("vehicle number cannot be empty");
		return false;
		}
	if (p=="0"||p=="Select")
	  {
	  alert("Speed cannot be empty");
	  return false;
	  }
	
	if (y==null || y=="")
	{
		alert("From Date cannot be empty");
		return false;
		}
	if (z==null || z=="")
		{
			alert("To Date cannot be empty");
			return false;
			}
	
	return true;		
}*/
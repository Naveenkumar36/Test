function validateForm() {
	var todayDate = new Date();
	var fromDate=document.myForm.AnotherDate.value;
	var toDate=document.myForm.ADate.value;
	
	if(document.myForm.vehicleId.selectedIndex ==0 ){
		alert("Please select vehicle number");
		document.myForm.vehicleId.focus();
		return false;
	} 
	if (document.myForm.AnotherDate.value == null || document.myForm.AnotherDate.value == ""){
		alert("Please select FromDate");
		document.myForm.AnotherDate.focus();
		return false;
	}
	var frommonthfield = fromDate.split("-")[1];
    var fromdayfield = fromDate.split("-")[0];
    var fromyearfield = fromDate.split("-")[2];
    var fromDate = new Date(fromyearfield, frommonthfield-1, fromdayfield);
	if (fromDate.getTime() >todayDate.getTime()){
		alert("Please select FromDate less CurrentDate");
		document.myForm.AnotherDate.focus();
		return false;
	}
	if (document.myForm.ADate.value == null || document.myForm.ADate.value == ""){
		alert("Please select ToDate");
		document.myForm.ADate.focus();
		return false;
	}
	 	var tomonthfield = toDate.split("-")[1];
	    var todayfield = toDate.split("-")[0];
	    var toyearfield = toDate.split("-")[2];
	    var toDate = new Date(toyearfield, tomonthfield-1, todayfield);
	if (toDate.getTime() >todayDate.getTime()){
		alert("Please select ToDate less CurrentDate");
		document.myForm.ADate.focus();
		return false;
	}
	if (fromDate.getTime() >toDate.getTime()){
		alert("Please select FromDate less ToDate");
		document.myForm.AnotherDate.focus();
		return false;
	}
	

	return true;
}



/*function validateForm() {
	
	var x=document.forms["myForm"]["vehicleId"].value;
	var y=document.forms["myForm"]["AnotherDate"].value;
	var z=document.forms["myForm"]["ADate"].value;
	if (x=="0"||"")
	  {
	  alert("vehicle numder cannot be empty");
	  document.getElementById('vehicleId').focus();
	  return false;
	  }
	 
	if (y==null || y=="")
	{
		alert("From Date cannot be empty");
		 document.getElementById('AnotherDate').focus();
		return false;
		}
	if (z==null || z=="")
		{
			alert("To Date cannot be empty");
			 document.getElementById('ADate').focus();
			return false;
			}
	 return days_between();
			
}
function days_between() {
	var date1=document.forms["myorm"]["AnotherDate"].value;
	var date2=document.forms["myForm"]["ADate"].value;
    // The number of milliseconds in one day
    var ONE_DAY = 1000 * 60 * 60 * 24;

    // Convert both dates to milliseconds
    var date1_ms = date1.getTime();
    var date2_ms = date2.getTime();

    // Calculate the difference in milliseconds
    var difference_ms = Math.abs(date1_ms - date2_ms);

    // Convert back to days and return
    var days=Math.round(difference_ms/ONE_DAY);
    
    if(days>=7){
		alert("Not to exceed between dates more than 7 days");
		return false;
	}
	return false;
}*/
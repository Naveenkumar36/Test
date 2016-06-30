function validateForm() {
	
	var x=document.forms["myForm"]["vehicleId"].value;
	var y=document.forms["myForm"]["AnotherDate"].value;
	var z=document.forms["myForm"]["ADate"].value;
	var p=document.forms["myForm"]["speed"].value;
	if (x=="0")
	  {
	  alert("vehicle numder cannot be empty");
	  return false;
	  }
	if (p=="Select" || p=="")
	{
		alert(" speed cannot be empty");
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
}
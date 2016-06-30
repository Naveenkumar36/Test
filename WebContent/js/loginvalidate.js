
function validateForm() {
	
	var x=document.forms["myForm"]["username"].value;
	var y=document.forms["myForm"]["password"].value;
	if (x==null ||x=="")
	  {
	  alert("UserName cannot be empty");
	  document.getElementById('username').focus();
	  return false;
	  }
	if (y==null || y=="")
	{
		alert(" Password cannot be empty");
		document.getElementById('password').focus();
		return false;
		}
	return true;		
}
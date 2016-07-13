<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>


  
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />


  


  

<script src="validations.js" type="text/javascript"></script>
  
  <title>Online Lab Services System</title>
  <link href="style.css" rel="stylesheet" type="text/css" />
  <style type="text/css">

  </style>
</head>


<body>

<% session.invalidate(); %>
<div id="contain">

<div id="header">
<h1> DESS RESORTS </h1>
</div>
<div class="navigation">

<ul class="nav">
	<li><a href="home.jsp">Home</a></li>
 	<li><a href="Login.jsp">Login</a></li>
 	<li><a href="#">&nbsp;</a></li>
  	<li><a href="#">&nbsp;</a></li>
  	<li><a href="#">&nbsp;</a></li>

  </ul>



</div><br/><br/><br/>



<div id="content">
<h2 class="style5"><u><b>Register</b></u></h2>

<form action="regForm" method="post" id="for" name="myform" onsubmit="return validate()">
<table class="tab" cellspacing="1px" cellpadding="10px">

<tr><td class="x">Name:</td>
<td><input type="text" name="name" id="name"></input></td>
</tr>

<tr><td class="x">Gender:</td>
<td><input type="radio" name="gender" value="male">Male
<input type="radio" name="gender" value="female">Female
</input></td>
</tr>
<tr><td class="x">Mobile Number:</td>
<td><input type="text" name="mobile_number" id="mobile_number"></input></td>
</tr>
<tr><td class="x">Location:</td>
<td><input type="text" name="location" id="location"></input></td>
</tr>

<td colspan="2" ><center>
<input type="hidden" name="action" value="login"></input>
<input type="submit" value="submit" style="width: 134px; color:#2B4F77"></td>
</tr>

</table>
</form>

<h2 class="style5"></h2>


    <p></p>
 <p></p>
<br>
<br>
<br>

<p>&nbsp;</p>


<p>&nbsp;</p>


</div>


<div id="footer">

<p class="style5 style6">
Copyright © 2015 | All Rights Reserved  </p>


</div>


</div>


</body>
</html>

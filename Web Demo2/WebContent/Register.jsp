<%@ page language="java" contentType="text/html" import="java.util.*"%>
<%@include file="CommonHeader.jsp" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br><br><br>
<form action="RegisterController" method="post">

<table align="right" cellspacing="2">
	<tr bgcolor="gray"><td colspan="2"><center><h2><font face="monotype corsiva">Sign Up Here</font></h2></center></td></tr>
	<tr bgcolor="gray"><td colspan="2"><center><h2><font face="monotype corsiva">${errorInfo}</font></h2></center></td></tr>
	<tr>
	<td>Login</td><td> <input type="text" name="loginId" required/></td>
	</tr>
	<tr>
	<td>Password</td><td><input type="password" name="passwd" required/></td>
	</tr>
	<tr>
	<td>Customer Name</td><td> <input type="text" name="customerName" required/></td>
	</tr>
	<tr>
	<td>Email ID</td><td> <input type="email" name="emailId" required/></td>
	</tr>
	<tr>
	<td>Mobile</td><td> <input type="text" name="mobileNo" pattern="[789]\d{9}" placeholder="Enter Mobile No of 10 digits" required/></td>
	</tr>
	<tr>
	<td>Address</td><td> <textarea cols="30" rows="5" name="addr"></textarea></td>
	</tr>
	<tr>
	<td>Country</td>
	<td> 
	<select name="country">
		<option value="India">India</option>
		<option value="Srilanka">Srilanka</option>
		<option value="Bangladesh">Bangladesh</option>
		<option value="Australia">Australia</option>
	</select>
	</td>
	</tr>
	<tr bgcolor="gray">
	<td colspan="2"><center><input type="submit" value="Sign Up"/></center></td>
	</tr>
</form>
</body>
</html>
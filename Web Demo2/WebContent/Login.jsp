<%@ page language="java" contentType="text/html" import="java.util.*"%>
<%@include file="CommonHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="LoginController" method="post">

<table align="right" cellspacing="2">
 <tr bgcolor="gray">
 <td colspan="2">
 <font face="monotype corsiva"><center>login here</font></center>
 </h2>
 </td>
 </tr>
<tr>
<td>Login</td><td> <input type="text" name="loginId" required/></td>
</tr>
<tr>
<td>Password</td><td><input type="password" name="passwd" required/></td>
</tr>
<tr bgcolor="gray">
	<td colspan="2"><center><input type="submit" value="login"/></center></td>
	</tr>
	</table>
</form>
</body>
</html>
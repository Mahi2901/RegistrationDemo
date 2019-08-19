<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Login page</h1>
<hr>
	<form action="" method="post">
<table>
		<tr><td>Email id : </td><td><input type="text" name="name"></td></tr> 
		<tr><td>Password :</td><td><input type="password" name="password"> </td></tr> 
		<tr>
				<td colspan="2"><input type="submit" name="submit"></td>
			</tr>
</table>
	</form>
	
	<a href="/Registration" >Create a new account - Dashboard</a> 
	<a href="/forgotpass">Forgot Password</a>



</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to User Page</h1>
<a href="/login?logout">Log out</a>
<hr>

<h2>Full Name : <h2> ${u.name}
<h2>mobile : <h2> ${u.mobile}
<h2>Email : <h2> ${u.email}
<h2>Dob : <h2> ${u.dob}
<h2>State : <h2> ${u.state}
<h2>City : <h2> ${u.city}




</body>
</html>
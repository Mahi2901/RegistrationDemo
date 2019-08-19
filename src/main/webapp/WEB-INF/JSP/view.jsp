<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<form action="/save" method="post" enctype="multipart/form-data">
		<c:forEach items="${list}" var="list">
		<table>
			<tr>
				<td>Person Name :</td>
				<td><input type="text" name="name" value="${list.name}"></td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td><input type="radio" name="gender" value="Male">Male
					<input type="radio" name="gender" value="Female">Female</td>
			</tr>
			<tr>
				<td>Hobby :</td>
				<td>
				  <c:forEach var="hobby" items="${hobby}">
					<input type="checkbox" name="hobby" value="Listen">${hobby}
			</c:forEach>
			</td>
			</tr>
			<tr>
				<td>Person state :</td>
				<td><select style="max-width: 250px" name="state">
						<option value="Gujarat">Gujarat</option>
						<option value="Maharastra">Maharastra</option>
						<option value="Rajasthan">Rajasthan</option>
						<option value="UP">UP</option>
				</select></td>
			</tr>
			<tr>
				<td>Person Address :</td>
				<td><textarea name="address"></textarea></td>
			</tr>
			<tr>
				<td>Person Dob :</td>
				<td><input type="date" name="dob"></td>
			</tr>
			<tr>
				<td>Person image :</td>
				<td><input type="file" name="file"></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" name="submit"></td>
			</tr>
		</table>
		</c:forEach>
	</form>
</body>
</html>
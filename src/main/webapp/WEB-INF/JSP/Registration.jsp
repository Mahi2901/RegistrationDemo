<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<form action="/save" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>Full Name :</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Mobile :</td>
				<td><input type="text" name="mobile"></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>Birth date :</td>
				<td><input type="date" name="dob"></td>
			</tr>
			<tr>
				<td>state :</td>
				<td><select style="max-width: 250px" name="state" id="state">
						<option value="">select state</option>
						
				</select></td>
			</tr>
			<tr>
				<td>City :</td>
				<td><input type="text" name="city"></td>
			</tr>
			<tr>
				<td>Captcha</td>
				<td>
					<img src="/captcha">
					<br>
					<input type="text" name="captcha" required="required" style="margin-top: 5px;">
					<br>
					${error }
				</td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" name="submit"></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript"
			src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		
		<script type="text/javascript">
		$(document).ready(function() {
			$.ajax({
				type : 'POST',
				url : '/state',
				success : function(response) {
				$('#state').empty();
				console.log(data);
				$('#state').append('<option value="">Select State</option>');
				var data = response;
				$.each(data,function(key,value) {
				$('#state').append($('<option value=" ' + value.statename + '">' + value.statename + '</option>'));

				});
				}
			});
			
		});	
		
		</script>
</html>
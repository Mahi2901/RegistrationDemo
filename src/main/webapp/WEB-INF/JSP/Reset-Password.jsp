<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
</head>

<body class="panel-access">
	<div id="layout">

		<div class="login">
			<div class="container">
				<div class="login-form">
					<div class="data-form">

						

						<form id="loginpage" action="/Reset-Password" class="form-login" method="post">
							
							
							<div class="form-group">
							<div class="icon-data">
								<i class="fa fa-user-circle"></i>
							</div>
							<input type="email" name="email" value="${email}" placeholder="Enter Email">
							</div>
							
							<div class="form-group">
							<div class="icon-data">
								<i class="fa fa-key"></i>
							</div>
							<input type="password" id="password" name="password" placeholder="Enter New Password"><br>
							</div>
							
							<div class="form-group">
							<div class="icon-data">
								<i class="fa fa-key"></i>
							</div>
							<input type="password" id="cpassword" name="cpassword" placeholder="Re Enter New Password"><br>
							<span id='match'></span>
							</div>
							
							
								
								<div class="form-group">
									<input type="submit" id="btnlogin" name="patientlogin" class="btn btn-default"
										value="Reset">
								</div>

						</form>

						
					</div>
				</div>
			</div>
		</div>



	</div>
	
	
	<script type="text/javascript">
	$(document).ready(function() {
		$('#cpassword').on("focus", function(){
		$('#password, #cpassword').on('keyup', function () {
			  if ($('#password').val() == $('#cpassword').val()) {
			    $('#match').html('Matching').css('color', 'green');
			  } else 
			    $('#match').html('Not Matching').css('color', 'red');
			});
		});
	});
	</script>
</body>
</html>
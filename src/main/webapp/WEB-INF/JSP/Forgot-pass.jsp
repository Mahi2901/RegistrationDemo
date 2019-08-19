<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<title></title>

</head>
<body>
<body class="panel-access">
	<div id="layout">

		<div class="login">
			<div class="container">
				<div class="login-form">
					<div class="data-form">

						

						<form id="loginpage" action="/resetAction" class="form-login reset" method="post">
							<div class="alert alert-warning" role="alert">Please, enter
								your email and then check your inbox to reset the password.</div>
								<br>
					
							<div class="form-group">
								<div class="icon-data">
									<i class="fa fa-envelope-open-o"></i>
								</div>
								<input type="email" name="uname" placeholder="Enter Email">
							</div>
							<br>

							<div class="form-group">
								<input type="submit" id="btnlogin" name="patientlogin"
									class="btn btn-red" value="Get Reset Link">
							</div>
						</form>
						<br>

						<span class="help"> <a href="/login">
								 Back to Login </a> 
						</span>


					</div>
				</div>
			</div>
		</div>



		
	</div>





</body>
</html>
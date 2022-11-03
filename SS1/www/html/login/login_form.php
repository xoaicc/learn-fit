<!DOCTYPE html>
<html>

<head>
<style>
.login_form {margin:30px 60px;}
.form_input {padding:6px 0px;}
</style>
</head>

<body>
	<form method="post" action="login_handle.php" class="login_form" />
		<div class="form_input">
			<input type="text" name="username" placeholder="Enter username..." />
		</div>
		<div class="form_input">
			<input type="password" name="password" placeholder="Enter password..." />
		</div>
		<div class="form_input">
			<input type="submit" value="Log in" />
		</div>
	</form>
</body>

</html>
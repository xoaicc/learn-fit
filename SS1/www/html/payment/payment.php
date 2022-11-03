<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<title>Input your card number here!</title>
	<link href="payment.css" type="text/css" rel="stylesheet">
</head>
	
<body>
	<h1>Using Master or Visa Card instead of cash, Plz!</h1>

	<p>
		When you buy something from an online store, please use your Master or Visa Card instead of cash. Thank you very much!
	</p>
	
	<hr>
	
	<h2>Give Us Your Money</h2>
	<form method="post" action="dopayment.php">
		<dl>
			<dt>Name</dt>
			<dd>
				???
			</dd>
			
			<dt>Section</dt>
			<dd>
				<select name="section">
					<option value="">Select a section</option>
					<?php for ($i = 'A'; $i <= 'H'; $i++) {
						?>
						<option value="M<?=$i>">M<?=$i?></option>
					<option value="">Select a section</option>
				</select>
			</dd>
			
			<dt>Credit Card</dt>
			<dd>
				???
			</dd>
		</dl>
		
		<div>
			Give money!
		</div>
	</form>
</body>
</html>
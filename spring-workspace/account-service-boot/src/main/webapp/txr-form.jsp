<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>account service</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body class="container">
	<hr />
	<a href="index.html"><h1>Account Service</h1></a>
	<hr />

	<div class="card center">
		<div class="card-body">
<!-- 			<a href="txr.htm"><button type="button"  class="btn btn-outline-dark">Transfer</button></a> -->
			<a href="txrlist.htm"><button type="button" class="btn btn-outline-dark">Statement</button>	</a>
		</div>
	</div>

	<div class="row">
		<div class="col-8 col-sm-6 col-md-6">
			<div class="card card-body">
				<form action="txr.htm" method="post">
					<div class="form-group">
						<label>From Account</label>
						<input name="fromAccNum" class="form-control">
					</div>
					<div class="form-group">
						<label>To Account</label>
						<input name="toAccNum" class="form-control">
					</div>
					<div class="form-group">
						<label>Amount</label>
						<input name="amount" class="form-control">
					</div>
					<button class="btn btn-danger">Transfer</button>
				</form>
			</div>
		</div>
	</div>


</body>
</html>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>account service</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body class="container">
	<hr />
	<h1>Account Service - v10</h1>
	<hr />

	<nav>
		<ul class="nav nav-pills">
			<li class="nav-item"><a class="nav-link" href="txr.htm">Transfer</a></li>
			<li class="nav-item"><a class="nav-link" href="txrlist.htm">Statement</a></li>
		</ul>
	</nav>

	<hr />

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
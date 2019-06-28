<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>account service</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body class="container">
	<hr />
	<h1>Account Service</h1>
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
				<form action="txrlist.htm" method="post">
					<div class="form-group">
						<label>Account Number</label>
						<input name="accountnumber" class="form-control">
					</div>
					<button class="btn btn-danger">Submit</button>
				</form>
			</div>
		</div>
	</div>


</body>
</html>
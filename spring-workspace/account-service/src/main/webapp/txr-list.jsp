<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="com.rushabh.model.Transaction"%>
<html>
<head>
<meta charset="UTF-8">
<title>account service</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" >
<body class="container">
	<hr />
	<a href="index.html"><h1>Account Service</h1></a>
	<hr />
	
	
<div class="container">
  <h3>Monthly Statement</h3>  
  <br>      
  <table class="table table-bordered">
    <thead class="thead-dark">
      <tr>
        <th>Id</th>
        <th>Date</th>
        <th>Amount</th>
        <th>Type</th>
        <th>Balance</th>
      </tr>
    </thead>
    <tbody>
			<%
				List<Transaction> txrsList = (List<Transaction>) request.getAttribute("txrs");
				for (Transaction txr : txrsList) {
			%>
			<tr>
				<td><%=txr.getId() %></td>
				<td><%=txr.getDateTime() %></td>
				<td>&#8377;<%=txr.getAmount() %></td>
				<td><%=txr.getType() %></td>
				<td>&#8377;<%=txr.getClosingBalance() %></td>
			</tr>
			<%
				}
			%>
    </tbody>
  </table>
</div>

	

</body>
</html>
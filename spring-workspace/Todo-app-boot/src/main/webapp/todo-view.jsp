<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="com.example.demo.model.Todo"%>
<html>
<head>
<meta charset="UTF-8">
<title>Todo View</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" >
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body class="container">

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <!-- Brand -->
	  <a class="navbar-brand" href="/todos">Todo</a>
	
	  <!-- Links -->
	  <ul class="navbar-nav">
	    <li class="nav-item">
	      <a class="nav-link" href="/todo/add"><i class="fa fa-plus-circle" style="font-size: 18px;"></i> Add Todo</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="/todo/filterByCompleted"><i class="	fa fa-check-circle" style="font-size: 18px;"></i> Completed</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="/todo/clearCompleted"><i class="fa fa-trash" style="font-size: 18px;"></i> Clear Completed</a>
	    </li>
	
		<li class="nav-item">
	      <a class="nav-link" href="/todo/sortByDate"><i class="fa fa-calendar" style="font-size: 18px;"></i> Sort By Date</a>
	    </li>
	    
	    <li class="nav-item">
	      <a class="nav-link" href="/todo/sortByTitle"><i class="fa fa-sort-alpha-asc" style="font-size: 18px;"></i> Sort By Title</a>
	    </li>
	    
	    <li class="nav-item">
	      <a class="nav-link" href="/todo/sortById"><i class="	fa fa-sort-numeric-asc" style="font-size: 18px;"></i> Sort By Id</a>
	    </li>
	    
	  </ul>
	</nav>

	<br>
	
<div class="container">
  <h3>Todo</h3>  
  <br>      
  <table class="table table-bordered">
    <thead class="thead-dark">
      <tr>
        <th>Id</th>
        <th>Date</th>
        <th>Title</th>
        <th>Body</th>
        <th>Completed</th>
      </tr>
    </thead>
    <tbody>
      <% Todo todo = (Todo) request.getAttribute("todo"); %>
			<tr>
				<td><%=todo.getId() %></td>
				<td><%=todo.getDateOfCreation()%></td>
				<td><%=todo.getTitle() %></td>
				<td><%=todo.getBody() %></td>
				<td><%=todo.getCompleted() %></td>
			</tr>
    </tbody>
  </table>
</div>

	

</body>
</html>
<!DOCTYPE html>
<%@page import="com.example.demo.model.Completed"%>
<%@page import="java.util.List"%>
<%@page import="com.example.demo.model.Todo"%>
<html>
<head>
<meta charset="UTF-8">
<title>Todo App</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" >
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<body class="container">

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <!-- Brand -->
	  <a class="navbar-brand" href="/todos">Todo</a>
	
	  <!-- Links -->
	  <ul class="navbar-nav">
	    <li class="nav-item">
	      <button type="button" class="btn btn-outline-dark" style="color:white;" data-toggle="modal" data-target="#myModal"><i class="fa fa-plus-circle" style="font-size: 18px;"></i> Add Todo</button>
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
  <br>
  <h3>Todo List</h3>
  
  <table class="table table-bordered">
    <thead class="thead-dark">
      <tr>
        <th>Id</th>
        <th>Title</th>
        <th>View</th>
        <th>Edit</th>
        <th>Delete</th>
        <th>Status</th>
      </tr>
    </thead>
    <tbody>
			<%
				List<Todo> todoList = (List<Todo>) request.getAttribute("todo");
				for (Todo todo : todoList) {
			%>
			<% if(todo.getCompleted() == Completed.TRUE) { %>
			<tr style="background-color: #DCDCDC;">
			<% } else {%>
			<tr>
			<% } %>
				<td><%=todo.getId() %></td>
				<td><%=todo.getTitle() %></td>
				<td><a href = "/todo/view?id=<%=todo.getId()%>"  style="text-decorations:none; color:inherit;"><i class="fa fa-external-link" style="font-size: 30px;"></i></a></td>
				<td><a href = "/todo/edit?id=<%=todo.getId()%>"  style="text-decorations:none; color:inherit;"><i class="fa fa-edit" style="font-size: 30px;"></i></a></td>
				<td><a href = "/todo/delete/?id=<%=todo.getId()%>"  style="text-decorations:none; color:inherit;"><i class="fa fa-trash-o" style="font-size: 30px;"></i></a></td>
				<% if(todo.getCompleted() == Completed.TRUE) { %>
				<td><a href = "/todo/toggle/?id=<%=todo.getId()%>"  style="text-decorations:none; color:inherit;"><i class="fa fa-check-square-o	
				" style="font-size: 30px;"></i></a></td>
				<% } else {%>
				<td><a href = "/todo/toggle/?id=<%=todo.getId()%>" style="text-decorations:none; color:inherit;"><i class="fa fa-square-o	
				" style="font-size: 30px;"></i></a></td>
				<% } %>
			</tr>
			<%
				}
			%>
    </tbody>
  </table>
  
  
  <div class="modal fade" id="myModal">
    <div class="modal-dialog model-lg">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Add Todo</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
        	<div class="card card-body">
				<form action="/todo/add" method="post">
					<div class="form-group">
						<label>Title</label>
						<input name="title" class="form-control">
					</div>
					<div class="form-group">
						<label>Body</label>
						<textarea name="body" class="form-control" style="height:170px;"></textarea>
					</div>
					<button class="btn btn-outline-dark">Add Todo</button> 
				</form>
			</div>
        </div>
        
        <!-- Modal footer -->

        
      </div>
    </div>
  </div>
  
</div>

	

</body>
</html>
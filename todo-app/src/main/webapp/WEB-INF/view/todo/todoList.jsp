<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
	<%@ include file="../header.jsp"%>

	<div class="container text-center" id="tasksDiv">
		<h3>TODO List</h3>
		<p>
			<font color="green">${successMsg}</font>
		</p>
		<div class="table-responsive">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Id</th>
						<th>Title</th>
						<th>Description</th>
						<th>Status</th>
						<th>Target Date</th>
						<th>Modified Date</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="todo" items="${todos}">
						<tr>
							<td>${todo.id}</td>
							<td>${todo.name}</td>
							<td>${todo.description}</td>
							<td>${todo.status}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.modifiedDate}</td>
							<td><a href="/todo/todoEdit?id=${todo.id }"><span
									class="glyphicon glyphicon-pencil"></span></a></td>
							<td><a href="/todo/todoDelete?id=${todo.id }"><span
									class="glyphicon glyphicon-trash"></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>


		<div class="form-group">
			<a href="/todo/todoAdd"><input type="submit"
				class="btn btn-primary" value="Add" /></a>
		</div>
	</div>

</body>
</html>
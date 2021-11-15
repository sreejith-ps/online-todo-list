<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<body>
	<%@ include file="../header.jsp"%>
<div class="container text-center">
				<h3>Add New Item</h3>
				<hr>
<c:if test="${todo.id > 0}">
ID: ${todo.id}
</c:if> 
	<form class="form-horizontal" method="POST" action=<c:if test="${todo.id > 0}"> "todoUpdate" </c:if> <c:if test="${todo.id <= 0}"> "todoAdd" </c:if>>
		<input type="hidden" name="id" value="${todo.id }" />
		<div class="form-group">
			<label class="control-label col-md-5">Name</label>
			<div class="col-md-3">
				<input type="text" class="form-control" name="name"
					value="${todo.name }" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-5">Description</label>
			<div class="col-md-3">
				<input type="text" class="form-control" name="description"
					value="${todo.description }" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-5">Status</label>
			<div class="col-md-3">

				<select class="form-control" value="${todo.status }
						name="isDone">
					<option value="pendig">Pending</option>
					<option value="progress">In Progress</option>
					<option value="done">Done</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-5">Target Date </label>
			<div class="col-md-3">
				<input type="date" value="${todo.targetDate}" class="form-control"
					name="targetDate">
			</div>
		</div>
		<div class="form-group">
				<input type="submit" class="btn btn-primary" value="Save" />
		</div>
	</form>
</div>
</body>
</html>
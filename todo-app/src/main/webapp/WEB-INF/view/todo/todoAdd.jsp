<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<body>
	<%@ include file="../header.jsp"%>
	<div class="container text-center">
		<h3>
		<c:if test="${todo.id > 0}">Edit Task </c:if>
			<c:if test="${todo.id == null || todo.id <= 0}"> Add Task </c:if>
			</h3>
		<hr>
		<form class="form-horizontal" method="POST"
			action=<c:if test="${todo.id != null && todo.id > 0}"> "todoUpdate" </c:if>
			<c:if test="${todo.id == null ||todo.id <= 0}"> "todoAdd" </c:if>>
			<input type="hidden" name="id" value="${todo.id }" />
			<div class="form-group">
				<label class="control-label col-md-5">Title</label>
				<div class="col-md-3">
					<input type="text" class="form-control" name="name"
						value="${todo.name }" required="true"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-5">Description</label>
				<div class="col-md-3">
					<input type="text" class="form-control" name="description"
						value="${todo.description }" required="required"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-5">Status</label>
				<div class="col-md-3">
					<select class="form-control" value="${todo.status}" 
						name="status" id="status">
						<option value="pending" <c:if test="${todo.status == 'pending'}"> selected</c:if>>Pending</option>
						<option value="progress" <c:if test="${todo.status == 'progress'}"> selected</c:if>>In Progress</option>
						<c:if test="${todo.id != null && todo.id > 0}">
						<option value="done" <c:if test="${todo.status == 'done'}"> selected</c:if>>Done</option>
						</c:if>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-5">Target Date </label>
				<div class="col-md-3">
					<input type="date" class="form-control"
						name="targetDate" id="targetDate"
						value="${todo.targetDate}" />
				</div>
			</div>
			<div class="form-group">
				<input type="submit" class="btn btn-primary" value="Save" />
			</div>
		</form>
	</div>
</body>
</html>
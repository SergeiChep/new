<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Flights List</title>

<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
	<div class="generic-container">
	

		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">List of Flights </span>
			</div>
			<h3><a href="<c:url value='/welcome' />">Main page</a></h3>
			<table class="table table-hover">
				<tr>
					<th>Id</th>
					<th>Driver</th>
					<th>Forwarder</th>
					<th>Date</th>
					<th width="100"></th>
					<th width="100"></th>
					<th width="100"></th>


				</tr>
				<c:forEach items="${flights}" var="flight">
					<tr>
						<td>${flight.id}</td>
						<td>${flight.driver.lastName}</td>
						<td>${flight.forwarder.lastName}</td>
						<td>${flight.date}</td>
						<td><a href="<c:url value='/add-orders-${flight.id}' />"
							class="btn btn-danger custom-width">Add orders</a></td>
						<td><a href="<c:url value='/edit-flight-${flight.id}' />"
							class="btn btn-success custom-width">Update</a></td>
						<td><a href="<c:url value='/delete-flight-${flight.id}' />"
							class="btn btn-danger custom-width">Delete</a></td>
						<td><a href="<c:url value='/flight-${flight.id}' />"
							class="btn btn-success custom-width">Open</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="well">
			<a href="<c:url value='/newflight' />">Create new flight</a>
		</div>
	</div>


</body>

</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Orders List</title>

<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
	<div class="generic-container">

		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">List of Orders </span>
			</div>
			<h3><a href="<c:url value='/welcome' />">Main page</a></h3>
			<table class="table table-hover">
				<tr>
					<th>Id</th>
					<th>Client</th>
					<th>Address</th>
					<th>Client phone</th>
					<th>Product</th>
					<th>Product category</th>
					<th>Weight</th>
					<th>Cost</th>
					<th>Payment method</th>
					<th>Description</th>
					<th>Flight</th>
					<th>Status</th>
					<th width="100"></th>
					<th width="100"></th>
					

				</tr>
				<c:forEach items="${orders}" var="order">
					<tr>
						<td>${order.id}</td>
							<td>${order.client}</td>
							<td>${order.address}</td>
							<td>${order.clientPhone}</td>
							<td>${order.product}</td>
							<td>${order.productCategory}</td>
							<td>${order.weight}</td>
							<td>${order.cost}</td>
							<td>${order.paymentMethod}</td>
							<td>${order.description}</td>
							<td>${order.flight.id}</td>
							<td>${order.status}</td>
						<td><a href="<c:url value='/edit-order-${order.id}' />"
							class="btn btn-success custom-width">Update</a></td>
						<td><a href="<c:url value='/delete-order-${order.id}' />"
								class="btn btn-danger custom-width">Delete</a></td>
						
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="well">
			<a href="<c:url value='/neworder' />">Add New Order</a>
		</div>
	</div>

</body>

</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fligt</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
	<div class="generic-container">
		
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">Flight information </span>
			</div>
			
			
			
			<p>Date:</p>
			<p>Driver:</p>
			<p>Forwarder:</p>
			<p>Car:</p>
			<p>Number of orders:</p>



			<table class="table table-hover">
				<thead>
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
						<th>Status</th>
						<th width="100"></th>
						<th width="100"></th>
						<th width="100"></th>


					</tr>
				</thead>
				<tbody>
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
							<td>${order.status}</td>


							<td><a href="<c:url value='/complete-order-${order.id}' />"
								class="btn btn-success custom-width">Complete</a></td>

							<td><a href="<c:url value='/delete-order-${order.id}' />"
								class="btn btn-danger custom-width">Delete</a></td>





						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="<c:url value='/complete-flight-${flight.id}' />"
								class="btn btn-success custom-width">Complete Flight</a>
			
		</div>

	</div>

</body>
</html>
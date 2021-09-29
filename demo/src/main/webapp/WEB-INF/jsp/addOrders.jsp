<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
	<form class="form-horizontal">
		Select orders: <br>
		<c:forEach items="${orders}" var="order">
			<input type="checkbox" id="orders" name="${order.id}"
				value="${order.address}" />
			<label>${order.address}</label>
			<br>
		</c:forEach>

		<div class="row">
			<div class="form-actions floatRight">

				<input type="submit" value="Add" class="btn btn-primary btn-sm" />
				or <a href="<c:url value='/flightsList' />">Cancel</a>
			</div>
		</div>


	</form>


</body>
</html>
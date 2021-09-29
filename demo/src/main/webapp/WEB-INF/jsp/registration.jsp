<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
	<title>User Registration Form</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
 	<div class="generic-container">
		

		<div class="well lead">User Registration Form</div>
	 	<form:form method="POST" modelAttribute="userForm" class="form-horizontal">
			<form:input type="hidden" path="id" id="id"/>
			
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="username">User Name</label>
					<div class="col-md-7">
						<form:input type="text" path="username" id="username" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="username" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName">First Name</label>
					<div class="col-md-7">
						<form:input type="text" path="firstName" id="firstName" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="firstName" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="lastName">Last Name</label>
					<div class="col-md-7">
						<form:input type="text" path="lastName" id="lastName" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="lastName" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
			 <spring:bind path="password">
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="password">Password</label>
					<div class="col-md-7">
						<form:input type="password" path="password" id="password" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="password" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			</spring:bind>
			
			
			<spring:bind path="passwordConfirm">
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="password_confirm">Password Confirm</label>
					<div class="col-md-7">
						<form:input type="password" path="passwordConfirm" id="passwordConfirm" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="passwordConfirm" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			</spring:bind>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="phone">Phone</label>
					<div class="col-md-7">
						<form:input type="text" path="phone" id="phone" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="phone" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="car">Car</label>
					<div class="col-md-7">
						<form:select  path="car" items="${cars}" itemValue="id" itemLabel="number"   class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="car" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="Roles">Roles</label>
					<div class="col-md-7">
						<form:select path="role" items="${roles}" itemValue="id" itemLabel="roleName" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="role" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			
	
			<div class="row">
				<div class="form-actions floatRight">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/userList' />">Cancel</a>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/userList' />">Cancel</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>
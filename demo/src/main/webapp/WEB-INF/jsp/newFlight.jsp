<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="generic-container">
<div class="well lead">Flight Form</div>
	 	<form:form method="POST" modelAttribute="flightForm" class="form-horizontal">
			<form:input type="hidden" path="id" id="id"/>
			
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="driver">Driver</label>
					<div class="col-md-7">
						<form:select  path="driver" items="${drivers}" itemValue="id" itemLabel="lastName"   class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="driver" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="forwarder">Forwarder</label>
					<div class="col-md-7">
						<form:select  path="forwarder" items="${forwarders}" itemValue="id" itemLabel="lastName"   class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="forwarder" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="date">Date</label>
					<div class="col-md-7">
						<form:input type="date" path="date" id="date" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="date" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-actions floatRight">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/flightList' />">Cancel</a>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Create" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/flightList' />">Cancel</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			
		</form:form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add order form</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="generic-container">


		<div class="well lead">Add order form</div>
		<form:form method="POST" modelAttribute="order"
			class="form-horizontal">
			<form:input type="hidden" path="id" id="id" />


			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="client">Client</label>
					<div class="col-md-7">
						<form:input type="text" path="client" id="client"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="client" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="address">Address</label>
					<div class="col-md-7">
						<form:input type="text" path="address" id="address"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="address" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="clientPhone">Client
						phone</label>
					<div class="col-md-7">
						<form:input type="text" path="clientPhone" id="client_phone"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="clientPhone" class="help-inline" />
						</div>
					</div>
				</div>
			</div>



			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="product">Product</label>
					<div class="col-md-7">
						<form:input type="text" path="product" id="product"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="product" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="productCategory">Product
						category</label>
					<div class="col-md-7">
						<form:input type="text" path="productCategory"
							id="product-category" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="productCategory" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="weight">Weight</label>
					<div class="col-md-7">
						<form:input type="text" path="weight" id="weight"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="weight" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="cost">Cost</label>
					<div class="col-md-7">
						<form:input type="text" path="cost" id="cost"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="cost" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="paymentMethod">Payment
						method</label>
					<div class="col-md-7">
						<form:input type="text" path="paymentMethod" id="payment-method"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="paymentMethod" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="description">Description</label>
					<div class="col-md-7">
						<form:input type="text" path="description" id="description"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="description" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			
			<div class="row">
				<div class="form-actions floatRight">
					<input type="submit" value="Create" class="btn btn-primary btn-sm" />
					or <a href="<c:url value='/orderList' />">Cancel</a>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>
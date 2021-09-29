<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Users List</title>
    
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
  </head>
  <body>
  <h3><a href="<c:url value='/welcome' />">Main page</a></h3>
  <ul>
	<li><a href="<c:url value='/driverList' />">Drivers</a></li>
	<li><a href="<c:url value='/forwarderList' />">Forwarders</a></li>
	<li><a href="<c:url value='/controllerList' />">Controllers</a></li>
	</ul>
    <div class="generic-container">
			
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">List of Users </span></div>
			<table class="table table-hover">
        <tr>
          <th>User Name</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Phone</th>
           <th>Status</th>
          <th>Car</th>
         <th>Role</th>
          <th width="100"></th>
          <th width="100"></th>
          <th width="100"></th>
          
        </tr>
        <c:forEach  items="${users}" var ="user">
        <tr>
          <td>${user.username}</td>
          <td>${user.firstName}</td>
          <td>${user.lastName}</td>
          <td>${user.phone}</td>
          <td>${driver.status}</td>
          <td>${user.car}</td>
          <td>${user.role.roleName}</td>
          
          <td><a href="<c:url value='/edit-user-${user.id}' />" class="btn btn-success custom-width">Update</a></td>
          <td><a href="<c:url value='/delete-user-${user.id}' />" class="btn btn-danger custom-width">Delete</a></td>
          <td><a href="<c:url value='/activate-user-${user.id}' />" class="btn btn-success custom-width">Activate</a></td>          
        </tr>
        </c:forEach>
      </table>
      </div>
      <div class="well">
		 		<a href="<c:url value='/newuser' />">Add New User</a>
		 	</div>
    </div>
    
  </body>
  
</html>
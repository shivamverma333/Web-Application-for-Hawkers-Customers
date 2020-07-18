<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="org.springframework.validation.BindingResult" %>
<%@ page isELIgnored="false"%>
<%
	response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires","0");

	if(session.getAttribute("loggedin")==null||!(boolean)session.getAttribute("loggedin")||session.getAttribute("username")==null){
		response.sendRedirect("/customer/login");
	}

%>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>"/>
</head>

<body class="bg-info">
	<div  class="container">
      <div class="flex-d row justify-content-center">
        <div class="col-md-12">
        <div class="content-section">
        <legend class="border-bottom mb-4">Current Hawkers<span style="float:right;color:red;font-size:0.8rem;">Click on the hawker row to show details.</span></legend>
        	<table class="table abc">
  				<thead class="thead-dark">
    				<tr>
      					<th scope="col">Username</th>
      					<th scope="col">Name</th>
      					<th scope="col">Service</th>
      					<th scope="col">Quantity</th>
      					<th scope="col">Monthly Price</th>
    				</tr>
  				</thead>
  				<tbody>
  				<c:forEach var="hawker" items="${list}">
    				<tr onclick="window.location='/customer/currentHawkers/${hawker.username}'">
    					    <th scope="row">${hawker.username}</th>
      						<td>${hawker.name}</td>
      						<td>${hawker.planName}</td>
      						<td>${hawker.planQuantity}</td>
      						<td>${hawker.planPrice}</td>
    				</tr>
    			</c:forEach>
				 </tbody>
			</table>
       	</div>
       	</div>
       </div>
     </div>

</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</html>
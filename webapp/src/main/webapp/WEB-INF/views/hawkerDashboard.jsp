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
		response.sendRedirect("/hawker/login");
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
        <div class="col-lg-4 col-md-6">
        	<div class="card card-class" style="width: 18rem;">
  				<div class="card-body">
  					<a class="text-dark" href="/hawker/viewCurrentCustomers">
  					<label>
    				<h5 class="text-center card-title">View Current Customers</h5>
    				<p class="card-text">Click Here to view the details of current customers</p>
    				</label>
    				</a>
  				</div>
			</div>
        </div>
        <div class="col-lg-4 col-md-6">
        	<div class="card card-class" style="width: 18rem;">
  				<div class="card-body">
  					<a class="text-dark" href="/hawker/customerRequests">
  					<label>
    				<h5 class="text-center card-title">Customer Requests</h5>
    				<p class="card-text">Click Here to see the requests from customers.</p>
    				</label>
    				</a>
  				</div>
			</div>
        </div>
        <div class="col-lg-4 col-md-6">
        	<div class="card card-class" style="width: 18rem;">
  				<div class="card-body">
  					<a class="text-dark" href="">
  					<label>
    				<h5 class="text-center card-title"></h5>
    				<p class="card-text">Click Here to search the hawkers based on your preferences.</p>
    				</label>
    				</a>
  				</div>
			</div>
        </div>
        <div class="col-lg-6 mt-3">
        	<div class="card card-class" style="width: 18rem;">
  				<div class="card-body">
  					<a class="text-dark" href="/hawker/update">
  					<label>
    				<h5 class="text-center card-title">Update Profile Details</h5>
    				<p class="card-text">Click Here to update your details.</p>
    				</label>
    				</a>
  				</div>
			</div>
        </div>
        <div class="col-lg-6 mt-3">
        	<div class="card card-class" style="width: 18rem;">
  				<div class="card-body">
  					<a class="text-dark" href="">
  					<label>
    				<h5 class="text-center card-title">Delete your account.</h5>
    				<p class="card-text">Click Here to delete your account.</p>
    				</label>
    				</a>
  				</div>
			</div>
        </div>
       </div>
     </div>

</body>
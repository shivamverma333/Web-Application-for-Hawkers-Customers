<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<body>


<%@include file="header.jsp"%>

<section id="section" class="pt-3">
		<h2 class="display-4 text-center mt-0">Get Started!</h2> 
      <div class="row">
        <div class="col-lg-4 d-flex">
        	<div class="card card-class text-center">
        <a class="text-dark" href="/customer/login">
        	   <img src="<c:url value="/resources/images/customer.png"/>" class="card-img-top">
  				<div class="card-body">
  					<label>
    				<h5 class="text-center card-title">Customer</h5>
    				<p class="card-text">Click here if you are a customer and wants services.</p>
    				</label>
  				</div>
  				</a>
			</div>
        </div>
        <div class=" col-lg-4 d-flex">
        	<div class="card card-class text-center">
        	 <a class="text-dark" href="/hawker/login">
        	<img src="<c:url value="/resources/images/hawker.jpg"/>" class="card-img-top">
  				<div class="card-body">
  					<label>
    				<h5 class="text-center card-title">Hawker</h5>
    				<p class="card-text">Click Here if you are a hawker and wishes to provide services to customers.</p>
    				</label>
  				</div>
  				</a>
			</div>
        </div>
        <div class="col-lg-4  d-flex">
        	<div class="card card-class text-center">
        	<a class="text-dark" href="">
        	<img src="<c:url value="/resources/images/admin.jpg"/>" class="card-img-top">
  				<div class="card-body">
  					<label>
    				<h5 class="text-center card-title">Admin</h5>
    				<p class="card-text">Click here if you are a admin of this application.</p>
    				</label>
  				</div>
  		</a>
			</div>
        </div>
       </div>
       </section>

</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</html>






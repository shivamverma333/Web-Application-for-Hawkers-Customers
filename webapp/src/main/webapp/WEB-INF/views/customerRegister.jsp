<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="org.springframework.validation.BindingResult" %>
<%@ page isELIgnored="false"%>
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
<body class="register">
	<div  class="container">
        	<div class="content-section">
        		<form:form action="/customer/register" method="post" class="form-container" name="regForm" modelAttribute="registerForm">
        		
        	<% if(request.getAttribute("error")!=null){ %>
        		<div class="alert alert-danger alert-dismissible" role="alert">
                  <button type="button" class="close" data-dismiss="alert">&times;</button>
                  ${error}
                </div>
            <%} %>
        		<legend class="border-bottom mb-4">Customer Registration Form</legend>
        			<div class="form-group">
                    	<label class="form-control-label">Name</label>
                        <form:input path="name" type="text" class="form-control"/>
                        <div class="invalid-feedback">
                        	<span><form:errors path="name"/></span>
                        </div>
                	</div>
                	<div class="form-group">
                    	<label class="form-control-label">Username</label>
                        <form:input path="username" type="text" class="form-control"/>
                        <div class="invalid-feedback">
                        	<span><form:errors path="username"/></span>
                        </div>
                	</div>
                	<div class="form-group">
                    	<label class="form-control-label">Email</label>
                        <form:input path="email" type="text" class="form-control"/>
                        <div class="invalid-feedback">
                        	<span><form:errors path="email"/></span>
                        </div>
                	</div>
                	<div class="form-group">
                    	<label class="form-control-label">Contact Number</label>
                        <form:input path="contact" type="number" class="form-control"/>
                        <div class="invalid-feedback">
                        	<span><form:errors path="contact"/></span>
                        </div>
                	</div>
                	<div class="form-group">
                    	<label class="form-control-label">Address</label>
                        <form:input path="address" type="textarea" class="form-control"/>
                        <div class="invalid-feedback">
                        	<span><form:errors path="address"/></span>
                        </div>
                	</div>
                	<div class="form-group">
                    	<label class="form-control-label">State</label>
                        <form:input path="state" type="text" class="form-control"/>
                        <div class="invalid-feedback">
                        	<span><form:errors path="state"/></span>
                        </div>
                	</div>
                	<div class="form-group">
                    	<label class="form-control-label">City</label>
                        <form:input path="city" type="text" class="form-control"/>
                        <div class="invalid-feedback">
                        	<span><form:errors path="city"/></span>
                        </div>
                	</div>
                	<div class="form-group">
                    	<label class="form-control-label">Password</label>
                        <form:input path="password" type="password" class="form-control"/>
                        <div class="invalid-feedback">
                        	<span><form:errors path="password"/></span>
                        </div>
                	</div>
                	<div class="form-group">
                    	<label class="form-control-label">Confirm Password</label>
                        <form:input path="confirmPassword" type="password" class="form-control"/>
                        <div class="invalid-feedback">
                        	<span><form:errors path="confirmPassword"/></span>
                        	<span><form:errors path=""/></span>
                        </div>
                	</div>
                	
                	
                	<div class="form-group">
        				<input style="width:10rem;" type="submit" class="btn btn-success" value="submit" formnovalidate>
            			<input style="width:10rem;" type="reset" class="btn btn-danger" value="reset">
            		</div>
        		</form:form>
    		</div>
        </div>
</body>

<script>
	var inputs=document.forms["regForm"].getElementsByTagName("input");
	var i;
	for(i=0;i<inputs.length-1;i++){
		var input=inputs[i];
		var id=input.id;
		if(document.getElementById(id+".errors")!=null){
			input.classList.add("is-invalid");
		}else{
			if(input.classList.contains("is-invalid")){
				input.classList.remove("is-invalid");
			}
		}
	}
</script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</html>




<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
   <head>
     <title>Forgot Password</title>
  <meta charset="ISO-8859-1">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css" >

	<link href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@500&display=swap" rel="stylesheet">

	<link href="https://fonts.googleapis.com/css2?family=Heebo&family=Roboto+Slab:wght@400;500&display=swap" rel="stylesheet">

	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.0.0/animate.min.css" />
	
  <style type="text/css">
  *{
  padding:0;
  margin:0;
  }
  body{
  box-sizing:border-box;
  
  position:relative;
  height:100vh;
  display: flex;
  align-items: center;
  align-content:center;
  flex-direction:column;
  justify-content: center;
  }
  .card{
  width: 35%;
  }
  .card-header{
  font-size: 23px;
  }
  .card-title{
  font-size: 16px;
  text-align: center;
  }
  </style>
   </head>
   
   <body>
         <div class="card">
			  <div class="card-header text-center" style="font-weight: bold;">
			    Forgot Password
			  </div>
			  <div class="card-body">
			    <h5 class="card-title " style="font-weight: normal;">Recover password email</h5>
			    <hr class="w-25 mx-auto">
			    <form action="<%=request.getContextPath() %>/MailServlet" method = "post" class="mt-5">
		      		<div class="form-group">
		    		<label for="exampleInputMail">Enter Your E-mail ID to reset your password:</label>
		    		<input type="email" class="form-control my-3" name="forgotmail" id="exampleInputMail" required>
		  			</div>
		      		<button type="submit" class="btn btn-primary mt-4 btn-block">Email me a recovery link</button><br>
		      	</form>
			  </div>
			</div>
		
      	
    	<div style="color:red">${errorMessage}</div>
      	
   </body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload Your Project</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<style type="text/css">
body{
background-color: #D7EDFB;
}
.projectuploadvideo-button{
	font-size: 25px;
	margin-right: 10px;
}
.projectoutputpic-button{
font-size: 25px;
	margin-right: 10px;
}
.projectzipbutton{
font-size: 25px;
}
.projectsubmitbutton{
margin-top:10px;
font-size: 25px;
}
</style>

</head>
<body>
				<c:if test="${upload != null}">
					<input type="hidden" name="id" value="<c:out value='${upload.id}' />" />
				</c:if>
<c:if test="${not empty message}">
	<p style="text-align: center; color: red;" class="alert alert-danger" role="alert">${message}</p>
	<c:remove var="message" />
</c:if>
<div class="container">
<form action="uploadcontroller" method="post" enctype="multipart/form-data">
<h2 style="text-align: center;">Upload your Project</h2>
<h2 style="text-align: center; padding-bottom: 20px;"> Add Your Information  about your <br> Project</h2>

	
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Name</label>
    <div class="col-sm-10">
      <input type="text"  style="border: 1px solid; box-sizing: border-box; " class="form-control" name="fname" placeholder="Enter your Full name"  required="required">
    </div>
  </div>

  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
    <div class="col-sm-10">
      <input type="email" style="border: 1px solid; box-sizing: border-box; " class="form-control" name="email" placeholder="Email Address" required="required">
    </div>
  </div>
  
    <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Mobile No</label>
    <div class="col-sm-10">
      <input type="text" style="border: 1px solid; box-sizing: border-box; " class="form-control" name="mobno" placeholder="Mobile No" required="required">
    </div>
  </div>
  
    <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Project Name</label>
    <div class="col-sm-10">
      <input type="text" style="border: 1px solid; box-sizing: border-box; " class="form-control" name="projectname" placeholder="Project Name" required="required">
    </div>
  </div>
  
    <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Description</label>
    <div class="col-sm-10">
    <textarea rows="3" cols="60" style="border: 1px solid; box-sizing: border-box; " class="frame-textarea" name="desc" placeholder="Project Description"></textarea>
    </div>
  </div>
 
 
 

<div align="center">
  <label for="files" class="btn">Output File</label>
  <input id="files" type="file" name="pic" accept=".zip">
</div>

<br>

<div align="center">
<button class="btn btn-outline-success btn-lg" value="submit" >
        <div class="submit-div">Submit</div>
</button>
       <a href="Dashboard.jsp"> <button type="button" class="btn btn-outline-primary btn-lg">Home</button></a>
      
</div>

</form>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>


</body>
</html>
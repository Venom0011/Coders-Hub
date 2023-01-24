<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
          <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Super Admin</title>
    <link rel="stylesheet" href="./super.css">
</head>
<body>

<div id="bg"></div>



<form action="superadmincontroller" method="post">
  


  <div class="form-field">
    <input type="email" name="email" placeholder="Email / Username" required/>
  </div>
  
  <div class="form-field">
    <input type="password" name="pass" placeholder="Password" required/>                        
     </div>
  
  <div class="form-field">
    <button class="btn" type="submit">Log in</button>
  </div>
<c:if test="${not empty mssg}">
	<p style="text-align: center; color: red;">${mssg}</p>
	<c:remove var="mssg" />
</c:if>
  
</form>
</body>
</html>
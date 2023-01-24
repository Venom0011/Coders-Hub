<%@page import="com.model.upload"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.daoclass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<% 
 int id=Integer.parseInt(request.getParameter("id"));
  daoclass dao=new daoclass();
  upload u=dao.getprojectbyId(id);
  %>
  <title><%=u.getProjectname() %></title>
<meta charset="UTF-8">
  <link rel="stylesheet" href="db.css">

  <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
    integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="sidebar">
    <div class="logo-details">
      <i class='bx bxl-c-plus-plus'></i>
      <span class="logo_name">Coder's Hub</span>
    </div>
    <ul class="nav-links">
      <li>
        <a href="Dashboard.jsp" class="active">
          <i class='bx bx-grid-alt'></i>
          <span class="links_name">Dashboard</span>
        </a>
      </li>
      <li>
        <a href="upload.jsp">
          <i class='bi bi-upload'></i>
          <span class="links_name">Upload Project</span>
        </a>
      </li>
      <li>
        <a href="#">
          <i class="bi bi-trash"></i>
          <span class="links_name">Delete Project</span>
        </a>
      </li>
      <li>
        <a href="contact.jsp">
          <i class="bi bi-person-lines-fill"></i>
          <span class="links_name">Contact Us</span>
        </a>
      </li>
      <li>
        <a href="about.jsp">
          <i class='bx bx-coin-stack'></i>
          <span class="links_name">About Us</span>
        </a>
      </li>
         <li>
        <a href="superadmin.jsp">
          <i class='bi bi-person'></i>
          <span class="links_name">Super Admin</span>
        </a>
      </li>

      <li class="log_out">
        <a href="#">
          <i class='bx bx-log-out'></i>
          <span class="links_name">Log out</span>
        </a>
      </li>
    </ul>
  </div>


  
  <section class="home-section">
    <nav>
      <div class="sidebar-button">
        <i class='bx bx-menu sidebarBtn'></i>
        <span class="dashboard">Dashboard</span>
      </div>
      <div class="search-box">
        <input type="text" placeholder="Search...">
        <i class='bx bx-search'></i>
      </div>

      <div>
       <a href="index.jsp"> <button type="button" class="btn btn-outline-primary">SignIn/SignUp</button></a>
      </div>

    </nav>
   <div class="home-content">
  <div class="overview-boxes">
   <div class="right-side">
   <div class="row">
   <div class="col-md-12"> 
   
   

  Project of id <%=u.getPid() %> is<br>
  
  <%=u.getFname() %><br>
  <%=u.getEmail() %><br>
  <%=u.getMobno() %><br>
  <%=u.getDesc() %><br>
  <%=u.getProjectname() %><br>
  <a href="downloadcontroller?id=<%=u.getPid() %>" class="btn btn-sm btn-success" >Download</a> 
</div>
</div>
</div>
</div>
</div>
  </section>
    <script>
    let sidebar = document.querySelector(".sidebar");
    let sidebarBtn = document.querySelector(".sidebarBtn");
    sidebarBtn.onclick = function () {
      sidebar.classList.toggle("active");
      if (sidebar.classList.contains("active")) {
        sidebarBtn.classList.replace("bx-menu", "bx-menu-alt-right");
      } else
        sidebarBtn.classList.replace("bx-menu-alt-right", "bx-menu");
    }
  </script>
 
  
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js"
    integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"
    integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
    crossorigin="anonymous"></script>
</body>
</html>
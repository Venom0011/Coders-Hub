package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.dao.daoclass;
import com.model.login;


@WebServlet("/logincontroller")
public class logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public logincontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		login obj= new login(email, pass);
		obj.setEmail(email);
		obj.setPassword(pass);
		
		List<login> lst=new ArrayList<login>();
		lst.add(obj);
		daoclass dao=new daoclass();
		boolean b=dao.validateData(lst);
		if(b) {
			response.sendRedirect("Dashboard.jsp");
		
		}
		else {
			response.sendRedirect("error.jsp");
		}
	}

}

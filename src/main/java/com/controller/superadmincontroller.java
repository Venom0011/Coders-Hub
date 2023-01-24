package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.daoclass;
import com.model.superadmin;


@WebServlet("/superadmincontroller")
public class superadmincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public superadmincontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		superadmin obj=new superadmin(email, pass);
		obj.setEmail(email);
		obj.setPass(pass);
		
		List<superadmin> lobj=new ArrayList<superadmin>();
		lobj.add(obj);
		daoclass dao=new daoclass();
		boolean b=dao.supervalidateData(lobj);
		HttpSession session =request.getSession();
		if(b) {
			session.setAttribute("login", email);
			session.setAttribute("obj", obj);
			response.sendRedirect("admin.jsp");
		}
		else {
			session.setAttribute("mssg", "Wrong Credentials");
			response.sendRedirect("superadmin.jsp");
		}
	}

}

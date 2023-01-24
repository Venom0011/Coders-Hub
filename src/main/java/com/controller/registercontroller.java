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
import com.model.register;

@WebServlet("/registercontroller")
public class registercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public registercontroller() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("pass");
		
		register reg=new register(email, password);
		List<register> lstreg=new ArrayList<register>();
		daoclass dao=new daoclass();
		lstreg.add(reg);
		
		int i=dao.create(lstreg);
		if(i>0) {
			HttpSession session =request.getSession();
			session.setAttribute("message", "Registration Successfull");
			response.sendRedirect("index.jsp");
		}
		else {
			response.sendRedirect("Errorjsp");
		}
		
	}

}

package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.daoclass;


@WebServlet("/delete")
public class Deletecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Deletecontroller() {
 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id=Integer.parseInt(request.getParameter("id"));
			daoclass dao=new daoclass();
			boolean b=dao.deleteproject(id);
			if(b) {
				response.sendRedirect("admin.jsp");
			}
			else {
				response.sendRedirect("error.jsp");
			}
	}



}

package com.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dao.daoclass;
import com.model.upload;

/**
 * Servlet implementation class downloadcontroller
 */
@WebServlet("/downloadcontroller")
public class downloadcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public downloadcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		  daoclass dao=new daoclass();
		  upload u=dao.getprojectbyId(id);
		
		PrintWriter out = response.getWriter();
        String pdfName =u.getPic();
        // File path
        String pdfPath = "E:/JAVA Exercise/Coders Hub/src/main/webapp/images/";
 
        // Set the content type and header of the response.
        response.setContentType("application/msword");
        response.setHeader("Content-Disposition",
                           "attachment; filename=\""
                               + pdfName + "\"");
 
        // Get FileInputStream object to identify the path
        FileInputStream inputStream
            = new FileInputStream(pdfPath + pdfName);
 
        // Loop through the document and write into the
        // output.
        int in;
        while ((in = inputStream.read()) != -1) {
            out.write(in);
        }
 
        // Close FileInputStream and PrintWriter object
        inputStream.close();
        out.close();
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.dao.daoclass;
import com.model.upload;


@WebServlet("/uploadcontroller")
@MultipartConfig
public class uploadcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname=request.getParameter("fname");
		String email=request.getParameter("email");
		String mobno=request.getParameter("mobno");
		String projectname=request.getParameter("projectname");
		String desc=request.getParameter("desc");
		Part pic=request.getPart("pic");
	
	
		upload u=new upload(fname, email, mobno, projectname, desc,pic.getSubmittedFileName());
		daoclass dao=new daoclass();
		
		String uploadpath="E:/JAVA Exercise/Coders Hub/src/main/webapp/images/"+pic.getSubmittedFileName();
		try {
			FileOutputStream fos=new FileOutputStream(uploadpath);
			InputStream is=pic.getInputStream();
			byte[] data=new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
		}  catch (Exception e) {
		    e.printStackTrace();
		}
			boolean b=dao.uploaddata(u);
			HttpSession sess=request.getSession();
			if(b) {
			sess.setAttribute("message", "Project Added Successfully");
			response.sendRedirect("upload.jsp");
	    }
	}

}

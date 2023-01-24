package com.filter;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.superadmin;

public class adminfilter implements Filter{



	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpSession s=req.getSession();
		
		
		
		superadmin admin=(superadmin)s.getAttribute("obj");
		if(admin!=null) {
			chain.doFilter(request, response);
		}
		else {
			response.setContentType("text/html");
			//response.getWriter().println("Please login first");
			HttpServletResponse res=(HttpServletResponse)response;
			res.sendRedirect("error_login.jsp");
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}

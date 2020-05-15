package com.xjtuse.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * @author qgm
 * 系统登录后主界面
 */
public class SystemServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4104286661885773389L;
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.getWriter().write("hello");
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
	}
	
}

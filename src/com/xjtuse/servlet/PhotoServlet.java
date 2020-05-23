package com.xjtuse.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * Õº∆¨¥¶¿Ì¿‡servlet
 */
public class PhotoServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8628553952564594242L;

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String method = request.getParameter("method");
		if("getPhoto".equals(method)){
			getPhoto(request,response);
		}
	}

	private void getPhoto(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String path = request.getSession().getServletContext().getRealPath("");
		File file = new File(path+"\\WebContent\\file\\cat.jpg");
		try {
			response.getWriter().write(file.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


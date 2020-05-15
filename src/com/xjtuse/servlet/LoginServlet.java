package com.xjtuse.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xjtuse.dao.AdminDao;
import com.xjtuse.model.Admin;
import com.xjtuse.util.StringUtil;
/*
 * @author qgm
 * 登录验证servlet
 */
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5534457626349102198L;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String vcode = request.getParameter("vcode");
		String name = request.getParameter("account");
		String passWord = request.getParameter("password");
		String loginCaptcha = request.getSession().getAttribute("loginCaptcha").toString();
		int type = Integer.parseInt(request.getParameter("type"));
		
		if(StringUtil.isEmpty(vcode)){
			response.getWriter().write("vcodeError");
			return;
		}
		if(!vcode.toUpperCase().equals(loginCaptcha.toUpperCase())){
			response.getWriter().write("vcodeError");
			return;			
		}
		
		//验证码验证通过，对比用户名密码是否正确
		
		switch(type){
			case 1:{
				AdminDao adminDao = new AdminDao();
				Admin admin = adminDao.login(name,passWord);
				adminDao.closeConnection();
				if(admin == null){
					response.getWriter().write("loginError");
					return;
				}
				
				HttpSession session = request.getSession();
				session.setAttribute("user",admin);
				session.setAttribute("userType",type);
				response.getWriter().write("admin");
				break;
			}
			default:
				break;
		}
		
		//说明用户名密码正确
		
	}
}

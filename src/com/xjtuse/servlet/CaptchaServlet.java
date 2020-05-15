package com.xjtuse.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xjtuse.util.CaptchaUtil;

/**
 * 
 * @author qgm
 * ��֤��servlet
 */
public class CaptchaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6771064555871067369L;
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String method = request.getParameter("method");
		if("loginCaptcha".equals(method)){
			generateLoginCaptcha(request,response);
			return;
		}
		response.getWriter().write("error method");
	}
	
	private void generateLoginCaptcha(HttpServletRequest request,HttpServletResponse response) throws IOException{
		CaptchaUtil captchaUtil = new CaptchaUtil();
		String generatorVCode = captchaUtil.generatorVCode();
		request.getSession().setAttribute("loginCaptcha", generatorVCode);
		BufferedImage generatorRotateVCodeImage = captchaUtil.generatorRotateVCodeImage(generatorVCode, true);
		ImageIO.write(generatorRotateVCodeImage, "gif", response.getOutputStream());
	}
}

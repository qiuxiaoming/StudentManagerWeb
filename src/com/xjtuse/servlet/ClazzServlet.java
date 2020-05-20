package com.xjtuse.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.xjtuse.dao.ClazzDao;
import com.xjtuse.model.Clazz;
import com.xjtuse.model.Page;

public class ClazzServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String method = request.getParameter("method");
		if("toClazzListView".equals(method)){
			clazzList(request,response);
		}else if("getClazzList".equals(method)){
			getClazzList(request,response);
		}
	}

	private void clazzList(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			request.getRequestDispatcher("view/clazzList.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getClazzList(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("name");
		Integer pageSize = Integer.parseInt(request.getParameter("rows"));
		Integer currentPage = Integer.parseInt(request.getParameter("page"));
		Clazz clazz = new Clazz();
		clazz.setName(name);
		ClazzDao clazzDao = new ClazzDao();
		List<Clazz> clazzList =  clazzDao.getClazzList(clazz, new Page(currentPage,pageSize));
		clazzDao.closeConnection();
		
		JsonConfig jsonConfig = new JsonConfig();
		String clazzListString = JSONArray.fromObject(clazzList,jsonConfig).toString();
		//System.out.print(clazzListString);
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(clazzListString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}

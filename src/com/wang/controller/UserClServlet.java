package com.wang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wang.model.UserBeanCl;

public class UserClServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try{
					
			int pageNow = Integer.parseInt((String)request.getParameter("pageNow")) ;
			UserBeanCl ubc = new UserBeanCl() ;	
			
			ArrayList al = ubc.getResultByPage(pageNow,3) ;	
			int pageCount = ubc.getPageCount() ;
			// 将 al pageCount 放入 request
			// sendRedirect 方法效率不高
			// 效率高且request中对象还可在下一页面中使用
			request.setAttribute("result", al) ;
			request.setAttribute("pageCount", pageCount+"") ;
			request.setAttribute("pageNow", pageNow+"") ;
			request.getRequestDispatcher("wel.jsp").forward(request, response) ;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response) ;
	}

}

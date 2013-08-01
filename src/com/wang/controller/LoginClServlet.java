package com.wang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.wang.model.*;

public class LoginClServlet extends HttpServlet {

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
			
		String u = request.getParameter("username") ;
		String p = request.getParameter("passwd") ;
		// ʹ��ģ�������֤ 
		request.setCharacterEncoding("gb2312");
		PrintWriter pw = response.getWriter() ;
		
		UserBeanCl ubc = new UserBeanCl() ;		
		if(ubc.checkUser(u,p)){
		
			pw.print("success") ;
			ArrayList al = ubc.getResultByPage(1,3) ;	
			int pageCount = ubc.getPageCount() ;
			// �� al pageCount ���� request
			// sendRedirect ����Ч�ʲ���
			// Ч�ʸ���request�ж��󻹿�����һҳ����ʹ��
			request.setAttribute("result", al) ;
			request.setAttribute("pageCount", pageCount+"") ;
			request.setAttribute("pageNow", "1") ;
			
			// ��¼�ɹ� ���û�������session
			request.getSession().setAttribute("myName", u);
			
			request.getRequestDispatcher("main.jsp?user="+u).forward(request, response) ;
			System.out.println("ssss") ;	
		}else{
			pw.print("uou wen ti") ;
			request.getRequestDispatcher("login.jsp").forward(request, response) ;
			System.out.println("ssee") ;
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

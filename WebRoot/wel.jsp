<%@ page language="java" import="java.util.*,java.sql.*,com.wang.model.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'wel.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body><center>
  		
  		<%
  			// ��ֹ�û��Ƿ���¼
  			
  			String u = (String)request.getSession().getAttribute("myName") ;
  			
  			if(u==null)
  			{
  				response.sendRedirect("login.jsp?err=1") ;
  				return ;
  			}
  			System.out.println(u+"ddd") ;
  		 %>
  		
       <h1>��¼�ɹ�</h1> <%= u %> 
       <a href="login.jsp">���ĵ���</a>
       <hr>
       <h1>�û���Ϣ�б�</h1>
       <%
       		
			
			
			UserBeanCl ubc = new UserBeanCl() ;
			ArrayList al = (ArrayList)request.getAttribute("result") ;
			int pageNow = Integer.parseInt((String)request.getAttribute("pageNow")) ;
			int pageCount = Integer.parseInt((String)request.getAttribute("pageCount")) ;			
			       
        %>
        
        	<table border="1">
        	<tr><td>�û�id</td><td>�û���</td><td>����</td><td>����</td><td>����</td></tr>
        	<%
        		for(int i=0;i<al.size();i++)
        		{
        			UserBean ub = (UserBean)al.get(i) ;
        		
        		
        	%>
        		<tr><td><%=ub.getUserId() %></td><td><%= ub.getUserName() %></td><td>
        		<%=ub.getPasswd() %></td><td><%=ub.getMail() %></td><td>
        		<%=ub.getGrade() %></td></tr>
        	
        	<% } %>
        	</table>
       		<%
       			if(pageNow!=1){
				
				out.println("<a href=UserClServlet?pageNow="+(pageNow-1)+">��һҳ</a>") ;
		
				}
				
       			for(int i=1;i<=pageCount;i++)
       			{
       				out.println("<a href=UserClServlet?pageNow="+i+">"+i+"</a>") ;	
       			}
       			if(pageNow<pageCount){			
				out.println("<a href=UserClServlet?pageNow="+(pageNow+1)+">��һҳ</a>") ;
			}	
       		 %>
       
  </body>
</html>

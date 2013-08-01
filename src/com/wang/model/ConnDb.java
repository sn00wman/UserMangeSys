package com.wang.model;

import java.sql.* ;

public class ConnDb{
	
	Connection ct = null ;
	public Connection getConn()
	{
		try{
			
			// 加载 驱动 
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver") ;
			// 得到 连接			
			ct = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=wldb","sa","8701249");

		}catch(Exception e){
			
			e.printStackTrace() ;	
		}
		
		return ct ;
	}
	
} 
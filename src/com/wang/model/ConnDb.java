package com.wang.model;

import java.sql.* ;

public class ConnDb{
	
	Connection ct = null ;
	public Connection getConn()
	{
		try{
			
			// ���� ���� 
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver") ;
			// �õ� ����			
			ct = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=wldb","sa","8701249");

		}catch(Exception e){
			
			e.printStackTrace() ;	
		}
		
		return ct ;
	}
	
} 
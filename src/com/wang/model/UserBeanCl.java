/*
 * ����һ�������࣬���˽���bo����Ҫ�Ƿ�װ��users��ĸ��ֲ���
 * ����ɾ�ã�
 */
package com.wang.model;

import java.sql.* ;
import java.util.* ;

public class UserBeanCl {
	
	
	private Connection ct = null ;
	private PreparedStatement ps = null ;
	private ResultSet rs = null ;
	private int pageCount = 0 ;
	//
	public int getPageCount()
	{
		return this.pageCount ;
	}
	// ɾ������ 
	public boolean delUser(String id){
		
		boolean b = false ;
		try
		{
			
			ConnDb cd = new ConnDb() ;
			ct = cd.getConn() ;
			
			String sql = "delete from users where userId ='"+id+"'" ;
			ps = ct.prepareStatement(sql) ;
	
			int num = ps.executeUpdate() ;
			
			if(num==1){
				b = true ;
			}
	
		}
		catch(Exception e)
		{			
			e.printStackTrace() ;
		}
		finally
		{
			this.close() ;
		}
		
		return b ;
	}
	// ��ҳ 
	public ArrayList getResultByPage(int pageNow,int pageSize){
		
		ArrayList al = new ArrayList() ;
		
		try{
			int rowCount = 0 ;
		
			
			ConnDb cd = new ConnDb() ;
			ct = cd.getConn() ;							
	
			ps = ct.prepareStatement("select count(*) from users ") ;
			rs = ps.executeQuery() ;
				
		    if(rs.next())
			{
				rowCount = rs.getInt(1) ;	
			}
			System.out.println(rowCount+" @") ;					
			// ����pagecount 
			if(rowCount%pageSize == 0)
			{
				pageCount = rowCount/pageSize ;
			}else{
				pageCount = rowCount/pageSize + 1 ;
			}
			System.out.println(pageCount+" *") ;		
			ps = ct.prepareStatement("select top "+pageSize+" * from users where  userId not in (select top "+(pageSize*(pageNow-1))+" userId from users )") ;
				
					
			rs = ps.executeQuery() ;		
			// ��rs ��ÿһ����¼��װ�� userbean �� 
			while (rs.next())
			{
				UserBean ub = new UserBean() ;
				ub.setUserId(rs.getInt(1))	;
				ub.setUserName(rs.getString(2)) ;
				ub.setPasswd(rs.getString(3)) ;
				ub.setMail(rs.getString(4)) ;
				ub.setGrade(rs.getInt(5)) ;
				
				al.add(ub) ;
			}
		}catch(Exception e)
		{
			e.printStackTrace() ;
		}finally
		{
			this.close() ;
		}
				
		return al ;
	}
		 ;
	// ��֤ �û� 
	public boolean checkUser(String u,String p){
		
		boolean b = false ;
		try
		{
			 
			ConnDb cd = new ConnDb() ;
			ct = cd.getConn() ;
			
			ps = ct.prepareStatement("select top 1 passwd from users where username ='"+u+"'") ;
	
			rs = ps.executeQuery() ;
			
			if(rs.next()){
				String dbPasswd = rs.getString(1) ;
				if(dbPasswd.equals(p)){
					b = true ;
				}
			}
	
		}
		catch(Exception e)
		{			
			e.printStackTrace() ;
		}
		finally
		{
			this.close() ;
		}
		

		return b ;
	}
	
	
	public void close()
	{
		try
		{
			
			if(rs!=null){ rs.close() ; rs = null ; }
			if(ps!=null){ ps.close() ; ps = null ; }	
			if(ct!=null){ ct.close() ; ct = null ; }	
				
		}catch(Exception e){
			
			e.printStackTrace() ;
		}
						
	}
}
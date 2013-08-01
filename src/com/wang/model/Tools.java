package com.wang.model;

public class Tools {
	// ÂÒÂë ×ª³É gb2312 
	
	public static String getNewString(String input)
	{
		String result="" ;
		try{
			result = new String(input.getBytes("is0-8859-1"),"gb2312") ;
		}catch(Exception e)
		{
			e.printStackTrace() ;
		}
		return result ;
	}
}

package com.wang.model;

public class UserBean {
	
	private int userId ;
	private String userName ;
	private String passwd ;
	private String mail ;
	private int grade ;
	
	 
	public void setUserId(int userId){
		this.userId = userId ;
	}
	
	public int getUserId(){
		return this.userId ;
	}
	
	public void setUserName(String userName){
		this.userName = userName ;
	}
	
	public String getUserName(){
		return this.userName ;
	}
	public void setPasswd(String passwd){
		this.passwd = passwd ;
	}
	
	public String getPasswd(){
		return this.passwd ;
	}
	
	public void setMail(String mail){
		this.mail = mail ;
	}
	
	public String getMail(){
		return this.mail ;
	}
	
	public void setGrade(int grade){
		this.grade = grade ;
	}
	
	public int getGrade(){
		return this.grade ;
	}
	
}
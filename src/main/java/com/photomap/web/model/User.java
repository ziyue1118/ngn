package com.photomap.web.model;
import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	private int id;
	private String username;
	private String password;
	private String email;
	
	public User(){
	}
	
	public User(int uid, String uname, String upassword, String uemail){
		id = uid;
		username = uname;
		password = upassword;
		email = uemail;
	}
	//getter and setters: 
	
	public int getId() {
		return id;
	}

	public String getEmail(){
		return email;
	}

	public String getUsername(){
		return username;
	}

	public String getPassword(){
		return password;
	}

	public void setId(int uid){
		id = uid;
	}

	public void setEmail(String uemail){
		email =  uemail;
	}

	public void setUsername(String uname){
		username = uname;
	}

	public void setPassword(String upwd){
		password = upwd;
	}

}
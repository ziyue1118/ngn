package com.photomap.web.form;

public class UserForm {
	private String username;
	private String password;
	private String email;


	public String getUsername(){
		return username;
	}
	public String getPassword(){
		return password;
	}
	public String getEmail(){
		return email;
	}

	public void setUsername(String pUsername){
		username = pUsername;
	}
	public void setPassword(String pPassword){
		password = pPassword;
	}
	public void setEmail(String pEmail){
		email = pEmail;
	}

}

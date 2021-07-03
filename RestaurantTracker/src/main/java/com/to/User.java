package com.to;

public class User {

	private String uid;
	private String email;
	private String passwod;
	private String name;
	private String phone;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String uid, String email, String passwod, String name, String phone) {
		super();
		this.uid = uid;
		this.email = email;
		this.passwod = passwod;
		this.name = name;
		this.phone = phone;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswod() {
		return passwod;
	}
	public void setPasswod(String passwod) {
		this.passwod = passwod;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}

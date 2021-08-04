package com.otp.entity;

public class UserOtp {

//	public int oid;

	public String otp;

	public Integer uid;

	public UserOtp( String otp, Integer uid) {
		super();
		this.otp = otp;
		this.uid = uid;
	}


	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public UserOtp() {
		super();
	}



}

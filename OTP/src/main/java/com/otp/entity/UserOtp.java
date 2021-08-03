package com.otp.entity;

public class UserOtp {

	public int oid;

	public String otp;

	public Integer uid;

	public UserOtp(int oid, String otp, Integer uid) {
		super();
		this.oid = oid;
		this.otp = otp;
		this.uid = uid;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
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

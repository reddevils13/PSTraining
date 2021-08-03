package com.otp.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user_otp")
public class OTP {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int oid;
	
	@Column
	public String otp;
	
	@Column
	public Integer uid;
	
	@Column
	public Date timstamp;

	public boolean otpExpire(OTP otp) {
		
		final long OTP_VALIDATION_TIME = 1 * 60 * 1000; //expire after 1 minute (60000 ms)
		
		if(this.getOtp() == null)
			return false;
		long currentTime = System.currentTimeMillis() + 19800000; //IST
		long otptimstamp = 0;
		otptimstamp = otp.gettimstamp().getTime();
		System.out.println(otptimstamp);
		if(otptimstamp + OTP_VALIDATION_TIME < currentTime){
			System.out.println(otptimstamp + OTP_VALIDATION_TIME);
			System.out.println(OTP_VALIDATION_TIME);
			System.out.println(currentTime);
			return false;
		}
		System.out.println(otptimstamp-currentTime);
		return true;
	}
	
	public OTP() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OTP(int oid, String otp, int uid, Date timstamp) {
		super();
		this.oid = oid;
		this.otp = otp;
		this.uid = uid;
		this.timstamp = timstamp;
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

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Date gettimstamp() {
		return timstamp;
	}

	public void settimstamp(Date date) {
		
		this.timstamp = date;
	}

	@Override
	public String toString() {
		return "OTP [oid=" + oid + ", otp=" + otp + ", uid=" + uid + ", timstamp=" + timstamp + "]";
	}
	
		
	
	
	
	
}

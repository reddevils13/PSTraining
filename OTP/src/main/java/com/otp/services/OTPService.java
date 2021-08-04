package com.otp.services;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.otp.entity.OTP;
import com.otp.entity.User;
import com.otp.entity.UserOtp;
import com.otp.interfaces.IOTPDAO;
import com.otp.interfaces.IUserDAO;
import com.otp.utils.OTPUtil;

@Service
@Transactional
public class OTPService {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private IUserDAO iUserDao;

	@Autowired
	private IOTPDAO iotpdao;

	public User addUser(User user) {
		String password = passwordEncoder.encode(user.getPassword());
		user.setPassword(password);
		return iUserDao.save(user);
	}

	public List<User> showUser() {
		return iUserDao.findAll();
	}
//
//	public boolean check(OTP otpToValidate) {
//		if (!otpToValidate.otpExpire(otpToValidate)) {
//
//			return false;
//		}
//		Optional<OTP> userOtp = iotpdao.findById(otpToValidate.getOid());
//		if (userOtp.isPresent()) {
//			OTP otp = userOtp.get();
//			if (otpToValidate.getOtp().equals(otp.getOtp())) {
//				return true;
//			}
//		}
//
//		return false;
//	}

	private void renewOtp(User u) throws ParseException {
		String code = OTPUtil.generateCode();
//        System.out.println("code =" + code);
//        System.out.println("uid = "+u.getUid());
		Optional<OTP> userOtp = iotpdao.findOTPByuid(u.getUid());

		if (userOtp.isPresent()) {
			OTP otp = userOtp.get();
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			System.out.println(ts);
			Date date = sdf.parse(ts.toString());

			otp.settimstamp(date);
			otp.setOtp(code);
			iotpdao.save(otp);
			} 
		else {
			OTP otp = new OTP();
			otp.setUid(u.getUid());
			otp.setOtp(code);
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			Date date = sdf.parse(ts.toString());

			otp.settimstamp(date);
			iotpdao.save(otp);
		}
	}

	public void auth(int uid) {
		Optional<User> o = iUserDao.findById(uid);

		if (o.isPresent()) {
			User u = o.get();
			try {
				renewOtp(u);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			throw new BadCredentialsException("Bad credentials-1");
		}
	}

	public boolean check(UserOtp otpToValidate) {

		final long OTP_VALIDATION_TIME = 1 * 60 * 1000; // expire after 1 minute (60000 ms)

		Optional<OTP> userOtp = iotpdao.findOTPByuid(otpToValidate.getUid());
		OTP otp;
		if (userOtp == null)
			return false;
		
		otp = userOtp.get();
		System.out.println(otp);
		long currentTime = System.currentTimeMillis(); 
		long otptimstamp = otp.gettimstamp().getTime();
		
		System.out.println(otp.gettimstamp());
		
		boolean expiry=true; boolean validate=false;
		
		if (otptimstamp + OTP_VALIDATION_TIME > currentTime) {
			expiry=false;
		}
		
		if (otpToValidate.getOtp().equals(otp.getOtp())) {
			validate=true;
		}
		
		System.out.println(otptimstamp + OTP_VALIDATION_TIME - currentTime);
		System.out.println(currentTime);
		
		return !expiry && validate;
	}

}

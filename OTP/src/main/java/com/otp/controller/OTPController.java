package com.otp.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.otp.config.ResourceBundleMethods;
import com.otp.entity.OTP;
import com.otp.entity.User;
import com.otp.entity.UserOtp;
import com.otp.interfaces.IOTPDAO;
import com.otp.interfaces.IUserDAO;
import com.otp.services.OTPService;

/* Change author accordingly
 * Author - Aritra*/

@RestController
public class OTPController {
//
	@Autowired
	OTPService otpService;

	@PostMapping("/user/add")
	public void addUser(@RequestBody User user) {
		otpService.addUser(user);
	}

	@PostMapping(value = "/user/generate", consumes = "application/json")
	public void auth(@RequestBody Integer uid) {
		otpService.auth(uid);
	}

	@PostMapping("/otp/check")
	public void check(@RequestBody UserOtp userOtp, HttpServletResponse response) {
		if (otpService.check(userOtp)==true) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@GetMapping("/user/show")
	public void show() {
		otpService.showUser();
	}

}

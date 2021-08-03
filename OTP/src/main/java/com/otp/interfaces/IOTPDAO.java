package com.otp.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.otp.entity.OTP;
import com.otp.entity.User;

/* Change author accordingly
 * Author - Aritra*/


@Service
public interface IOTPDAO extends JpaRepository<OTP,Integer>{

	@Query(value = "select * from user_otp where uid=?1", nativeQuery = true)
	public Optional<OTP> findOTPByuid(int uid);

}

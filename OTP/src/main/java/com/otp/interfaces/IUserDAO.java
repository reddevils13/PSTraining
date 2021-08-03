package com.otp.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.otp.entity.User;

@Service
public interface IUserDAO  extends JpaRepository<User,Integer>{

}

package com.otp;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.otp.entity.UserOtp;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class OTPApplicationTests extends SpringBootServletInitializer {

	@Autowired
	MockMvc mvc;
	
	@Test
	public void testAuth() throws Exception {
		
		int USER_ID = 18;
		
		mvc.perform(MockMvcRequestBuilders
				.post("/user/generate")
				.content(asJsonString(USER_ID))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void testCheck() throws Exception {
		
		UserOtp TestOTP = new UserOtp("1234",18);
		
		mvc.perform(MockMvcRequestBuilders
				.post("/otp/check")
				.content(asJsonString(TestOTP))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isForbidden());
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}

package com.otp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/* Change author accordingly
 * Author - Aritra*/


@SpringBootApplication
@EnableJpaRepositories
public class OTPApplication {

	public static void main(String[] args) {
		SpringApplication.run(OTPApplication.class, args);
	}

}

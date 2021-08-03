package com.otp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* Change author accordingly
 * Author - Vikas*/


@Configuration
public class ResourceBundleConfig {

	@Bean
	public ResourceBundleMethods resourceBundle() {
		return new ResourceBundleMethods();
	}
}

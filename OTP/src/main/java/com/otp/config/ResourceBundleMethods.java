package com.otp.config;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

import org.springframework.stereotype.Component;

/* Change author accordingly
 * Author - Vikas*/


@Component
public class ResourceBundleMethods {

	private ResourceBundle resourceBundle;

	public ResourceBundleMethods() {
		super();
	}

	public void setResourceBundle(String basename, Locale locale) {
		this.resourceBundle = ResourceBundle.getBundle(basename, locale);
	}

	public Boolean isKeyPresent(String key) {
		return this.resourceBundle.containsKey(key);
	}

	public Locale getYourLocale() {
		return this.resourceBundle.getLocale();
	}

	public String getKeyString(String key) {
		return this.resourceBundle.getString(key);
	}

	public Set<String> getAllKeys() {
		return this.resourceBundle.keySet();
	}
}

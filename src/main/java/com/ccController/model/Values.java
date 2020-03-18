package com.ccController.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Values {
	@Value("${subURI}")
	private String subURI;
	@Value("${unsubURI}")
	private String unsubURI;

	public String getUnsubURI() {
		return unsubURI;
	}

	public String getSubURI() {
		return subURI;
	}
	
}

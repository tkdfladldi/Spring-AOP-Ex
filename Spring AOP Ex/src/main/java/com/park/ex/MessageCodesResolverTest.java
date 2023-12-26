package com.park.ex;

import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

public class MessageCodesResolverTest {
	
	
	MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();
	
	
	void messageCodesResolverObject() {
		
		String[] messageCodes = codesResolver.resolveMessageCodes("asd", "asd");
		
	}
}

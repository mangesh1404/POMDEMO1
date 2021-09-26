package com.listeners;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class Demo {
	private Logger log = Logger.getLogger(Demo.class);
	
	public int divide(int a, int b) {
		log.info("user wants to perform division");
		int result=0;
		try {
			log.warn("user should never use b=0");
			result=a/b;
			return result;
		}catch(ArithmeticException e) {
			log.error("user is tried to divide by 0");
			return result;
		}
	}
	
	@Test
	public void test() {
		divide(6,2);
		divide(4, 0);
	}
	
	
}

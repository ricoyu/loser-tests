package com.loserico;

import org.junit.Test;

public class SystemPropertyTest {
	
	@Test
	public void testProperties() {
		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("user.home"));
	}
	
	
	@Test
	public void testSystemProcesors() {
		System.out.println(Runtime.getRuntime().availableProcessors());
	}
}

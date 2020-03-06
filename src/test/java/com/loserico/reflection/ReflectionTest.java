package com.loserico.reflection;

import java.lang.reflect.Field;

import org.junit.Test;

import com.loserico.commons.utils.ReflectionUtils;

public class ReflectionTest {

	@Test
	public void testFields() {
		Field[] fields = Man.class.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			System.out.println(field.toGenericString());
			System.out.println(field.getName());
		}
	}
	
	@Test
	public void testGetFields() {
		Field[] fields  = ReflectionUtils.getFields(Man.class);
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			System.out.println(field.toGenericString());
		}
	}
}

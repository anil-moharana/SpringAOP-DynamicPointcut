package com.sp.beans;

import java.lang.reflect.Method;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;


public class LoggingPointcut extends DynamicMethodMatcherPointcut{

	
	
	@Override
	public boolean matches(Method method, Class<?> classType, Object[] args) {
		// TODO Auto-generated method stub
		
		
		if (method.getName().equals("add")
				&& classType.isAssignableFrom(Calculator.class)
				&& (Integer) args[0] > 99) {
			return true;
		}
		return false;
	}

}

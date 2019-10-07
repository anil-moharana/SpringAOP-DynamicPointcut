package com.sp.test;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.sp.beans.Calculator;
import com.sp.beans.LoggingAdvice;
import com.sp.beans.LoggingPointcut;

public class DynamicPointcutTest {
	
	public static void main(String[] args) {
		Calculator calculator=new Calculator();
		LoggingPointcut loggingpointcut=new LoggingPointcut();
		LoggingAdvice loggingadvice=new LoggingAdvice();
		ProxyFactory pf=new ProxyFactory();
		pf.setTarget(calculator);
		pf.addAdvisor(new DefaultPointcutAdvisor(loggingpointcut,loggingadvice));
		Calculator proxy=(Calculator)pf.getProxy();
		int sum = proxy.add(100, 20);
		System.out.println("sum : " + sum);

		int mul = proxy.multiply(10, 20);
		System.out.println("multiply : " + mul);
		
	}

}

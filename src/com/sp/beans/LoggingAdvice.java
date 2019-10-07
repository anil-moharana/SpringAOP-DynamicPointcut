package com.sp.beans;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation methodinvocation) throws Throwable {
		
		String methodname=null;
		Object[] args=null;
		Object ret = null;
		methodname=methodinvocation.getMethod().getName();
		System.out.print("Entering into methodName: "+methodname+"(");
		args=methodinvocation.getArguments();
		for(int i=0;i<args.length;i++) {
			
			if(i==0) {
				System.out.print(args[i]);
				continue;
			}
			System.out.print(","+args[i]);
		}
		
		System.out.println(")");
		
		ret=methodinvocation.proceed();
		System.out.println("Returning from: "+methodname+"with return value as:"+ret);
		
		
		
		return ret;
	}
	
	
	
	

}

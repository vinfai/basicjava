package com.vinfai.spring.aop.proxyfactory;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MyBeforeAdvice implements MethodBeforeAdvice {
	
	public MyBeforeAdvice() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		System.out.println("=============before *say method invoke============");
	}
	
	
}

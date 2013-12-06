package com.vinfai.spring.aop.proxyfactory;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.framework.ReflectiveMethodInvocation;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.MethodInvoker;

/**
 * Spring AOP基础实现 ProxyFactoryBean
 * @author vinfai
 *
 */
public class ProxyFactoryBeanTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
		IPerson person = (IPerson)ctx.getBean("person");
		person.dosay();
		IPerson proxy = (IPerson)ctx.getBean("proxyBean");
		proxy.dosay();
		
		//ProxyFactoryBean
		
		//TransactionProxyFactoryBean
	}
}

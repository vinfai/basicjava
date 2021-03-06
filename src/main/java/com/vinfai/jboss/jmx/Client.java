package com.vinfai.jboss.jmx;

import org.jboss.mx.util.MBeanProxyExt;
import org.jboss.mx.util.ObjectNameFactory;
/**
 * Jboss MBean depend on jboss-jmx.jar,jboss-system.jar
 * @author fangwh
 *
 */
public class Client {
	
	public void go(){
		HelloServiceMBean mbean = 
			(HelloServiceMBean)MBeanProxyExt.create(HelloServiceMBean.class, 
					ObjectNameFactory.create("jboss:service=HelloService"));
		String msg  = mbean.getMessage();
		System.out.println("client.go():="+msg);
	}
	
}

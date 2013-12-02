package com.vinfai.jmx.demo;

import java.net.MalformedURLException;

import javax.management.MBeanConstructorInfo;
import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
//http://docs.oracle.com/javase/tutorial/jmx/remote/custom.html

public class HelloRMIConnectorClient {
	
	public static void main(String[] args){
		try {
			JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:8282/jmxserver_rmi_test");
			JMXConnector jmxcon = JMXConnectorFactory.connect(url);
			MBeanServerConnection mbsc = jmxcon.getMBeanServerConnection();
			ObjectName objectName = new ObjectName("com.hello:name=helloservice");
			mbsc.addNotificationListener(objectName, new HelloListener(), null, null);
			
			HelloMBean proxy = (HelloMBean)MBeanServerInvocationHandler.
				newProxyInstance(mbsc,objectName, HelloMBean.class, false);
//			proxy.addNotificationListener(new HelloListener(), null, null);
			proxy.setName("china564");
//			proxy.setStatus(".....start....");
			String str = proxy.getName();
			System.out.println(str);
			
			
			Thread.sleep(5000);
			jmxcon.close();
		} catch (Exception e) {
			e.printStackTrace();
		}  
	    
	}
}

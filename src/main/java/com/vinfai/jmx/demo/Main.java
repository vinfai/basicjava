package com.vinfai.jmx.demo;

import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

import com.sun.jdmk.comm.HtmlAdaptorServer;

/**
 * Standard MBean, Notification, <br>
 * key: MBean,MBeanServer,Adaptor,Connector
 * Layer: Resource sub Agent layer
 * Layer2: Agent layer,core:MBeanServer
 * Layer3: Distributed Layer. remote Management( RMI,HTTP etc)
 * @author vinfai
 */
public class Main {
	
	public static void main(String[] args){
		HelloMBean bean = new Hello();
//		MBeanServer service = MBeanServerFactory.createMBeanServer();
		MBeanServer service = ManagementFactory.getPlatformMBeanServer();
		try {
			ObjectName name = new ObjectName("com.hello:name=helloservice");
			service.registerMBean(bean, name);
			
			//manage
			HtmlAdaptorServer adaptor = new HtmlAdaptorServer();
			adaptor.setPort(9999);
			
			//adaptor.addNotificationListener(new HelloListener(), null, null);
			service.registerMBean(adaptor, new ObjectName("com.hello:name=htmlAdaptorService,port=9999"));
			adaptor.start();
			
			service.addNotificationListener(name, new HelloListener(), null, null);
			
			
			
			
			String rmiPort = "8282";
			// jdkfolder/bin/rmiregistry.exe 9999         
	        Registry registry = LocateRegistry.createRegistry(8282);
	  
			
	        
	        //remote rmi invocation.
			//service:jmx:${protocal}
			String jmxServerName = "jmxserver_rmi_test";
			JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://192.168.1.205:" + rmiPort + "/" + jmxServerName);  
	        System.out.println("JMXServiceURL: " + url.toString());  
	        JMXConnectorServer jmxConnServer = JMXConnectorServerFactory.newJMXConnectorServer(url, null, service);  
	        //jmxConnServer.addNotificationListener(new HelloListener(), null, null);
	        jmxConnServer.start();  
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
}

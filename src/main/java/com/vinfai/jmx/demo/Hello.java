package com.vinfai.jmx.demo;

import java.util.Random;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
/**
 * standard MBean  命名规范
 * 		interface :  [name]MBean
 * 		implement :	 [name]
 * name必须相同
 * 监控的类和MBean 接口必需在同一包下
 * @author vinfai
 *
 */
public class Hello extends NotificationBroadcasterSupport implements HelloMBean{
	private long sequenceNumber = 0;
	private String name;
	private String status;
	
	@Override
	public String getName() {
		
		return "hello name"+new Random().nextDouble()+name;
	}

	@Override
	public String getStatus() {
		return status+"STATUS:"+new Random().nextDouble();
	}

	@Override
	public void setName(String name) {
		String oldVal = name;
		this.name = name;
		
		//notify now!
		Notification n = new AttributeChangeNotification
			(this, sequenceNumber++, System.currentTimeMillis(), "name changed", 
					"Name", "java.lang.String", oldVal, name);
		sendNotification(n);
		System.out.println("send notify now.......");
	}

	@Override
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	/*@Override 
    public MBeanNotificationInfo[] getNotificationInfo() { 
        String[] types = new String[] { 
            AttributeChangeNotification.ATTRIBUTE_CHANGE 
        }; 
        String name = AttributeChangeNotification.class.getName(); 
        String description = "An attribute of this MBean has changed"; 
        MBeanNotificationInfo info = 
            new MBeanNotificationInfo(types, name, description); 
        return new MBeanNotificationInfo[] {info}; 
    } */
	 

}

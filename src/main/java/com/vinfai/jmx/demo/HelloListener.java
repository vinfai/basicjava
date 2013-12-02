package com.vinfai.jmx.demo;

import javax.management.AttributeChangeNotification;
import javax.management.Notification;
import javax.management.NotificationListener;
/**
 * 
 * 
 * @author fangwh
 */
public class HelloListener implements NotificationListener{

	@Override
	public void handleNotification(Notification notification, Object handback) {
		System.out.println("notification:"+notification.toString());
		System.out.println(notification.getSource());
		System.out.println(	notification.getUserData());
		if (notification instanceof AttributeChangeNotification) {
            AttributeChangeNotification acn =
                (AttributeChangeNotification) notification;
            echo("\tAttributeName: " + acn.getAttributeName());
            echo("\tAttributeType: " + acn.getAttributeType());
            echo("\tNewValue: " + acn.getNewValue());
            echo("\tOldValue: " + acn.getOldValue());
        }
		HelloMBean source = (HelloMBean)notification.getSource();
		System.out.println("source info:"+source.getName()+";status:"+source.getStatus());
	}
	
	public void echo(String str){
		System.out.println(str);
	}

}

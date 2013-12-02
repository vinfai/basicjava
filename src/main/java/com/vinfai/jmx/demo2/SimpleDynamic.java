package com.vinfai.jmx.demo2;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.AttributeNotFoundException;
import javax.management.DynamicMBean;
import javax.management.InvalidAttributeValueException;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.NotificationBroadcasterSupport;
import javax.management.ReflectionException;
/**
 * dynamic MBean demo <br>
 * 
 * @author fangwh
 */
public class SimpleDynamic extends NotificationBroadcasterSupport implements DynamicMBean{

//	private ThreadPoolManager 
	@Override
	public Object getAttribute(String attribute)
			throws AttributeNotFoundException, MBeanException,
			ReflectionException {
		
		if(attribute==null){
			throw new AttributeNotFoundException();
		}
		
		if(attribute.equals("Name")){
			
		}
		
		
		
		return null;
	}

	@Override
	public AttributeList getAttributes(String[] attributes) {
		
		return null;
	}

	@Override
	public MBeanInfo getMBeanInfo() {
		return null;
	}

	@Override
	public Object invoke(String actionName, Object[] params, String[] signature)
			throws MBeanException, ReflectionException {
		
		
		return null;
	}

	@Override
	public void setAttribute(Attribute attribute)
			throws AttributeNotFoundException, InvalidAttributeValueException,
			MBeanException, ReflectionException {
		
	}

	@Override
	public AttributeList setAttributes(AttributeList attributes) {
		
		return null;
	}

	
}

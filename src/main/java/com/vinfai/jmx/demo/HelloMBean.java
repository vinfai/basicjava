package com.vinfai.jmx.demo;

import java.io.Serializable;

import javax.management.NotificationEmitter;

/**
 * Managed Bean
 * 
 * @author vinfai
 *
 */
public interface HelloMBean extends NotificationEmitter,Serializable {

	String getName();
	void setName(String name);
	
	String getStatus();
	void setStatus(String status);
	
}

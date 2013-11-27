package com.vinfai.jboss.jmx;

import org.jboss.system.ServiceMBean;

public interface HelloServiceMBean extends ServiceMBean{
	
	String getMessage();
	void setMessage(String message);
	
	String getTableName();

	void setTableName(String paramString)throws Exception;
	
	void doCallGo();
	
}

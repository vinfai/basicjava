package com.vinfai.jboss.jmx;

import org.jboss.system.ServiceMBeanSupport;

public class HelloService extends ServiceMBeanSupport implements HelloServiceMBean{
	private String message;
	
	private String tableName;
	
	@Override
	public String getMessage() {
		System.out.println("get message:"+message);
		return message;
	}

	@Override
	public void setMessage(String message) {
		System.out.println("set message:"+message);
		this.message = message;
	}

	@Override
	public String getTableName() {
		return tableName;
	}

	@Override
	public void setTableName(String tableName) throws Exception {
		this.tableName = tableName;
	}
	/**
	 * 在页面上显示方法调用 invoke按钮
	 */
	@Override
	public void doCallGo() {
		new Client().go();
	}

	
}

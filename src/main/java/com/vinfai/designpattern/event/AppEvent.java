package com.vinfai.designpattern.event;

import java.util.EventObject;

public class AppEvent extends EventObject {
	
	private static final long serialVersionUID = -3639766592807189946L;
	
	private String type;
	
	public AppEvent(Object source){
		super(source);
	}
	
	public AppEvent(String type,Object source){
		super(source);
		if(null==type){
			throw new IllegalArgumentException("type is null");
		}
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}

package com.vinfai.designpattern.event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * event data source.
 * @author vinfai
 */
public class DocumentEventData {
	
	private String name;
	private String message;
	private Date msgTime;
	private String type;
	
	public List<AppEventListener> listeners = Collections.synchronizedList(new ArrayList<AppEventListener>());
	
	public void register(AppEventListener listener){
		if(!listeners.contains(listener)){
			listeners.add(listener);
		}
	}
	
	public void unregister(AppEventListener listener){
		listeners.remove(listener);
	}
	
	public void notifyListeners(){
		AppEvent  event = new AppEvent(this);
		for(AppEventListener listener : listeners){
			listener.handleEvent(event, type);
		}
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getMsgTime() {
		return msgTime;
	}
	public void setMsgTime(Date msgTime) {
		this.msgTime = msgTime;
	}
}

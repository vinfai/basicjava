package com.vinfai.designpattern.event;

import java.util.Date;
/**
 * java 事件处理模型
 * @author vinfai
 *
 */
public class Client {
	
	public static void main(String[] args){
		DocumentEventData data = new DocumentEventData();
		data.setMessage("hello world!");
		data.setName("vinfai");
		data.setType("DOCUMENT_EVENT");
		data.setMsgTime(new Date());
		
		//listeners
		DocumentEventListener listener = new DocumentEventListener();
		DocumentEventListener listener2 = new DocumentEventListener();
		DocumentEventListener listener3 = new DocumentEventListener();
		
		data.listeners.add(listener);
		data.listeners.add(listener2);
		data.listeners.add(listener3);
		
		data.notifyListeners();
	}
}

package com.vinfai.designpattern.event;

import java.util.EventListener;

public interface AppEventListener extends EventListener {
	
	void handleEvent(AppEvent event,String type);
	 
}

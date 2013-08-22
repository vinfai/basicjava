package com.vinfai.designpattern.event;

public class DocumentEventListener implements AppEventListener {

	
	public void handleEvent(AppEvent event, String type) {
		Object obj = event.getSource();
		if(obj instanceof DocumentEventData){
			DocumentEventData data  = (DocumentEventData)obj;
			String name = data.getName();
			String _type = data.getType();
			String msg = data.getMessage();
			System.out.println("documentEventListener notify now."+name+_type+msg+this.toString());
		}
	}
}

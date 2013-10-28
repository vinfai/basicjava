package com.vinfai.basic.oxm.jaxb2.sample1.adpater;

import javax.xml.bind.annotation.XmlElement;

import com.vinfai.basic.oxm.jaxb2.sample1.MyAdress;

/**
 * Map translate
 * @author vinfai
 *
 */
public class MyElement {

	private String key;
	
	private Object value;
	@XmlElement
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	@XmlElement
	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	public MyElement(){
		
	}// Required by JAXB
	public MyElement(String key, Object value) {
		this.key = key;
		this.value = value;
	}
	
	
	
}

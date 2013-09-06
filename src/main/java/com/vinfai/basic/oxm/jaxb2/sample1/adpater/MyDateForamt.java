package com.vinfai.basic.oxm.jaxb2.sample1.adpater;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MyDateForamt extends XmlAdapter<String, Date>{

	public static String FORMAT_STYLE = "yyyy-MM-dd";
	@Override
	public String marshal(Date v) throws Exception {
		SimpleDateFormat f = new SimpleDateFormat(FORMAT_STYLE);
		return f.format(v);
	}

	@Override
	public Date unmarshal(String v) throws Exception {
		SimpleDateFormat f = new SimpleDateFormat(FORMAT_STYLE);
		return f.parse(v);
	}
	
}

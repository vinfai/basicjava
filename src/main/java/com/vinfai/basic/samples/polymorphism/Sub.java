package com.vinfai.basic.samples.polymorphism;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class Sub extends Base {
	
	int i = 10;
	
//	@Override
//	public void dosomething(Map map){
//		System.out.println(" sub.java Map ...");
//	}
	
	public void dosomething(String str){
		System.out.println(" sub.java str ...");
	}
	
	public void dosomething(HashMap map){
		System.out.println(" sub.java hashMap  ...");
	}
}

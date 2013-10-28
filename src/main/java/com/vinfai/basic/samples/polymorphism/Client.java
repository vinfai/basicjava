package com.vinfai.basic.samples.polymorphism;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class Client {

	public static void main(String[] args){
		Base b = new Sub();
		HashMap map = new HashMap();
		b.dosomething(map);
	}
}

package com.vinfai.basic.scjp;

public class Sub extends SuperClazz{
	
	public Sub(String text){
		super(text);
		i = 2;
	}
	
	public static void main(String[] args){
		Sub sub = new Sub("Hello");
		System.out.println(sub.i);
	}
	
	Double method(byte x,double y){
		return (short)x/y*2;
	}
	
}

class SuperClazz{
	
	int i = 0;
	public SuperClazz(String text){
		i = 1;
	}
}
package com.vinfai.basic.scjp;

public class BasicTest {
	
	public static void main(String[] args){
		/*Integer i = new Integer(42);
		Long l =  new Long(42);
		Double d = new Double(42.0);
		//System.out.println(i==l);
		System.out.println(i.equals(l));
		System.out.println(d.equals(i));
		System.out.println(i.equals(42));
		*/
		
		//位运算符操作
		/*int  i = 0xFFFFFFF1; 
		int  j = ~i;
		System.out.println(j);*/
		
		methodA(0);
		System.out.println(j);
	}
	
	private static int j = 0 ;
	
	public static boolean methodB(int k){
		j +=k;
		return true;
	}
	public static boolean methodA(int i){
		boolean b;
		b = i<10|methodB(4);
		b = i<10||methodB(10);
		
		return b;
	}
}

package com.vinfai.basic.bitwiseoperator;

public class BitwiseOperator {

	public static void main(String[] args){
		
		swap(10, 20);
		
		//XOR
		System.out.println(6^3);
		// AND
		System.out.println(6&3); //都为1，则1；其他0
		// OR
		System.out.println(6|3); //一个为1，则1
		//NOT
		System.out.println(~(-6));
		
		System.out.println(Integer.toBinaryString(5));
		System.out.println(Integer.toBinaryString(-5));
		System.out.println(Long.toHexString(5));
		
		//符号位移(负数补1) 、无符号位移>>> (补0)
		
		//2进制转10进制
		boolean[] test = new boolean[3];
		Boolean b = new Boolean("1");
		System.out.println(b);
		
		String s ="2";
		System.out.println("s="+s);
		
		
		
		
	}
	
	
	//交换值
	public static void swap(int a,int b){
		//XOR 不同为 1，相同为0
		a = a^b; //中间值
		b = a^b; //中间值^b 得到a,b变成了a
		a = a^b; //中间值^a的值(b) 得到b 赋值给a
		System.out.println("swap: a->"+a+";"+" b -> "+b);
	}
	
}

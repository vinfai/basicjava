package com.vinfai.basic.bitwiseoperator;

import java.net.ServerSocket;
import java.util.ServiceLoader;

public class ToBinaryString {

	public static void main(String[] args){
		String str = IntegerToBinaryString(128);
		System.out.println(str);
	}
	
	public static String IntegerToBinaryString(int i){
		int shift = 1; //2进制位移
		char[] vals = new char[32];
		int pos = 32;
		int radix = 1<<shift;
		int mask = radix -1;
		do{
			vals[--pos] = digits[i&mask];
			i>>>= shift;
		}while(i!=0);
		
		for(int k=31;k>=0;k--){
			System.out.print(vals[k]+" ");
		}
		System.out.println();
		int count = 32-pos;
		char[] newchar = new char[count];
		System.arraycopy(vals, pos, newchar, 0, count);
		
		String str = new String(newchar);
		
		return str;
	}
	
	
	
	
	
	private static String toUnsignedString(int i, int shift) {
		char[] buf = new char[32];
		int charPos = 32;
		int radix = 1 << shift;
		int mask = radix - 1;
		do {
		    buf[--charPos] = digits[i & mask];
		    i >>>= shift;
		} while (i != 0);

		return new String(buf, charPos, (32 - charPos));
	    }

	final static char[] digits = {
		'0' , '1' , '2' , '3' , '4' , '5' ,
		'6' , '7' , '8' , '9' , 'a' , 'b' ,
		'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
		'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
		'o' , 'p' , 'q' , 'r' , 's' , 't' ,
		'u' , 'v' , 'w' , 'x' , 'y' , 'z'
    };

	
	public void toInteger(String binaryStr){
		//a1+2*a2+2^2*a3+;
		char[] vals = binaryStr.toCharArray();
		
		for(int i =0;i<vals.length;i++){
//			ServerSocket ss = new Servers
		}
		
	}
	
}

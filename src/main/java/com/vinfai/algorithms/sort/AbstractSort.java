package com.vinfai.algorithms.sort;

public abstract class AbstractSort {
	
	public static void doPrint(int[] arr,int round){
		System.out.print("round "+round+" : ");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+",");
		}
		System.out.println();
	}
}

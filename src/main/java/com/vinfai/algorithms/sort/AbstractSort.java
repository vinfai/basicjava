package com.vinfai.algorithms.sort;

public abstract class AbstractSort {
	
	public static void doPrint(int[] arr,int round){
		System.out.print("round "+round+" : ");
		for(int i=0;i<arr.length;i++){
			
			if(i<arr.length-1){
				System.out.print(arr[i]+",");
			}else{
				System.out.print(arr[i]);
			}
			
		}
		System.out.println();
	}
}

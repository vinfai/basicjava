/**
 * 
 */
package com.vinfai.algorithms.sort;

/**
 * 基本排序：冒泡排序、选择排序
 * 
 * @author vinfai
 * 
 */
public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr =  new int[]{10,9,87,32,55,26,78,2};
		sort(arr);
	}
	
	public static void sort(int[] arr){
		int size = arr.length;
		for(int i=0;i<size;i++){
			//compare and get the first obj which is less than source.
			//int minVal = arr[i];
			int minIndex = i;
			for(int j=i+1;j<size;j++){
				int target = arr[j];
				if(arr[i]>target){
					//swap each other
					//int temp = target;
					//arr[j] = minVal;
					//arr[i] = temp;
					minIndex = j;
					//minVal = target;
					//在循环内交换 bubbleSort：冒泡排序
					//swap(arr, i, minIndex);
				}
			}
			//end inner loop ; swap the minVal selectedSort:选择排序
			swap(arr, i, minIndex);
			System.out.println("minIndex:"+minIndex);
			doPrint(arr, i);
		}
	}

	public static void swap(int[] arr,int i,int minIndex){
		int temp = arr[minIndex];
		arr[minIndex] = arr[i];
		arr[i] = temp;
	}
	public static void doPrint(int[] arr,int round){
		System.out.print("around "+round+" : ");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+",");
		}
		System.out.println();
	}
}

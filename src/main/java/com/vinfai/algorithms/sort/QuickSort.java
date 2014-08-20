package com.vinfai.algorithms.sort;
/**
 * http://developer.51cto.com/art/201403/430986.htm
 * @author vinfai85@gmail.com
 */
public class QuickSort{

	public static void main(String[] args) {
		int[] arr = new int[]{6,1,2,9,5,4,3,10,7,8};
		sort(arr, 0, 9);
	}
	
	public static void sort(int[] arr,int startIndex,int endIndex){
		int i = startIndex;
		int j = endIndex;
		int pos = arr[i]; //坐标
		if(startIndex>=endIndex){
			return ;
		}
		while(i!=j){
			//右侧开始找起，直到找到比基准值小的元素停止，其中i<j;eg:3 j=6
			while(i<j&&pos<=arr[j]){
				j--;
			}
			//再从左侧开始找，直到找到比基准值大的元素停止，其中i<j;eg:9 i=3
			while(i<j&&pos>=arr[i]){
				i++;
			}
			if(i<j){
				//swap
				System.out.println("pos i="+i+" swap with j="+j+";"+arr[i]+"<-->"+arr[j]);
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		//i==j时，基数归位,将基准位置的值同停留位置i交换
		System.out.println("i="+i+";&j="+j);
		arr[startIndex] = arr[i];
		arr[i] = pos;
		for(int k=0;k<arr.length;k++){
			System.out.print(arr[k]+";");
		}
		System.out.println("--newline--");
		sort(arr, startIndex, i-1);
		sort(arr, i+1, endIndex);
		
	
	}
}

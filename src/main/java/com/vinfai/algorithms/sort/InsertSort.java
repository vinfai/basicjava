package com.vinfai.algorithms.sort;
/**
 * 插入排序
 * 将队列分为有序R[i]和无序R[j],然后从无序的队列中取R[j]插入到R[i]的有序队列中
 * 一种查找比较操作和记录移动操作交替地进行的方法。
具体做法：
    　将待插入记录R[i]的关键字从右向左依次与有序区中记录R[j](j=i-1，i-2，…，1)的关键字进行比较：
    　①若R[j]的关键字大于R[i]的关键字，则将R[j]后移一个位置；
        ②若R[j]的关键字小于或等于R[i]的关键字，则查找过程结束，j+1即为R[i]的插入位置。
    　关键字比R[i]的关键字大的记录均已后移，所以j+1的位置已经腾空，只要将R[i]直接插入此位置即可完成一趟直接插入排序。
    
 * @author vinfai
 *
 */
public class InsertSort {
	
	public static void main(String[] args){
		int[] arr = {10,5,87,32,88,26,78,2};
		sort(arr);
	}
	//降序排列
	public static void sort(int[] arr){
		//1.add sentinel
		
		//2.从第二个元素开始，和第一个元素比较
		for(int i=1;i<arr.length;i++){
			int pos = arr[i];
			int posIndex = i;
			
			//将pos值同R[0..i-1]比较，插入到相应的位置
			while(posIndex>0&&pos<=arr[posIndex-1]){
				arr[posIndex] = arr[posIndex-1];
				posIndex -- ;
			}
			arr[posIndex] = pos;//最后将哨兵位置的值放到腾空位置
			doPrint(arr, i);
		}
		
	}
	
	public static void doPrint(int[] arr,int round){
		System.out.print("round "+round+" : ");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+",");
		}
		System.out.println();
	}
}

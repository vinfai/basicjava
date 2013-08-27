package com.vinfai.algorithms.sort;
/**
 * 
 * Shell sort : 分组插入排序
 *  基本思想：
　                先取一个小于n的整数d1作为第一个增量，把文件的全部记录分成d1个组。所有距离为dl的倍数的记录放在同一个组中。
	先在各组内进行直接插人排序；
	然后，取第二个增量d2<d1重复上述的分组和排序，直至所取的增量dt=1(dt<dt-l<…<d2<d1)，
	即所有记录放在同一组中进行直接插入排序为止。
    　 该方法实质上是一种分组插入方法。
 * @author vinfai
 *
 */
public class ShellSort extends AbstractSort{

	public static void main(String[] args) {
		int[] arr = {10,5,87,32,88,26,78,2};
		shellSort(arr);
	}
	
	public static void shellSort(int[] arr){
		int len = arr.length;
		int d  = len/2; //增量
		int k  = 0;
		while(d>=1){
			//这里就是一个arr中以d间隔的元素组成的 数组 进行插入排序;
			for(int i=d;i<arr.length;i++){//0-9
				int j = i-d; //新队列 中的上一个元素;from zero ; if i=5; 0,5;1,6;2,7,3,8;4,9
				int temp = arr[i];
				while(j>=0&&arr[j]>temp){
					arr[j+d] = arr[j]; //往后移动
					j = j - d;//j指向前一个元素
				}
//				arr[j+d] = temp;
				arr[j+d] = temp;//循环中可能是负数;
			}
			d = d/2;
			++k;
			doPrint(arr, k);
		}
	}
	

}

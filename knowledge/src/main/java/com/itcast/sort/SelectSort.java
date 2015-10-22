package com.itcast.sort;

public class SelectSort {
	public static void main(String[] args){
		int[] arr = {3,1,6,2,5};
		for(int i=0;i<arr.length-1;i++){
			
			int min = i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[min] > arr[j]){
					min = j;
				}
			}
			if(min != i){
				int temp = 0;
				temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i] + " ");
		}
	}
}

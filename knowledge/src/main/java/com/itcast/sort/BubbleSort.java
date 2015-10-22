package com.itcast.sort;

public class BubbleSort {

	public static void main(String[] args) {
		
		int[] arr = {3,1,6,2,5};
		int temp = 0;
		for(int i=arr.length-1;i>0;i--){
			for(int j=0;j<i;j++){
				if(arr[j] > arr[j+1]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		for( int i=0;i<arr.length;i++){
			System.out.print(arr[i] + " " );
		}
	}

}

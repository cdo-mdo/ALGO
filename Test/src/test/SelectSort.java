package test;

import java.util.Arrays;

public class SelectSort {
	public static void sort(int[] arr) {
		if (arr.length <= 1) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			int min = Integer.MAX_VALUE;
			int minIndex = 0;
			for (int j = i; j < arr.length; j++) {
				if (min > arr[j]) {
					min = arr[j];
					minIndex = j;
				}
			}
			arr[minIndex] = arr[i];
			arr[i] = min;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {7, 3, 1, 4, 9, 6};
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}

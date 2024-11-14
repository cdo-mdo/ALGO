package labw2d3.assignment_3_1;

import java.util.Arrays;

public class QuickSort {
	public static void quickSort(int[] arr, int start, int stop) {
		int i, j;    // these are the moving pointers
		
		if (stop <= start) {
			return;
		} else {
			int pivotPos = Common.medianOfThree(arr, start, stop);
			Common.swap(arr, pivotPos, stop);
			int pivot = arr[stop];
			i = start;
			j = stop - 1;
			while (true) {
				while (i <= j && arr[i] < pivot) {
					i++;
				}
				while (i <= j && arr[j] > pivot) {
					j--;
				}
				if (i <= j) {
					Common.swap(arr, i++, j--);
				} else {
					break;
				}
			}
			Common.swap(arr, stop, i);
			quickSort(arr, start, i - 1);
			quickSort(arr, i + 1, stop);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {10, 7, 1, 8, 2, 6, 4, 3, 9, 8, 2};
		System.out.println(Arrays.toString(arr));
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
		System.out.println(QuickSelect.quickSelect(arr, 0, arr.length - 1, 3));
	}
}

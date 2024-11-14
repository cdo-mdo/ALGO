package labw2d3.assignment_3_1;

import java.util.Arrays;

public class NewQuickSort {
	public static void newQuickSort(int[] arr, int start, int stop) {
		int i, j;
		
		if (stop <= start) {
			return;
		} else {
			int pivot = QuickSelect.quickSelect(arr, start, stop, 1);
			int index;
			for (index = 0; index < arr.length; index++) {
				if (arr[index] == pivot) {
					break;
				}
			}
			Common.swap(arr, index, stop);
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
			newQuickSort(arr, start, i - 1);
			newQuickSort(arr, i + 1, stop);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 10, 7, 1, 8, 2, 6, 4, 3, 9, 8, 2 };
		System.out.println(Arrays.toString(arr));
		newQuickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}

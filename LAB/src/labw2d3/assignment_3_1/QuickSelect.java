package labw2d3.assignment_3_1;

import java.util.Arrays;

public class QuickSelect {
	public static int quickSelect(int[] arr, int start, int stop, int k) {
		if (start > stop) {
			return arr[start];
		}

		int p = Common.medianOfThree(arr, start, stop);
		Common.swap(arr, p, stop);
		int i = start;
		int j = stop - 1;

		while (true) {
			while (i <= j && arr[i] < arr[stop]) {
				i++;
			}
			while (i <= j && arr[j] > arr[stop]) {
				j--;
			}
			if (i <= j) {
				Common.swap(arr, i++, j--);
			} else {
				break;
			}
		}
		Common.swap(arr, i, stop); // swap with the bigger one only

		int sizeL = i - start;
		int sizeE = 1;

		if (k > sizeL && k <= sizeL + sizeE) {
			return arr[i];
		} else if (k <= sizeL) {
			return quickSelect(arr, start, i - 1, k);
		} else {
			return quickSelect(arr, i + 1, stop, k - sizeL - sizeE);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 10, 7, 1, 8, 2, 6, 4, 3, 9, 8, 2 };
		System.out.println(Arrays.toString(arr));
//		QuickSort.quickSort(arr, 0, arr.length - 1);
//		System.out.println(Arrays.toString(arr));
		System.out.println(QuickSelect.quickSelect(arr, 0, arr.length - 1, 1));
		System.out.println(QuickSelect.quickSelect(arr, 0, arr.length - 1, 2));
		System.out.println(QuickSelect.quickSelect(arr, 0, arr.length - 1, 3));
		System.out.println(QuickSelect.quickSelect(arr, 0, arr.length - 1, 4));
		System.out.println(QuickSelect.quickSelect(arr, 0, arr.length - 1, 5));
		System.out.println(QuickSelect.quickSelect(arr, 0, arr.length - 1, 6));
		System.out.println(QuickSelect.quickSelect(arr, 0, arr.length - 1, 7));
		System.out.println(QuickSelect.quickSelect(arr, 0, arr.length - 1, 8));
		System.out.println(QuickSelect.quickSelect(arr, 0, arr.length - 1, 9));
		System.out.println(QuickSelect.quickSelect(arr, 0, arr.length - 1, 10));
		System.out.println(QuickSelect.quickSelect(arr, 0, arr.length - 1, 11));
	}

}

package labw2d3.assignment_3_1;

public class Common {
	public static int medianOfThree(int[] arr, int start, int stop) {
		int mean = (start + stop)/2;
		if (arr[start] < arr[stop]) {
			if (arr[mean] < arr[start]) {
				return start;
			}
			else {
				if (arr[mean] < arr[stop]) {
					return mean;
				}
				else {
					return stop;
				}
			}
		}
		else {
			if (arr[mean] < arr[stop]) {
				return stop;
			}
			else {
				if (arr[mean] < arr[start]) {
					return mean;
				}
				else {
					return start;
				}
			}
		}
	}
	
	public static void swap(int[] arr, int pivotPos, int stop) {
		int temp = arr[pivotPos];
		arr[pivotPos] = arr[stop];
		arr[stop] = temp;
	}
}

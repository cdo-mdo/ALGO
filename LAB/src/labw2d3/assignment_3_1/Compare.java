package labw2d3.assignment_3_1;

public class Compare {
	private static int random() {
		return (int)(Math.random()*25000);
	}
	
	private static int[] generateNums(int n) {
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = random();
		}
		return res;
	}
	
	private static double measureQuickSort(int num) {
		int[] arr = generateNums(num);
		long startTime = System.nanoTime();
		QuickSort.quickSort(arr, 0, arr.length - 1);
		long elapseTime = System.nanoTime() - startTime;
		return elapseTime/1_000;
	}
	
	private static double measureQuickSort(int[] arr) {
		long startTime = System.nanoTime();
		QuickSort.quickSort(arr, 0, arr.length - 1);
		long elapseTime = System.nanoTime() - startTime;
		return elapseTime/1_000;
	}
	
	private static double measureNewQuickSort(int num) {
		int[] arr = generateNums(num);
		long startTime = System.nanoTime();
		NewQuickSort.newQuickSort(arr, 0, arr.length - 1);
		long elapseTime = System.nanoTime() - startTime;
		return elapseTime/1_000;
	}
	
	private static double measureNewQuickSort(int[] arr) {
		long startTime = System.nanoTime();
		NewQuickSort.newQuickSort(arr, 0, arr.length - 1);
		long elapseTime = System.nanoTime() - startTime;
		return elapseTime/1_000;
	}
	
	public static void main(String[] args) {
		double[] measureQuickSort = new double[20];
		double[] measureNewQuickSort = new double[20];
		
		for (int i = 0; i < 20; i++) {
			int num = 1000 + 1000*i;
			int[] arr = generateNums(num);
			measureQuickSort[i] = measureQuickSort(arr);
			measureNewQuickSort[i] = measureNewQuickSort(arr);
 		}
		
		for (int i = 0; i < 20; i++) {
			System.out.print(measureQuickSort[i] + ";");
		}
		System.out.println();
		for (int i = 0; i < 20; i++) {
			System.out.print(measureNewQuickSort[i] + ";");
		}
		
	}

}

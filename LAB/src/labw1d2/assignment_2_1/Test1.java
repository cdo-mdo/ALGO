package labw1d2.assignment_2_1;

public class Test1 {
	public void findMax(int[] arr) {
		int max = arr[0];
		int maxPosition = -1;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
				maxPosition = i;
			}
		}
		
		int secondMax = arr[0];
		int secondMaxPosition = -1;
		for (int i = 0; i < arr.length; i++) {
			if (secondMax < arr[i] && 
				i != maxPosition) {
				secondMax = arr[i];
				secondMaxPosition = i;
			}
		}
		
		int thirdMax = arr[0];
		int thirdMaxPosition = -1;
		for (int i = 0; i < arr.length; i++) {
			if (thirdMax < arr[i] &&
				i != maxPosition &&
				i != secondMaxPosition) {
				thirdMax = arr[i];
				thirdMaxPosition = i;
			}
		}
		
		System.out.println("max = " + max + " at postion = " + maxPosition);
		System.out.println("second max = " + secondMax + " at postion = " + secondMaxPosition);
		System.out.println("third max = " + thirdMax + " at postion = " + thirdMaxPosition);
	}
	
	public static void main(String[] args) {
		Test1 test = new Test1();
		test.findMax(new int[] {7, 20, 18, 4, 20, 13, 20 , 3});
		
	}
}

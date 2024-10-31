package labw1d2.assignment_2_1;

public class Test2 {
	public void findMax(int[] arr) {
		int max = arr[0];
		int maxPosition = -1;
		int secondMax = arr[0];
		int secondMaxPosition = -1;
		int thirdMax = arr[0];
		int thirdMaxPosition = -1;

		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				thirdMax = secondMax;
				thirdMaxPosition = secondMaxPosition;
				secondMax = max;
				secondMaxPosition = maxPosition;
				max = arr[i];
				maxPosition = i;
			} else if (secondMax < arr[i]) {
					thirdMax = secondMax;
					thirdMaxPosition = secondMaxPosition;
					secondMax = arr[i];
					secondMaxPosition = i;
			} else if (thirdMax < arr[i]) {
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
		
		test.findMax(new int[] {7, 20, 18, 4, 25, 13, 23 , 3});
		
	}
}

package test;

public class Test2 {
	public int countValidSelections(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int sumLeft = 0; 
        int sumRight = 0;
        int count0 = 0;
        while (left <= right) {
            if (sumLeft == sumRight) {
                if ((nums[left] == nums[right]) || Math.abs(nums[left] - nums[right]) == 1) {
                    count0 += 2;
                    left++;
                    right--;
                }
                if (nums[left] != 0) {
                    sumLeft += nums[left];
                    left++;
                }
                if (nums[right] != 0) {
                    sumRight += nums[right];
                    right--;
                }  
            }
            else if (sumLeft < sumRight) {
                sumLeft += nums[left];
                left++;
            }
            else {
                sumRight += nums[right];
                right--;
            }
        }
        return count0;
	}
	
	public static void main(String[] args) {
		Test2 test2 = new Test2();
//		System.out.println(test2.countValidSelections(new int[] {1, 0, 2, 0, 3}));
		System.out.println(test2.countValidSelections(new int[] {16, 13, 10, 0, 0, 0, 10, 6, 7, 8, 7}));
	}
}

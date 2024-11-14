package test.twoadjacent;

public class TwoAdjacent {
	public static boolean hasIncreasingSubarrays(int[] nums, int k) {
		int i = 0;
		while (i < nums.length - k - 1) {
			if (isIncreasing(nums, i, k)) {
				if (isIncreasing(nums, i + k, k)) {
					return true;
				}
			}
			i++;
		}
		return false;
	}
	
	private static boolean isIncreasing(int[] nums, int pos, int k) {
		for (int i = pos; i < pos + k - 1; i++) {
			if (nums[i] >= nums[i + 1]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] nums = {2, 5, 7, 8, 9, 2, 3, 4, 3, 1};
		System.out.println(hasIncreasingSubarrays(nums, 3));
		
		int[] nums1 = {1, 2, 3, 4, 4, 4, 4, 5, 6, 7};
		System.out.println(hasIncreasingSubarrays(nums1, 5));
	}
}

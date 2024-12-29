package leetcode.twoadjacent;

import java.util.Arrays;
import java.util.List;

public class TwoAdjacent2 {
	public static boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
		if (nums.size() < 2*k) {
			return false;
		}
		
		for (int i = 0; i <= nums.size() - 2*k; i++) {
			if (isSubIncreasing(nums, i, i + k) && isSubIncreasing(nums, i + k, i + 2*k)) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isSubIncreasing(List<Integer> nums, int start, int end) {
		for (int i = start + 1; i < end; i++) {
			if (nums.get(i) <= nums.get(i - 1)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(2, 5, 7, 8, 9, 2, 3, 4, 3, 1);
		System.out.println(hasIncreasingSubarrays(nums, 3));
		
		List<Integer> nums1 = Arrays.asList(1, 2, 3, 4, 4, 4, 4, 5, 6, 7);
		System.out.println(hasIncreasingSubarrays(nums1, 5));
		
		List<Integer> nums2 = Arrays.asList(-15, 9);
		System.out.println(hasIncreasingSubarrays(nums2, 1));
		
		List<Integer> nums3 = Arrays.asList(-15, 3, 16, 0);
		System.out.println(hasIncreasingSubarrays(nums3, 2));
	}
}

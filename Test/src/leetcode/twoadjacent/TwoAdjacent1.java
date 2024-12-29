package leetcode.twoadjacent;

import java.util.Arrays;
import java.util.List;

public class TwoAdjacent1 {
	public static boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        if (k == 1) {
            return true;
        }

        int n = nums.size();
        boolean previousIncreasing = false;  // Track if the previous subarray was strictly increasing
        
        for (int i = 0; i <= n - k; i++) {
            if (isIncreasing(nums, i, k)) {
                if (previousIncreasing) {
                    return true;
                }
                previousIncreasing = true;
                i += k - 1;  // Move to the start of the next subarray to ensure adjacency
            } else {
                previousIncreasing = false;
            }
        }

        return false;
    }
    
    private static boolean isIncreasing(List<Integer> nums, int pos, int k) {
        for (int i = pos; i < pos + k - 1; i++) {
            if (nums.get(i) >= nums.get(i + 1)) {
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
	}
}

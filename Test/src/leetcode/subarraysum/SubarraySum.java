package test.subarraysum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
	public int subarraySum(int[] nums, int k) {
		int[] sums = new int[nums.length];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			sums[i] = sum;
		}
		
		Map<Integer, Integer> matches = new HashMap<>();
		int count = 0;
		matches.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			if (matches.containsKey(sums[i] - k)) {
				count += matches.get(sums[i] - k);
			}
			if (matches.containsKey(sums[i])) {
				matches.put(sums[i], matches.get(sums[i]).intValue() + 1);
			}
			else {
				matches.put(sums[i], 1);
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		SubarraySum solution = new SubarraySum();
//		System.out.println(solution.subarraySum(new int[] {1, 1, 1}, 2));
//		System.out.println(solution.subarraySum(new int[] {1, 2, 3}, 3));
//		System.out.println(solution.subarraySum(new int[] {-1, -1, 1}, 0));
//		System.out.println(solution.subarraySum(new int[] {1, 2, 1, 2, 1, 2}, 3));
		System.out.println(solution.subarraySum(new int[] {1, -1, 0}, 0));
		
		
	}
}

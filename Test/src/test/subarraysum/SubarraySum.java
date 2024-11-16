package test.subarraysum;

import java.util.HashSet;
import java.util.Set;

public class SubarraySum {
	public int subarraySum(int[] nums, int k) {
		int[] sums = new int[nums.length];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			sums[i] = sum;
			System.out.println("DEBUG-0 " + "sums[" + i + "] = " + sum);
		}
		
		Set<Integer> sets = new HashSet<>();
		sets.add(k);
		for (int i = 0; i < nums.length - 1; i++) {
			sets.add(sums[i] + k);
		}
		System.out.println("sets = " + sets.toString());
		
		int count = 0;
		if (sums[0] == k) {
			count++;
		}
			
		for (int i = 1; i < nums.length; i++) {
			if (sets.contains(sums[i])) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		SubarraySum solution = new SubarraySum();
//		System.out.println(solution.subarraySum(new int[] {1, 1, 1}, 2));
//		System.out.println(solution.subarraySum(new int[] {1, 2, 3}, 3));
		System.out.println(solution.subarraySum(new int[] {-1, -1, 1}, 0));
		
	}
}

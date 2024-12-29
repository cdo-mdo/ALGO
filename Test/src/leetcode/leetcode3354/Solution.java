package leetcode.leetcode3354;

public class Solution {
	public int countValidSelections(int[] nums) {
		int[] sums = new int[nums.length];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			sums[i] = sum;
		}
		
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				if (sums[i] == sums[nums.length - 1] - sums[i]) {
					count += 2;
				}
				else if (Math.abs(sums[nums.length - 1] - 2*sums[i]) == 1) {
					count++;
				}
			}
		}
		
		return count;
	}
}

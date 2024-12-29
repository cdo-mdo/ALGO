package leetcode.leetcode3355;

public class Solution {
	public boolean isZeroArray(int[] nums, int[][] queries) {
		int[] decrements = new int[nums.length];
		for (int i = 0; i < decrements.length; i++) {
			decrements[i] = 0;
		}
		for (int i = 0; i < queries.length; i++) {
			decrements[queries[i][0]] += 1;
			if (queries[i][1] + 1 < decrements.length) {
				decrements[queries[i][1] + 1] += -1;
			}
		}
		int prefixSum = 0;
		for (int i = 0; i < nums.length; i++) {
			prefixSum += decrements[i];
			if (nums[i] > prefixSum) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isZeroArray(new int[] {2}, new int[][] {{0, 0}, {0, 0}}));
	}
}

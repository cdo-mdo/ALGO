package labw1d4.assignment_4_1;

import java.util.ArrayList;
import java.util.List;

public class SubsetSumOne {
	public static List<Integer> getOne(int[] nums, int target) {
		int n = nums.length;
		boolean[][] dp = new boolean[n + 1][target + 1];
		
		for (int i = 0; i <= n; i++) {
			dp[i][0] = true;
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= target; j++) {
				if (nums[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		
		if (dp[n][target] == false) {
			return new ArrayList<>();
		}
		
		List<Integer> res = new ArrayList<>();
		int i = n; int j = target;
		System.out.println("i = " + i + " j = " + j);
		System.out.println(dp[n - 1][j]);
		System.out.println(dp[n][j]);
		while (i > 0 && j > 0) {
			if (!dp[i - 1][j]) {
				res.add(nums[i - 1]);
				j -= nums[i - 1];
			}
			i--;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {2, 3, 5};
		int target = 8;
		
		List<Integer> res = SubsetSumOne.getOne(nums, target);
		System.out.println(res.toString());
	}
}

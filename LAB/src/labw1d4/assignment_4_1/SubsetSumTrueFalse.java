package labw1d4.assignment_4_1;

public class SubsetSumTrueFalse {

	// Function to check if a subset with the given sum exist
	public static boolean isSubsetSum(int[] set, int target) {
		int n = set.length;
		
		// Create a 2D boolean array to store the results
		boolean[][] dp = new boolean[n + 1][target + 1];
		
		// Initialize the DP array
		for (int i = 0; i <= n; i++) {
			dp[i][0] = true;
 		}
		
		// Fill the DP array using the recurrence relation
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= target; j++) {
				if (set[i - 1] <= j) {
					// Include the current element or exclude it
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - set[i - 1]];
 				} else {
 					// Exclude the current element
 					dp[i][j] = dp[i - 1][j];
 				}
			}
		}
		
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < target + 1; j++) {
				System.out.print(dp[i][j] + ", ");
			}
			System.out.println();
		}
		
		return dp[n][target];
	}
	
	public static void main(String[] args) {
		int[] set = {2, 3, 5};
		int target = 8;
		
		System.out.println(SubsetSumTrueFalse.isSubsetSum(set, target));
		
	}
}

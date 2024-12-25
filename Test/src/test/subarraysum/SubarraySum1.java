package test.subarraysum;

public class SubarraySum1 {
	public int subarraySum(int[] nums, int k) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if (sum == k) {
					count++;
					break;
				}
				if (sum > k) {
					break;
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		SubarraySum1 solution = new SubarraySum1();
		System.out.println(solution.subarraySum(new int[] {1, 1, 1}, 2));
		System.out.println(solution.subarraySum(new int[] {1, 2, 3}, 3));
		System.out.println(solution.subarraySum(new int[] {-1, -1, 1}, 0));
	}
}

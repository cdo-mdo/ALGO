package test;

import java.util.ArrayList;
import java.util.List;

public class SubarraySum {
	public static int subarraySum(int[] nums, int k) {
        List<Integer> complements = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k == nums[i]) {
                count++;
            }
            else {
                if (complements.contains(nums[i])) {
                    count++;
                    complements.remove(Integer.valueOf(nums[i]));
                }
                else {
                    int complement = k - nums[i];
                    complements.add(complement);
                }
            }
        }
        return count;
    }
	
	public static void main(String[] args) {
		
		System.out.println(subarraySum(new int[] {1, 1, 1}, 2));
	}
}

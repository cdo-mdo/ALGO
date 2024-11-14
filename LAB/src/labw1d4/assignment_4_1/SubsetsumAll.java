package labw1d4.assignment_4_1;

import java.util.ArrayList;
import java.util.List;

public class SubsetsumAll {
	// Function to find all subsets that sum up to the target
	public static void findSubsets(int[] nums, int target) {
	    List<Integer> currentSubset = new ArrayList<>();
	    findSubsetsRecursive(nums, target, 0, currentSubset);
	}

	private static void findSubsetsRecursive(int[] nums, int target, int index, List<Integer> currentSubset) {
	    // Base case: If target is 0, we found a valid subset
	    if (target == 0) {
	        System.out.println(currentSubset);
	        return;
	    }

	    // If the target becomes negative or index reaches the end of the list, return
	    if (target < 0 || index >= nums.length) {
	        return;
	    }

	    // Include the current number and recurse
	    currentSubset.add(nums[index]);
	    findSubsetsRecursive(nums, target - nums[index], index + 1, currentSubset);

        // Exclude the current number and recurse
        currentSubset.remove(currentSubset.size() - 1);
	    findSubsetsRecursive(nums, target, index + 1, currentSubset);
	}

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 7};
        int target = 7;
        findSubsets(nums, target);
    }
}


package test.leetcode_169;

public class Solution1 {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            }
            else {
                if (candidate == nums[i]) {
                    count++;
                }
                else {
                    count--;
                }
            }
        }
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            }
        }
        if (count >= nums.length / 2) {
            return candidate;
        }
        else {
            return -1;
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(new int[] {3, 2, 3}));
        System.out.println(solution.majorityElement(new int[] {2, 2, 1, 1, 1, 2, 2}));
        System.out.println(solution.majorityElement(new int[] {3, 3, 4}));
    }
}

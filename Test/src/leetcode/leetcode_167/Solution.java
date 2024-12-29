package leetcode.leetcode_167;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = 0;
        res[1] = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }
            else if (nums[left] + nums[right] > target) {
                right--;
            }
            else {
                left++;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.twoSum(new int[] {2, 7, 11, 15}, 9);
        System.out.println(res[0] + ", " + res[1]);
    }
}

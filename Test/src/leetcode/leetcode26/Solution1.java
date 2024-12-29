package leetcode.leetcode26;

public class Solution1 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.removeDuplicates(new int[] {0, 0, 1, 1, 2, 2, 3, 3, 4}));
    }
}

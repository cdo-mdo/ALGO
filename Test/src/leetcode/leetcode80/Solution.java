package test.leetcode80;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int i = 2;
        int write = 2;
        for (i = 2; i < nums.length; i++) {
            if (nums[i] != nums[write - 2]) {
                nums[write] = nums[i];
                System.out.println("i = " + i + " write = " + write);
                write++;
            }
            
        }
        return write;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(new int[] {1, 1, 1, 2, 2, 3}));
        System.out.println(solution.removeDuplicates(new int[] {0, 0, 1, 1, 1, 1, 2, 3, 3}));
//        System.out.println(solution.removeDuplicates(new int[] {1, 1, 1}));
//        System.out.println(solution.removeDuplicates(new int[] {1, 2, 2}));
//        System.out.println(solution.removeDuplicates(new int[] {1, 2, 3}));
//        System.out.println(solution.removeDuplicates(new int[] {1, 1, 2, 2}));
        
    }
}

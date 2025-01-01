package leetcode.leetcode27;

public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            while (left < nums.length && nums[left] != val) {
                left++;
            }
            while (right >= 0 && nums[right] == val) {
                right--;
            }
            System.out.println("left = " + left);
            System.out.println("right = " + right);
            if (left >= right) {
                break;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            
        }
        return left;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        Solution solution = new Solution();
//        System.out.println(solution.removeElement(nums, 2));
//        System.out.println(solution.removeElement(new int[] {0, 1, 2, 2, 3, 0, 4, 2}, 2));
        System.out.println(solution.removeElement(new int[] {1}, 1));
    }
}

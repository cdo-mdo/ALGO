package leetcode.leetcode_189;

public class Solution2 {
    public void rotate(int[] nums, int k) {
        // reverse the upper array
        int left = nums.length - k % nums.length;
        int right = nums.length - 1;
        reverse(nums, left, right);
        
        // reverse the lower array
        left = 0;
        right = nums.length - k % nums.length - 1;
        reverse(nums, left, right);
        
        // reverse whole array
        left = 0;
        right = nums.length - 1;
        reverse(nums, left, right);
    }
    
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
//            System.out.println("swap " + left + " and " + right);
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    
    private static void printArray(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1) {
                System.out.print(nums[i] + ", ");
            }
            else {
                System.out.print(nums[i]);
            }
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        
        printArray(nums);
        solution.rotate(nums, 3);
        printArray(nums);
        
        int nums1[] = {-1};
        printArray(nums1);
        solution.rotate(nums1, 2);
        printArray(nums1);
    }
}

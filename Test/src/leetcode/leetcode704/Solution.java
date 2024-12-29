package test.leetcode704;

public class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = (start + end)/2;
            System.out.println("middle = " + middle);
            if (nums[middle] == target) {
                return middle;
            }
            if (target < nums[middle]) {
                end = middle - 1;
            }
            else {
                start = middle + 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.search(new int[] {-1,0,3,5,9,12}, 9));
        System.out.println(solution.search(new int[] {5}, 5));
    }
}

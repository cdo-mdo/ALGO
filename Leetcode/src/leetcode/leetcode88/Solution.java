package leetcode.leetcode88;

import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int index1 = m - 1;
        int index2 = n - 1;
        while (true) {
            if (nums1[index1] < nums2[index2]) {
                nums1[index] = nums2[index2];
                index2--;
            }
            else {
                nums1[index] = nums1[index1];
                index1--;
            }
            index--;
            if (index1 < 0) {
                for (int i = 0; i <= index2; i++) {
                    nums1[i] = nums2[i];
                }
                break;
            }
            if (index2 < 0) {
                break;
            }
        }
        return;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        
        Solution solution = new Solution();
        solution.merge(nums1, 3, nums2, 3);
        
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + ", ");
        }
        
    }
}

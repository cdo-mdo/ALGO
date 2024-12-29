package test.contest425.test1;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        if (l > nums.size() || r > nums.size()) {
            return -1;
        }
        
        int[] prefixSum = new int[nums.size()];
        int sum = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            sum += nums.get(i);
            prefixSum[i] = sum;
        }
        int min = prefixSum[l - 1] > 0?prefixSum[l - 1]:Integer.MAX_VALUE;
        for (int j = l; j <= r; j++) {
            if (prefixSum[j - 1] > 0 && prefixSum[j - 1] < min) {
                min = prefixSum[j - 1];
            }
            for (int i = j; i < prefixSum.length; i++) {
                if (prefixSum[i] - prefixSum[i - j] > 0 && 
                    prefixSum[i] - prefixSum[i - j] < min) {
                    min = prefixSum[i] - prefixSum[i - j];
                }
            }
        }
        return min == Integer.MAX_VALUE?-1:min;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> inputs = new ArrayList<>();
        inputs.add(-2);
        inputs.add(2);
        inputs.add(-3);
        inputs.add(1);
        System.out.println(solution.minimumSumSubarray(inputs, 2, 3));
    }
}
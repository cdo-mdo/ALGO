package test.leetcode_134;

import java.util.Arrays;

public class Solution {
    public int canCompleteCircuit(int[] gases, int[] costs) {
        if (gases.length != costs.length) {
            return -1;
        }
        int[] remains = new int[gases.length];
        for (int i = 0; i < gases.length; i++) {
            remains[i] = gases[i] - costs[i];
        }
        
        for (int i = 0; i < remains.length; i++) {
            if (remains[i] < 0) {
                continue;
            }
            int remain = 0;
            for (int j = 0; j < remains.length; j++) {
                remain += remains[(i + j) % remains.length];
                if (remain < 0) {
                    break;
                }
            }
            if (remain >= 0) {
                return i;
            }
            
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canCompleteCircuit(new int[] {1, 2, 3, 4, 5}, new int[] {3, 4, 5, 1, 2}));
        System.out.println(solution.canCompleteCircuit(new int[] {2, 3, 4}, new int[] {3, 4, 3}));
        System.out.println(solution.canCompleteCircuit(new int[] {5, 1, 2, 3, 4}, new int[] {4, 4, 1, 5, 1}));
    }
}

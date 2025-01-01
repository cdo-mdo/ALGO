package leetcode.leetcode_274;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Solution {
    public int hIndex(int[] citations) {
        Integer[] cits = new Integer[citations.length];
        for (int i = 0; i < citations.length; i++) {
            cits[i] = citations[i];
        }
        Arrays.sort(cits, Collections.reverseOrder());
        int hIndex = 0;
        for (int i = 0; i < cits.length; i++) {
            if (cits[i] >= i + 1) {
                hIndex = i + 1;
            }
        }
        return hIndex;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hIndex(new int[] {3, 0, 6, 1, 5}));
        System.out.println(solution.hIndex(new int[] {1, 3, 1}));
    }
}

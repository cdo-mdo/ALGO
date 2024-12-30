package leetcode.leetcode_57;

import java.util.Arrays;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int count = 0;
        int[] marks = new int[intervals.length];
        for (int i = 0; i < marks.length; i++) {
            marks[i] = 0;
        }
        int[] mergedInterval = new int[2];
        mergedInterval[0] = newInterval[0];
        mergedInterval[1] = newInterval[1];
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < mergedInterval[0]) {
                // Not overlap with new interval, add to result list before new interval
                count++;
                marks[i] = 1;
            }
            else {
                if (intervals[i][0] > mergedInterval[1]) {
                    // Not overlap with new interval, add to result list after interval
                    count++;
                    marks[i] = 2;
                }
                else {
                    // Overlap with new interval
                    mergedInterval[0] = Math.min(intervals[i][0], mergedInterval[0]);
                    mergedInterval[1] = Math.max(intervals[i][1], mergedInterval[1]);
                }
            }
        }
        
        int[][] res = new int[count + 1][2];
        int index = 0;
        int pos;
        for (pos = 0; pos < intervals.length; pos++) {
            if (marks[pos] == 1) {
                res[index][0] = intervals[pos][0];
                res[index][1] = intervals[pos][1];
                index++;
            }
            else {
                break;
            }
        }
        res[index][0] = mergedInterval[0];
        res[index][1] = mergedInterval[1];
        index++;
        for (int i = 0; i < intervals.length; i++) {
            if (marks[i] == 2) {
                res[index][0] = intervals[i][0];
                res[index][1] = intervals[i][1];
                index++;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.insert(new int[][] {{1, 3}, {6, 9}}, new int[] {2, 5})));
        System.out.println(Arrays.deepToString(solution.insert(
                new int[][] {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[] {4, 8})));
        System.out.println(Arrays.deepToString(solution.insert(new int[][] {{1, 5}}, new int[] {0, 0})));
    }
}

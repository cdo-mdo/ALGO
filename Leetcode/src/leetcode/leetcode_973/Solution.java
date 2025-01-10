package leetcode.leetcode_973;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (k == 0) {
            return null;
        }
        if (k > points.length) {
            return points;
        }
        
        // Use heap to sort points by distance
        PriorityQueue<Double> pQueue = new PriorityQueue<>();
        Map<Double, List<int[]>> maps = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            double distance = Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            pQueue.add(distance);
            List<int[]> arr;
            if (!maps.containsKey(distance)) {
                arr = new ArrayList<>();
            }
            else {
                arr = maps.get(distance);
            }
            arr.add(points[i]);
            maps.put(distance, arr);
        }
        
        int[][] res = new int[k][2];
        // Get k closest points
        int index = 0;
        int i = 0;
        while (i < k) {
            Double distance = pQueue.poll();
            List<int[]> arrs = maps.get(distance);
            for (int[] arr: arrs) {
                res[index++] = arr;
                i++;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][] points = {{1, 3}, {-2, 2}};
        int[][] res = solution.kClosest(points, 1);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i][0] + ", " + res[i][1]);
        }
        
        int[][] points1 = {{3, 3}, {5, -1}, {-2, 4}};
        int[][] res1 = solution.kClosest(points1, 2);
        for (int i = 0; i < res1.length; i++) {
            System.out.println(res1[i][0] + ", " + res1[i][1]);
        }
        
        int[][] points2 = {{0, 1}, {1, 0}};
        int[][] res2 = solution.kClosest(points2, 2);
        for (int i = 0; i < res2.length; i++) {
            System.out.println(res2[i][0] + ", " + res2[i][1]);
        }

    }
}

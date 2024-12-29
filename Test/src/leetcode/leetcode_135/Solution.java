package test.leetcode_135;

import java.util.Arrays;

public class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        for (int i = 0; i < candies.length; i++) {
            candies[i] = 1;
        }
        for (int i = 0; i < ratings.length - 1; i++) {
            if ((ratings[i] < ratings[i + 1]) && (candies[i] >= candies[i + 1])) {
                candies[i + 1] = candies[i] + 1;
            }
            if ((ratings[i] > ratings[i + 1]) && (candies[i] <= candies[i + 1])) {
                candies[i] = candies[i + 1] + 1;
            }
        }
        
        System.out.println(Arrays.toString(candies));
        
        for (int i = 0; i < ratings.length - 1; i++) {
            if ((ratings[i] < ratings[i + 1]) && (candies[i] >= candies[i + 1])) {
                candies[i + 1] = candies[i] + 1;
            }
            if ((ratings[i] > ratings[i + 1]) && (candies[i] <= candies[i + 1])) {
                candies[i] = candies[i + 1] + 1;
            }
        }
        
        System.out.println(Arrays.toString(candies));
        
        int res = 0;
        for (int i = 0; i < candies.length; i++) {
            res += candies[i];
        }
        
        
        return res;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.candy(new int[] {1, 0, 2}));
//        System.out.println(solution.candy(new int[] {1, 2, 2}));
//        System.out.println(solution.candy(new int[] {1, 2, 87, 87, 87, 2, 1}));
        System.out.println(solution.candy(new int[] {1, 6, 10, 8, 7, 3, 2}));
    }
}

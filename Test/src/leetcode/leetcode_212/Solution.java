package leetcode.leetcode_212;

public class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        for (int price: prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            else {
                profit = Math.max(price - minPrice, profit);
            }
        }
        
        return profit;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
    }
}

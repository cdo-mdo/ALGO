package test.singlenumber;

public class Solution {
    public int singleNumber(int[] candidates) {
        int num = 0;
        for (int n: candidates) {
            num ^= n;
        }
        return num;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(new int[] {3, 2, 3}));
    }
}

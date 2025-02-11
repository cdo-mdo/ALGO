package leetcode.leetcode_202;

import java.util.Set;
import java.util.HashSet;

public class Solution {
    public boolean isHappy(int n) {
        int num = n;
        Set<Integer> seen = new HashSet<>();
        while (true) {
            int sum = 0;
            while (num > 0) {
                int digit = num % 10;
                sum += digit * digit;
                num /= 10;
            }
            if (sum == 1) {
                return true;
            }
            if (seen.contains(sum)) {
                return false;
            }
            seen.add(sum);
            num = sum;
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(19));
        System.out.println(solution.isHappy(2));
    }
}

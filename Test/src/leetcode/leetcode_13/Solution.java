package test.leetcode_13;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> RToI = new HashMap<>();
        RToI.put('I', 1);
        RToI.put('V', 5);
        RToI.put('X', 10);
        RToI.put('L', 50);
        RToI.put('C', 100);
        RToI.put('D', 500);
        RToI.put('M', 1000);
    
        Integer prev = Integer.MAX_VALUE;
        Integer res = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer current = RToI.get(s.charAt(i));
            if (current > prev) {
                prev *= -1;
                res += 2*prev;
            }
            else {
            }
            res += current;
            prev = current;
        }
        return res;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("III"));
        System.out.println(solution.romanToInt("LVIII"));
        System.out.println(solution.romanToInt("MCMXCIV"));
    }
}

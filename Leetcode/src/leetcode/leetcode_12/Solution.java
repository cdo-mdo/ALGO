package leetcode.leetcode_12;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return null;
        }
        
        Map<Integer, String> numToStr = new HashMap<>();
        numToStr.put(1,  "I");
        numToStr.put(2,  "II");
        numToStr.put(3,  "III");
        numToStr.put(4,  "IV");
        numToStr.put(5,  "V");
        numToStr.put(6,  "VI");
        numToStr.put(7,  "VII");
        numToStr.put(8,  "VIII");
        numToStr.put(9,  "IX");
        numToStr.put(10,  "X");
        numToStr.put(20,  "XX");
        numToStr.put(30,  "XXX");
        numToStr.put(40,  "XL");
        numToStr.put(50,  "L");
        numToStr.put(60,  "LX");
        numToStr.put(70,  "LXX");
        numToStr.put(80,  "LXXX");
        numToStr.put(90,  "XC");
        numToStr.put(100,  "C");
        numToStr.put(200,  "CC");
        numToStr.put(300,  "CCC");
        numToStr.put(400,  "CD");
        numToStr.put(500,  "D");
        numToStr.put(600,  "DC");
        numToStr.put(700,  "DCC");
        numToStr.put(800,  "DCCC");
        numToStr.put(900,  "CM");
        numToStr.put(1000,  "M");
        numToStr.put(2000,  "MM");
        numToStr.put(3000,  "MMM");
        
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = 0;
        }
        int n = num;
        int index = 3;
        while (n > 0) {
            nums[index--] = n % 10;
            n /= 10;
        }
        
        StringBuilder builder = new StringBuilder();
        if (nums[0] != 0) {
            builder.append(numToStr.get(nums[0]*1000));
        }
        if (nums[1] != 0) {
            builder.append(numToStr.get(nums[1]*100));
        }
        if (nums[2] != 0) {
            builder.append(numToStr.get(nums[2]*10));
        }
        if (nums[3] != 0) {
            builder.append(numToStr.get(nums[3]));
        }
        
        return builder.toString();
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(3749));
        System.out.println(solution.intToRoman(58));
        System.out.println(solution.intToRoman(1994));
    }
}

package test;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static boolean isBalanced(String num) {
        int sumOdd = 0;
        int sumEven = 0;
        for (int i = 0; i < num.length(); i++) {
            int n = Integer.valueOf("" + num.charAt(i));
            if (i % 2 == 0) {
                sumEven += n;
            }
            else {
                sumOdd += n;
            }        
        }
        System.out.println("sumOdd = " + sumOdd);
        System.out.println("sumEven = " + sumEven);
        
        return sumEven == sumOdd? true: false;
    }
    
    public static void main(String[] args) {
    	System.out.println(isBalanced("24123"));
    	
    	List<Integer> list = new ArrayList<>();
    	
    }
}
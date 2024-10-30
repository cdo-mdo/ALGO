package labw1d1.assignment_1_3;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isAnagram(String s, String t) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
        	System.out.print(s.charAt(i) + " ");
            list.add(s.charAt(i));
        }

        for (int i = 0; i < t.length(); i++) {
            if (!list.contains(t.charAt(i))) {
                return false;
            }
            list.remove(Character.valueOf(t.charAt(i)));
        }
        return true;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	
    	System.out.println(solution.isAnagram("anagram", "nagaram"));
    }
}
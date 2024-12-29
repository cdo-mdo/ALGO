package leetcode.contest425.test2;

import java.util.Map;
import java.util.HashMap;

public class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        if (s.length() % k != 0 || t.length() % k != 0) {
            return false;
        }     
        Map<String, Integer> maps = new HashMap<>();
        int i = 0;
        int step = s.length() / k;
        while (i < s.length()) {
            maps.put(s.substring(i, i + step), 1);
            i += step;
        }
        
        i = 0;
        while (i < t.length()) {
            if (maps.containsKey(t.substring(i, i + step))) {
                maps.put(t.substring(i, i + step), maps.get(t.substring(i, i + step)).intValue() - 1);
            }
            i += step;
        }
        
        for (Map.Entry<String, Integer> entries :
            maps.entrySet()) {

           if (entries.getValue() != 0) {
               return false;
           }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String s = "abcd";
        String t = "cdab";
        
        Solution solution = new Solution();
        System.out.println(solution.isPossibleToRearrange(s, t, 2));
    }
}

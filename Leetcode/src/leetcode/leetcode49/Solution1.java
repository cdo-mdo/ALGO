package leetcode.leetcode49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> maps = new HashMap<>();
        for (String str: strs) {
            int[] charCount = new int[26];
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                charCount[c - 'a']++;
            }
            StringBuilder builder = new StringBuilder();
            for (int count: charCount) {
                builder.append(count + ",");
            }
            String key = builder.toString();
            if (maps.containsKey(key)) {
                List<String> list = maps.get(key);
                list.add(str);
            }
            else {
                List<String> newElem = new ArrayList<>();
                newElem.add(str);
                maps.put(key, newElem);
            }
        }
        
        return new ArrayList<>(maps.values());
    }
    
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.groupAnagrams(new String[] {"act", "pots", "tops", "cat", "stop", "hat"}));
    }
}

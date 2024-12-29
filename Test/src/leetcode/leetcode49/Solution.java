package test.leetcode49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return null;
        }
        
        Map<String, List<String>> maps = new HashMap<>();
        for (String str: strs) {
            char[] chrs = str.toCharArray();
            Arrays.sort(chrs);
            String sortedStr = new String(chrs);
            if (maps.containsKey(sortedStr)) {
                List<String> list = maps.get(sortedStr);
                list.add(str);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(str);
                maps.put(sortedStr, list);
            }
        }
        
        return new ArrayList<>(maps.values());
    }
    
    public static void main(String[] args) {
        String[] inputs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution solution = new Solution();
        List<List<String>> res = solution.groupAnagrams(inputs);
        
        res.forEach(l -> {
            System.out.print("[");
            l.forEach(s -> System.out.print(s + " "));
            System.out.println("]");
        });
    }
}

package leetcode.leetcode_30;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length == 0) {
            return res;
        }
        if (words.length * words[0].length() > s.length()) {
            // length of string is less than length of concatenate words, cannot match
            return res;
        }
        
        // Build the word frequency map
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        int wordLen = words[0].length();
        int wordCount = words.length;
        
        // Sliding window for each possible offset
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            int count = 0;
            Map<String, Integer> currentMap = new HashMap<>();
            
            while (right + wordLen <= s.length()) {
                String subStr = s.substring(right, right + wordLen);
                right += wordLen;
                if (map.containsKey(subStr)) {
                    currentMap.put(subStr, currentMap.getOrDefault(subStr, 0) + 1);
                    count++;
                    
                    // Shrink the window if the word frequency exceeds the limit
                    while (currentMap.get(subStr) > map.get(subStr)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentMap.put(leftWord, currentMap.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                    
                    // Check if the window matches all words
                    if (count == wordCount) {
                        res.add(left);
                    }
                }
                else {
                    // reset the window
                    currentMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return res;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findSubstring("barfoothefoobarman", new String[] {"foo", "bar"}));
        System.out.println(solution.findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","word"}));
        System.out.println(solution.findSubstring("barfoofoobarthefoobarman", new String[] {"bar","foo","the"}));
        
    }
}

package leetcode.leetcode_380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedSet {
    private Map<Integer, Integer> maps;
    
    public RandomizedSet() {
        maps = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if (maps.containsKey(val)) {
            return false;
        }
        maps.put(val, val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!maps.containsKey(val)) {
            return false;
        }
        maps.remove(val);
        return true;
    }
    
    public int getRandom() {
        List<Integer> list = new ArrayList<>(maps.values());
        int random = (int)(Math.random()*list.size());
        return maps.get(list.get(random));
    }
    
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        
    }
}

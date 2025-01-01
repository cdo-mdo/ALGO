package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TestClimbStairs {
	public static int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }
	
	public static int climbStairs2(int n) {
        Map<Integer, Integer> steps = new HashMap<>();
        return climb1(n, steps);
    }

    private static int climb1(int n, Map<Integer, Integer> steps) {
        if (steps.containsKey(n)) {
            return steps.get(n);
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        steps.put(n, climb1(n - 1, steps) + climb1(n - 2, steps));
        return steps.get(n);
    }
    
    public static int climbStairs3(int n) {
    	return climb3(0, n);
    }
    
    private static int climb3(int current, int target) {
    	if (current == target) {
    		return 1;
    	}
    	if (current > target) {
    		return 0;
    	}
    	return climb3(current + 1, target) + climb3(current + 2, target);
    	
    }
	
	public static void main(String[] args) {
		System.out.println(TestClimbStairs.climbStairs1(4));
		
		System.out.println(TestClimbStairs.climbStairs2(4));
		
		System.out.println(TestClimbStairs.climbStairs3(4));
	}
}

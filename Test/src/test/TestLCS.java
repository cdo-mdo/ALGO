package test;

import java.util.HashMap;
import java.util.Map;

public class TestLCS {
	public static int lcs(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		if (s1.charAt(0) == s2.charAt(0)) {
			return 1 + lcs(s1.substring(1), s2.substring(1)); 
		} else {
			return Math.max(
					lcs(s1.substring(1), s2), 
					lcs(s1, s2.substring(1)));
		}
	}
	
	public static void main(String[] args) {
//		System.out.println(lcs("ABC", "ACD"));
		TestLCS test = new TestLCS();
		System.out.println(test.climbStairs(1));
		System.out.println(test.climbStairs(2));
		System.out.println(test.climbStairs(3));
		System.out.println(test.climbStairs(4));
		System.out.println(test.climbStairs(5));
		System.out.println(test.climbStairs(6));
	}
	

	public int climbStairs(int n) {
		Map<Integer, Integer> steps = new HashMap<>();
		climb(n, steps);
		return steps.get(n);
	}
	
	private int climb(int n, Map<Integer, Integer> steps) {
		if (steps.containsKey(n)) {
			return steps.get(n);
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		
		steps.put(n, climb(n - 1, steps) + climb(n - 2, steps));
		return steps.get(n);
	}
}

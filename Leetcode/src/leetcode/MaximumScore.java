package leetcode;

public class MaximumScore {
	public int maxScore(String s) {
		int countOne = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				countOne++;
			}
		}
		int countZero = 0;
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				countZero++;
			}
			else {
				countOne--;
			}
			if (sum < countOne + countZero) {
				sum = countOne + countZero;
			}
		}
		return sum;
	}
}

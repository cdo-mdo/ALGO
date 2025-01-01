package leetcode;

public class Test1 {
	public void reverseString(char[] s) {
		int start = 0;
		int end = s.length - 1;
		reverse(start, end, s);
	}

	private void reverse(int start, int end, char[] s) {
		if (start >= end) {
			return;
		}
		char tmp = s[start];
		s[start] = s[end];
		s[end] = tmp;
		reverse(start + 1, end - 1, s);
	}

	public static void main(String[] args) {
		char[] str = {'h', 'e', 'l', 'l', 'o'};
		System.out.println(str);
		Test1 test1 = new Test1();
		test1.reverseString(str);
		System.out.println(str);
	}
}

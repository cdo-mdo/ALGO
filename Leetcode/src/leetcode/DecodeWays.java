package leetcode;

class DecodeWays {
    public static int numDecodings(String s) {
        int count0 = 0;
    	int count1 = 0;
        int count2 = 0;
        if (s.length() > 2) {
        	count0 = 1;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                count1++;
            } else if (s.charAt(i) == '2') {
                if (Integer.valueOf("" + s.charAt(i + 1)) < 7) {
                    count2++;
                }
            }
        }
        return (count1 + count2) *2 + count0;
    }
    
    public static void main(String[] args) {
    	System.out.println(numDecodings("226"));
    }
}

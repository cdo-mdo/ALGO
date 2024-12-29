package leetcode.leetcode45;

public class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int count = 0;
        int farthest = 0;
        int currentEnd = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (farthest < i) {
                return 0;
            }
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                count++;
                currentEnd = farthest;
                if (currentEnd > nums.length - 1) {
                    break;
                }
            }
//            System.out.println("pos = " + i + " farthest = " + farthest + " count = " + count);
        }
        return count;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jump(new int[] {2, 3, 1, 1, 4}));
        System.out.println(solution.jump(new int[] {2, 3, 0, 1, 4}));
        System.out.println(solution.jump(new int[] {1, 2, 1, 1, 1}));
    }
}

package test.leetcode_134;

public class Solution1 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int currentTank = 0;
        int startStation = 0;
        for (int i = 0; i < gas.length; i++) {
            totalTank += gas[i] - cost[i];
            currentTank += gas[i] - cost[i];
            if (currentTank < 0) {
                startStation = i + 1;
                currentTank = 0;
            }
        }
        return totalTank >= 0?startStation: -1;
    }
    
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.canCompleteCircuit(new int[] {1, 2, 3, 4, 5}, new int[] {3, 4, 5, 1, 2}));
        System.out.println(solution.canCompleteCircuit(new int[] {2, 3, 4}, new int[] {3, 4, 3}));
        System.out.println(solution.canCompleteCircuit(new int[] {5, 1, 2, 3, 4}, new int[] {4, 4, 1, 5, 1}));
    }
}

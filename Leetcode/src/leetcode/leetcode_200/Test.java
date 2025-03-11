package leetcode.leetcode_200;

public class Test {
    public void test1(int[][] grid) {
        grid[0][0] = 0;
        grid[0][1] = 0;
    }
    
    public static void main(String[] args) {
        Test test = new Test();
        
        int[][] grid = {{1, 1}};
        System.out.println(grid[0][0] + ", " + grid[0][1]);
        
        test.test1(grid);
        System.out.println(grid[0][0] + ", " + grid[0][1]);
    }
}

import java.util.*;

class Solution {
    private int[][] OFFSETS = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int R = sc.nextInt(), C = sc.nextInt();
    	
    	int[][] grid = new int[R][C];
    	for (int row = 0; row < R; row++) for (int col = 0; col < C; col++) grid[row][col] = sc.nextInt();
    	
    	Solution s = new Solution();
    	System.out.println(s.findMaxArea(grid));
    }
    
    public int findMaxArea(int[][] grid) {
        // code here
        int R = grid.length, C = grid[0].length;
        int max = 0;
        
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (grid[row][col] == 1) {
                    int len = dfs(row, col, R, C, grid);
                    max = Math.max(max, len);
                }
            }
        }
        
        return max;
    }
    
    private int dfs(int row, int col, int R, int C, int[][] grid) {
        grid[row][col] = 0;
        
        int len = 1;
        
        for (int[] D : OFFSETS) {
            int aRow = row + D[0], aCol = col + D[1];
            
            if (0 <= aRow && aRow < R && 0 <= aCol && aCol < C && grid[aRow][aCol] == 1) {
                len += dfs(aRow, aCol, R, C, grid);
            }
        }
        
        return len;
    }
};
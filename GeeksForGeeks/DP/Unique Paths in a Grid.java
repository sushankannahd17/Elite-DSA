class Solution {
    public int uniquePaths(int[][] grid) {
        // code here
        int R=grid.length, C=grid[0].length;
        
        if (grid[0][0]==1 || grid[R-1][C-1]==1) return 0;
        
        int[][] dp=new int[R][C];
        dp[0][0]=1;
        for (int row=1; row<R; row++) {
            if (grid[row][0]==0) {
                dp[row][0]=dp[row-1][0];
            }
        }
        
        for (int col=1; col<C; col++) {
            if (grid[0][col]==0) {
                dp[0][col]=dp[0][col-1];
            }
        }
        for (int row=1; row<R; row++) {
            for (int col=1; col<C; col++) {
                if (grid[row][col]==1) {
                    dp[row][col]=0;
                } else {
                    dp[row][col]=dp[row-1][col]+dp[row][col-1];
                }
            }
        }
        
        return dp[R-1][C-1];
    }
}
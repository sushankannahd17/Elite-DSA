class Solution {
    public void setMatrixZeroes(int[][] grid) {
        // code here
        int R=grid.length, C=grid[0].length;
        
        boolean[] rowFlag=new boolean[R], colFlag=new boolean[C];
        for (int row=0; row<R; row++) {
            for (int col=0; col<C; col++) {
                if (grid[row][col]==0) {
                    rowFlag[row]=true; colFlag[col]=true;
                }
            }
        }
        
        for (int row=0; row<R; row++) {
            if (rowFlag[row]) {
                for (int col=0; col<C; col++) {
                    grid[row][col]=0;
                }
            }
        }
        
        for (int col=0; col<C; col++) {
            if (colFlag[col]) {
                for (int row=0; row<R; row++) {
                    grid[row][col]=0;
                }
            }
        }
    }
}
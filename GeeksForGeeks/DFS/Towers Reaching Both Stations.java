// User function Template for Java

class Solution {
    private int[][] OFFSETS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    public int countCoordinates(int[][] grid) {
        // code here
        int R = grid.length, C = grid[0].length;
        
        boolean[][] pacific = new boolean[R][C], atlantic = new boolean[R][C];
        
        for (int row = 0; row < R; row++) bfs(row, 0, R, C, grid, pacific);
        for (int col = 0; col < C; col++) bfs(0, col, R, C, grid, pacific);
        
        for (int col = 0; col < C; col++) bfs(R - 1, col, R, C, grid, atlantic);
        for (int row = 0; row < R; row++) bfs(row, C - 1, R, C, grid, atlantic);
        
        int ctr = 0;
        
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (pacific[row][col] && atlantic[row][col]) {
                    ctr++;
                }
            }
        }
        
        return ctr;
    }
    
    private void bfs(int row, int col, int R, int C, int[][] grid, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[] {row, col});
        visited[row][col] = true;
        while (!q.isEmpty()) {
            int[] popped = q.poll();
            
            row = popped[0]; col = popped[1];
            for (int[] D : OFFSETS) {
                int aRow = row + D[0], aCol = col + D[1];
                
                if (0 <= aRow && aRow < R && 0 <= aCol && aCol < C && !visited[aRow][aCol] && grid[row][col] <= grid[aRow][aCol]) {
                    q.offer(new int[] {aRow, aCol});
                    visited[aRow][aCol] = true;
                }
            }
        }
    }
}
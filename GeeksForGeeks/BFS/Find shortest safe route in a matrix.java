class Solution {
    public int findShortestPath(int[][] grid) {
        // code here
        int R = grid.length, C = grid[0].length;
        
        int[][] OFFSETS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        Queue<int[]> landmines = new LinkedList<>();
        
        // Finding the landmines
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (grid[row][col] == 0) {
                    landmines.offer(new int[] {row, col});
                }
            }
        }
        
        // Making the adjacent cells of the landmines invalid
        while (!landmines.isEmpty()) {
            int[] popped = landmines.poll();
            int row = popped[0], col = popped[1];
            
            for (int[] D : OFFSETS) {
                int aRow = row + D[0], aCol = col + D[1];
                
                if (0 <= aRow && aRow < R && 0 <= aCol && aCol < C && grid[aRow][aCol] == 1) {
                    grid[aRow][aCol] = 0;
                }
            }
        }
        
        // Normal BFS
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        for (int row = 0; row < R; row++) {
            if (grid[row][0] == 1) queue.offer(new int[] {row, 0, 1});
            visited[row][0] = true;
        }
        
        while (!queue.isEmpty()) {
            int[] popped = queue.poll();
            
            int row = popped[0], col = popped[1], steps = popped[2];
            
            if (col == C - 1) return steps;
            for (int[] D : OFFSETS) {
                int aRow = row + D[0], aCol = col + D[1];
                
                if (0 <= aRow && aRow < R && 0 <= aCol && aCol < C && grid[aRow][aCol] == 1 && !visited[aRow][aCol]) {
                    queue.offer(new int[] {aRow, aCol, steps + 1});
                    visited[aRow][aCol] = true;
                }
            }
        }
        
        return -1;
    }
}

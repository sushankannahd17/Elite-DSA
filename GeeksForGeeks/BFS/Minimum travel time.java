class Solution {
    public int Solve(int N, int[][] grid) {
        // Code Here
        PriorityQueue<int[]> pqueue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[N][N];
        
        pqueue.offer(new int[] {0, 0, grid[0][0]});
        visited[0][0] = true;
        
        int[][] OFFSETS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        
        while (!pqueue.isEmpty()) {
            int[] popped = pqueue.poll();
            
            int row = popped[0], col = popped[1], steps = popped[2];
            
            if (row == N - 1 && col == N - 1) return steps;
            
            for (int[] D : OFFSETS) {
                int aRow = row + D[0], aCol = col + D[1];
                
                if (0 <= aRow && aRow < N && 0 <= aCol && aCol < N && !visited[aRow][aCol]) {
                    pqueue.offer(new int[] {aRow, aCol, Math.max(steps, grid[aRow][aCol])});
                    visited[aRow][aCol] = true;
                }
            }
        }
        
        return -1;
    }
}
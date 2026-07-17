class Solution {
    public int minStepToReachTarget(int knightPos[], int targetPos[], int N) {
        // Code here
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        
        knightPos[0]--; knightPos[1]--; targetPos[0]--; targetPos[1]--;
        
        visited[knightPos[0]][knightPos[1]] = true;
        queue.offer(new int[] {knightPos[0], knightPos[1], 0});
        
        int[][] OFFSETS = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};
        
        while (!queue.isEmpty()) {
            int[] popped = queue.poll();
            
            int row = popped[0], col = popped[1], steps = popped[2];
            
            if (row == targetPos[0] && col == targetPos[1]) return steps;
            for (int[] D : OFFSETS) {
                int aRow = row + D[0], aCol = col + D[1];
                
                if (0 <= aRow && aRow < N && 0 <= aCol && aCol < N && !visited[aRow][aCol]) {
                    visited[aRow][aCol] = true;
                    queue.offer(new int[] {aRow, aCol, steps + 1});
                }
            }
        }
        
        return -1;
    }
}
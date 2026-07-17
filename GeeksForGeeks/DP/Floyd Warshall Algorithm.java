class Solution {
    public void floydWarshall(int[][] dist) {
        // Code here
        int INF = 100_000_000;
        int N = dist.length;
        
        for (int k = 0; k < N; k++) {
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    if (dist[row][k] != INF && dist[k][col] != INF) dist[row][col] = Math.min(dist[row][col], dist[row][k] + dist[k][col]);
                }
            }
        }
    }
}
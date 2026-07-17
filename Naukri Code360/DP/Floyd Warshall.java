import java.util.*;

public class Solution {
  static int floydWarshall(int N, int M, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
    // Write your code here.
    long INF = 1000000000L;

    long[][] grid = new long[N + 1][N + 1];
    for (int row = 1; row <= N; row++) Arrays.fill(grid[row], INF);
    for (int i = 1; i <= N; i++) grid[i][i] = 0;

    for (ArrayList<Integer> lis : edges) {
      int u = lis.get(0), v = lis.get(1), d = lis.get(2);

      grid[u][v] = Math.min(grid[u][v], d);
    }

    for (int k = 1; k <= N; k++) {
      for (int row = 1; row <= N; row++) {
        for (int col = 1; col <= N; col++) {
          if (!(grid[row][k] == INF || grid[k][col] == INF)) grid[row][col] = Math.min(grid[row][k] + grid[k][col], grid[row][col]);
        }
      }
    }

    return (int)(grid[src][dest]);
  }
}
public class Solution {
    public static int maxGoldCollected(int[][] mine, int R, int C) {
       // Write your code here.

       int[][] dp = new int[R][C];
       for (int row = 0; row < R; row++) dp[row][C - 1] = mine[row][C - 1];

       int[][] OFFSETS = {{-1, 1}, {0, 1}, {1, 1}};

       for (int col = C - 2; col >= 0; col--) {
           for (int row = 0; row < R; row++) {
               int max = Integer.MIN_VALUE;

               for (int[] D : OFFSETS) {
                   int aRow = row + D[0], aCol = col + D[1];

                   if (0 <= aRow && aRow < R && 0 <= aCol && aCol < C) {
                       max = Math.max(max, dp[aRow][aCol]);
                   }
               }

               dp[row][col] = mine[row][col] + max;
           }
       }

       int max = Integer.MIN_VALUE; 
       for (int row = 0; row < R; row++) max = Math.max(max, dp[row][0]);

       return max;
    }
}


import java.util.*;

public class Solution {
    public static int minTimeToRot(int R, int C, int[][] grid) {
        // Write your code here
        int fresh = 0;

        Queue<int[]> queue = new LinkedList<>();

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (grid[row][col] == 2) {
                    queue.offer(new int[] {row, col, 0});
                } else if (grid[row][col] == 1) {
                    fresh++;
                }
            }
        }

        int mins = 0;
        int[][] OFFSETS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] pop = queue.poll();
            int row = pop[0], col = pop[1]; mins = Math.max(mins, pop[2]);

            for (int[] D : OFFSETS) {
                int aRow = row + D[0], aCol = col + D[1];

                if (0 <= aRow && aRow < R && 0 <= aCol && aCol < C && grid[aRow][aCol] == 1) {
                    fresh--;
                    queue.offer(new int[] {aRow, aCol, mins + 1});
                    grid[aRow][aCol] = 2;
                }
            }
        }

        return (fresh == 0 ? mins : -1);
    }
}
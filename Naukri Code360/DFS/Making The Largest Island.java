import java.util.*;

public class Solution {
    private static int[][] OFFSETS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static int maximumIslandSize(int[][] grid) {
        // Write your code here
        int R = grid.length, C = grid[0].length;
        int[][] region = new int[R][C];

        Map<Integer, Integer> map = new HashMap<>();
        int idx = 1;

        int maxArea = -1;

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (grid[row][col] == 1 && region[row][col] == 0) {
                    int area = dfs(row, col, R, C, grid, region, idx);
                    map.put(idx, area);
                    maxArea = Math.max(area, maxArea);
                    idx++;
                }
            }
        }

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (grid[row][col] == 0) {
                    maxArea = Math.max(maxArea, checkAdj(row, col, R, C, region, map));
                }
            }
        }

        return maxArea;
    }

    private static int dfs(int row, int col, int R, int C, int[][] grid, int[][] region, int idx) {
        region[row][col] = idx;

        int ctr = 1;

        for (int[] D : OFFSETS) {
            int aRow = row + D[0], aCol = col + D[1];

            if (0 <= aRow && aRow < R && 0 <= aCol && aCol < C && region[aRow][aCol] == 0 && grid[aRow][aCol] == 1) {
                ctr += dfs(aRow, aCol, R, C, grid, region, idx);
            }
        }

        return ctr;
    }

    private static int checkAdj(int row, int col, int R, int C, int[][] region, Map<Integer, Integer> map) {
        Set<Integer> set = new HashSet<>();

        int area = 1;

        for (int[] D : OFFSETS) {
            int aRow = row + D[0], aCol = col + D[1];

            if (0 <= aRow && aRow < R && 0 <= aCol && aCol < C && !set.contains(region[aRow][aCol]) && region[aRow][aCol] != 0) {
                set.add(region[aRow][aCol]);
            }
        }

        for (int reg : set) {
            area += map.get(reg);
        }

        return area;
    }
}
public class Solution {
    private static int[][] OFFSETS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static boolean present(char[][] grid, String word, int R, int C) {
        // Write your code here.
        boolean[][] visited = new boolean[R][C];

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (grid[row][col] == word.charAt(0)) {
                    if (dfs(row, col, R, C, grid, visited, 1, word)) return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(int row, int col, int R, int C, char[][] grid, boolean[][] visited, int idx, String word) {
        if (idx == word.length()) return true;

        visited[row][col] = true;

        for (int[] D : OFFSETS) {
            int aRow = row + D[0], aCol = col + D[1];

            if (0 <= aRow && aRow < R && 0 <= aCol && aCol < C && !visited[aRow][aCol] && grid[aRow][aCol] == word.charAt(idx)) {
                if (dfs(aRow, aCol, R, C, grid, visited, idx + 1, word)) return true;
            }
        }

        visited[row][col] = false;

        return false;
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt(), C = sc.nextInt();
        char[][] grid = new char[R][C];
        boolean[][] visited = new boolean[R][C];
        sc.nextLine();
        for (int row = 0; row < R; row++) {
            grid[row] = sc.nextLine().toCharArray();
        }
        String word = sc.next();
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (word.charAt(0) == grid[row][col]) {
                    if (dfs(row, col, R, C, word, grid, visited, 1, 0)) {
                        System.out.println("YES");
                        return;
                    }
                } else if (word.charAt(1) == grid[row][col]) {
                    if (dfs(row, col, R, C, word, grid, visited, 2, 1)) {
                        System.out.println("YES");
                        return;
                    }
                }
            }
        }
        System.out.println("NO");
    }

    private static int[][] OFFSETS = {{ -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }};

    private static boolean dfs(int row, int col, int R, int C, String word, char[][] grid, boolean[][] visited, int idx, int skipped) {
        if (idx == word.length()) {
            return true;
        }
        visited[row][col] = true;
        for (int[] D : OFFSETS) {
            int aRow = row + D[0], aCol = col + D[1];
            if (0 <= aRow && aRow < R && 0 <= aCol && aCol < C && !visited[aRow][aCol]
                    && word.charAt(idx) == grid[aRow][aCol]) {
                if (dfs(aRow, aCol, R, C, word, grid, visited, idx + 1, skipped))
                    return true;
            }
        }
        if (skipped == 0) {
            if (dfs(row, col, R, C, word, grid, visited, idx + 1, skipped + 1))
                return true;
        }
        visited[row][col] = false;
        return false;
    }
}

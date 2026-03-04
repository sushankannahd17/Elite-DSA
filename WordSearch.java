import java.util.*;

public class WordSearch {
    static int[][] offSets = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    static boolean dfs(int row, int col, int R, int C, boolean[][] visited, char[][] board, String word, int idx) {
        if (idx == word.length()) return true;

        for (int[] D : offSets) {
            int nRow = row + D[0], nCol = col + D[1];

            if (0 <= nRow && nRow < R && 0 <= nCol && nCol < C && !visited[nRow][nCol] && board[nRow][nCol] == word.charAt(idx)) {
                visited[nRow][nCol] = true;
                if (dfs(nRow, nCol, R, C, visited, board, word, idx + 1)) return true;
                visited[nRow][nCol] = false;
            }
        }
        
        return false;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt(), C = sc.nextInt();

        char[][] board = new char[R][C];
        boolean[][] visited = new boolean[R][C];

        for (int row = 0; row < R; row++) board[row] = sc.next().toCharArray();

        String word = sc.next();

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (board[row][col] == word.charAt(0));
                visited[row][col] = true;
                if (dfs(row, col, R, C, visited, board, word, 1)) {
                    System.out.println("YES");
                    return;
                }
                visited[row][col] = false;
            }
        }

        System.out.println("NO");
    }
}
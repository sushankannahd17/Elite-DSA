import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt(), C = sc.nextInt();
        int[][] grid = new int[R][C];
        for (int row = 0; row < R; row++) {
        	for (int col = 0; col < C; col++) {
        		grid[row][col] = sc.nextInt();
        	}
        }
        
        int[][] region = new int[R][C];
        int idx = 1, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (grid[row][col] == 1 && region[row][col] == 0) {
                    int len = dfs(row, col, R, C, grid, region, idx);
                    map.put(idx, len);
                    maxLen = Math.max(maxLen, len);
                    idx++;
                }
            }
        }
        
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (grid[row][col] == 0) {
                    int len = checkAdj(row, col, R, C, region, map);
                    maxLen = Math.max(maxLen, len);
                }
            }
        }
        
        System.out.println(maxLen);
    }
    
    private static int[][] OFFSETS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    private static int dfs(int row, int col, int R, int C, int[][] grid, int[][] region, int idx) {
        region[row][col] = idx;
        int len = 1;
        
        for (int[] D : OFFSETS) {
            int aRow = row + D[0], aCol = col + D[1];
            
            if (0 <= aRow && aRow < R && 0 <= aCol && aCol < C && grid[aRow][aCol] == 1 && region[aRow][aCol] == 0) {
                len += dfs(aRow, aCol, R, C, grid, region, idx);
            }
        }
        
        return len;
    }
    
    private static int checkAdj(int row, int col, int R, int C, int[][] region, Map<Integer, Integer> map) {
        int len = 1;
        Set<Integer> lands = new HashSet<>();
        
        for (int[] D : OFFSETS) {
            int aRow = row + D[0], aCol = col + D[1];
            
            if (0 <= aRow && aRow < R && 0 <= aCol && aCol < C && region[aRow][aCol] != 0) {
                lands.add(region[aRow][aCol]);
            }
        }
        
        for (int land : lands) {
            len += map.get(land);
        }
        
        return len;
    }
}
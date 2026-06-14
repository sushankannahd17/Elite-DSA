import java.util.*;

public class Main {
	private static int[][] OFFSETS = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int R = sc.nextInt(), C = sc.nextInt();
		char[][] grid = new char[R][C];
		
		int a_r = -1, a_c = -1, b_r = -1, b_c = -1;
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				grid[row][col] = sc.next().charAt(0);
				if (grid[row][col] == 'A') {
					a_r = row; a_c = col;
				} else if (grid[row][col] == 'B') {
					b_r = row; b_c = col;
				}
			}
		}
		
		int minSteps1 = -1, minSteps2 = -1;
		
		if (a_r != -1) minSteps1 = bfs(a_r, a_c, R, C, grid);
		if (b_r != -1) minSteps2 = bfs(b_r, b_c, R, C, grid);
		
		if (minSteps1 == minSteps2 && minSteps1 != -1) {
			System.out.println("BOTH");
		} else if (minSteps1 == minSteps2 && minSteps1 == -1) {
			System.out.println("NONE");
		} else {
			System.out.println((minSteps1 > minSteps2) ? "B" : "A");
		}
	}
	
	private static int bfs(int row, int col, int R, int C, char[][] grid) {
		boolean[][] visited = new boolean[R][C];
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {row, col, 0});
		
		while (!q.isEmpty()) {
			int[] pop = q.poll();
			row = pop[0]; col = pop[1];
			int steps = pop[2];
			
			if (grid[row][col] == 'C') return (steps + 1);
			
			for (int[] D : OFFSETS) {
				int aRow = row + D[0], aCol = col + D[1];
				
				if (0 <= aRow && aRow < R && 0 <= aCol && aCol < C && !visited[aRow][aCol] && grid[row][col] != '1') {
					q.add(new int[] {aRow, aCol, steps + 1});
					visited[aRow][aCol] = true;
				}
			}
		}
		
		return -1;
	}
}
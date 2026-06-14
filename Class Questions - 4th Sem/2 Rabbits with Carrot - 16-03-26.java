import java.util.*;

public class Main {
	static int[][] offSets = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
	
	static int bfs(int row, int col, int R, int C, char[][] grid) {
		boolean[][] visited = new boolean[R][C];
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {row, col, 0});
		visited[row][col] = true;
		
		while (!queue.isEmpty()) {
			int[] popped = queue.poll();
			
			row = popped[0]; 
			col = popped[1];
			int steps = popped[2];
			
			for (int[] D : offSets) {
				int aRow = row + D[0], aCol = col + D[1];
				
				if (0 <= aRow && aRow < R && 0 <= aCol && aCol < C && grid[aRow][aCol] != '#' && !visited[aRow][aCol]) {
					if (grid[aRow][aCol] == 'C') return (steps + 1);
					
					queue.add(new int[] {aRow, aCol, steps + 1});
					visited[aRow][aCol] = true;
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int R = sc.nextInt(), C = sc.nextInt();
		
		char[][] grid = new char[R][C];
		for (int row = 0; row < R; row++) grid[row] = sc.next().toCharArray();
		
		int rabbit1R = -1, rabbit1C = -1, rabbit2R = -1, rabbit2C = -1;
		
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				if (grid[row][col] == 'R') {
					if (rabbit1R == -1) {
						rabbit1R = row;
						rabbit1C = col;
					} else {
						rabbit2R = row;
						rabbit2C = col;
					}
				} 
			}
		}
		
		int minSteps1 = -1, minSteps2 = -1;
		
		if (rabbit1R != -1) minSteps1 = bfs(rabbit1R, rabbit1C, R, C, grid);
		if (rabbit2R != -1) minSteps2 = bfs(rabbit2R, rabbit2C, R, C, grid);
		
		if (minSteps1 == minSteps2 && minSteps1 != -1) {
			System.out.println("A & B");
		} else if (minSteps1 == -1 && minSteps2 == -1) {
			System.out.println(-1);
		} else {
			System.out.println((minSteps1 < minSteps2) ? "A" : "B");
		} 
	}
}
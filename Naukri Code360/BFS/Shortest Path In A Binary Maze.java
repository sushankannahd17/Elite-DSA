/*************************************

Following is the Point Class structure

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

**************************************/
import java.util.*;

public class Solution {
	public static int shortestPathBinaryMatrix(int[][] grid, Point src, Point dest) {
		// Write your code here
		if (grid[src.x][src.y] == 0 || grid[dest.x][dest.y] == 0) return -1;

		int R = grid.length, C = grid[0].length;

	 	boolean[][] visited = new boolean[R][C];
		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[] {src.x, src.y, 0});
		visited[src.x][src.y] = true;

		int[][] OFFSETS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

		while (!queue.isEmpty()) {
			int[] pop = queue.poll();

			int row = pop[0], col = pop[1], steps = pop[2];

			if (row == dest.x && col == dest.y) return steps;

			for (int[] D : OFFSETS) {
				int aRow = row + D[0], aCol = col + D[1];

				if (0 <= aRow && aRow < R && 0 <= aCol && aCol < C && !visited[aRow][aCol] && grid[aRow][aCol] == 1) {
					visited[aRow][aCol] = true;
					queue.offer(new int[] {aRow, aCol, steps + 1});
				}
			}
		}

		return -1;
	}
}

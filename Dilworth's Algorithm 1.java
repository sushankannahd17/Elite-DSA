import java.util.*;

public class Main {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int R = sc.nextInt(), C = sc.nextInt();
		
		char[][] grid = new char[R][C];
		for (int row = 0; row < R; row++) grid[row] = sc.next().toCharArray();
		
		int ctr = 0;
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				if (grid[row][col] == 'C') ctr++;
			}
		}
		
		int[][] dp = new int[R][C];
		
		for (int row = R - 1; row >= 0; row--) {
			for (int col = 0; col < C; col++) {
				int max = 0;
				if ((row + 1) < R) max = Math.max(max, dp[row + 1][col]);
				if ((col - 1) >= 0) max = Math.max(max, dp[row][col - 1]);
				max += (grid[row][col] == 'C') ? 1 : 0;
				dp[row][col] = max;
			}
		}		
		
		System.out.println(ctr - dp[0][C - 1]);
	}
}
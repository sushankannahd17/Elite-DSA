import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int R = sc.nextInt(), C = sc.nextInt();
		int[][] grid = new int[R][C];
		
		for (int row = 0; row < R; row++) for (int col = 0; col < C; col++) grid[row][col] = sc.nextInt();
		
		int[][] dp = new int[R][C];
		dp[R - 1][0] = (grid[R - 1][0]==5)?1:0;
		
		for (int col = 1; col < C; col++) dp[R - 1][col] = (dp[R - 1][col - 1] == 1 || grid[R - 1][col] == 5) ? 1 : 0;
		
		for (int row = R - 2; row >= 0; row--) dp[row][0] = (dp[row + 1][0] == 1 || grid[row][0] == 5) ? 1 : 0;
		
		for (int row = R - 2; row >= 0; row--) {
			for (int col = 1; col < C; col++) {
				if (grid[row][col] != 5) {					
					dp[row][col] = Math.max(dp[row + 1][col], dp[row][col - 1]);
				} else {
					dp[row][col] = dp[row + 1][col] + 1;
				}
			}
		}
		
		System.out.println(dp[0][R - 1]);
	}
}
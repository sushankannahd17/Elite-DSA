public class Solution {
	public static int lcs(String s, String t) {
		//Your code goes here
		int R = s.length(), C = t.length();

		int[][] dp = new int[R + 1][C + 1];

		for (int row = 1; row <= R; row++) {
			for (int col = 1; col <= C; col++) {
				if (s.charAt(row - 1) == t.charAt(col - 1)) {
					dp[row][col] = dp[row - 1][col - 1] + 1;
				} else {
					dp[row][col] = Math.max(dp[row][col - 1], dp[row - 1][col]);
				}
			}
		}

		return dp[R][C];
    }
}
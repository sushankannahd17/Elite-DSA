public class Solution {
	public static int maxMoneyLooted(int[] houses) {
		//Your code goes here
		int N = houses.length;

		int[] dp = new int[N + 1];
		dp[1] = houses[0];

		for (int i = 2; i <= N; i++) dp[i] = Math.max(dp[i - 1], dp[i - 2] + houses[i - 1]);

		return dp[N];
	}
}
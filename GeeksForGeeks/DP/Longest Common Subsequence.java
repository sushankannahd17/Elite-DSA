class Solution {
    static int lcs(String s1, String s2) {
        // code here
        int R = s1.length(), C = s2.length();
        int max = 0;
        
        int[][] dp = new int[R + 1][C + 1];
        for (int row = 1; row <= R; row++) {
            for (int col = 1; col <= C; col++) {
                if (s1.charAt(row - 1) == s2.charAt(col - 1)) {
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                    max = Math.max(dp[row][col], max);
                } else {
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
                }
            }
        }
        
        return max;
    }
}
public class Solution {
    public static String findLCS(int R, int C, String s1, String s2){
        // Write your code here.
        int[][] dp=new int[R+1][C+1];

        for (int row=1; row<=R; row++) {
            for (int col=1; col<=C; col++) {
                if (s1.charAt(row-1)==s2.charAt(col-1)) {
                    dp[row][col]=dp[row-1][col-1]+1;
                } else {
                    dp[row][col]=Math.max(dp[row-1][col], dp[row][col-1]);
                }
            }
        }

        int row=R, col=C;
        StringBuilder sb=new StringBuilder();
        while (row>0 && col>0) {
            if (s1.charAt(row-1)==s2.charAt(col-1)) {
                sb.append(s1.charAt(row-1));
                row--; col--;
            } else if (dp[row-1][col]>dp[row][col-1]) {
                row--;
            } else {
                col--;
            }
        }

        sb.reverse();
        return sb.toString();
    }
}